package com.worth.springdemo.util;

import com.worth.springdemo.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Administrator
 * @date 2018/12/3 16:48
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.worth.springdemo.controller.*.*(..))")
    public void webLogPointCut(){}

    @Before("webLogPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLogPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

    @Around(value = "webLogPointCut()")
    public Object  doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retVal = null;
        try {
            retVal = proceedingJoinPoint.proceed();
        }catch (BusinessException e){
            logger.info("AOP Around捕获到异常：" + e.getMessage()) ;
            throw e;
        }
        return retVal;
    }

    @AfterThrowing(value = "webLogPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e){
        logger.info("targetName:" + joinPoint.getTarget().getClass().getName() + joinPoint.getThis().toString());
        logger.info("AOP AfterThrowing" + e.getMessage());
    }
}
