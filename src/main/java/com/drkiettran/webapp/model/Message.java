package com.drkiettran.webapp.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Message exchange class.
 * 
 * @author ktran
 *
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 2120914098830910225L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("message")
    private String message;

    public String getName() {
        return name;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdBy;

    @JsonProperty(value="serial-number")
    private long serialNumber;

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Message.class);

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error: {}", e);
        }
        return "Marhsaling error";
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }
}
