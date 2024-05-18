package com.amiya.smartcontactmanager.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String meesgae) {
        super(meesgae);

    }

    public ResourceNotFoundException() {
        super("Resource Not Found");

    }
}
