package com.Jonas.AppWebOficina.resource.exception;

/**
 *
 * @author Jonas, created 01/03/2021
 */
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;

    //CONSTRUCTOR
    public StandardError(Long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    //CONSTRUCTOR
    public StandardError() {
    }

    public Long getTimestamp() {
        return timestamp;
    }

    //GET AND SET
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
