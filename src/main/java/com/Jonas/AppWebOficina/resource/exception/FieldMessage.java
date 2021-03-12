package com.Jonas.AppWebOficina.resource.exception;

import java.io.Serializable;

/**
 *
 * @author Jonas, created 11/03/2021
 */
public class FieldMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    //CONSTRUCTOR
    public FieldMessage() {
    }

    //CONSTRUCTOR
    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    //GET AND SET
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
