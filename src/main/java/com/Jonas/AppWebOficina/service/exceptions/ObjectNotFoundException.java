package com.Jonas.AppWebOficina.service.exceptions;

/**
 *
 * @author Jonas, created 01/03/2021
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1l;

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ObjectNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
