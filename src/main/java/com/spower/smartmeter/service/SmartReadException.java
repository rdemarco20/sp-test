package com.spower.smartmeter.service;

import javax.ws.rs.WebApplicationException;

public class SmartReadException extends WebApplicationException {

    public SmartReadException(String message) {
        super(message);
    }
}
