package com.Jonas.AppWebOficina.service.exceptions;

/**
 *
 * @author Jonas, created 04/03/2021
 */
public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    //CONSTRUCTOR
    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

}
