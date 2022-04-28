package org.spikeboot.spring.rest.exceptions;

public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
