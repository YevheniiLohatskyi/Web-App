package com.homework.webapp.exception;

import java.util.UUID;

public class NotFoundEntityException extends Exception {
    public NotFoundEntityException(){
    super("No user found");
}

    public NotFoundEntityException(UUID id){
        super("No user with id " + id);
    }
}
