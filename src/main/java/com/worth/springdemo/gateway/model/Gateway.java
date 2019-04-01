package com.worth.springdemo.gateway.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "gateway")
public class Gateway implements Serializable{
    @Id
    @Column(name = "system_id")
    private String systemId;

    private String name;

    private String module;

    @Column(name = "serial_number")
    private String serialNumber;

    private Integer type;

    private Integer owner;

    private Integer status;

    private String description;

    /**
     * @return system_id
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * @param systemId
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module
     */
    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    /**
     * @return serial_number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return owner
     */
    public Integer getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Gateway{" +
                "systemId='" + systemId + '\'' +
                ", name='" + name + '\'' +
                ", module='" + module + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", type=" + type +
                ", owner=" + owner +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}