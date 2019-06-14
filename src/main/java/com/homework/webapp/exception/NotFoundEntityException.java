package com.homework.webapp.exception;

public class NotFoundEntityException extends Exception {
    public NotFoundEntityException() {
        super("No entity found");
    }
}
