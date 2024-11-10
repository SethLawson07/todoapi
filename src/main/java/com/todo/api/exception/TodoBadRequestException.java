package com.todo.api.exception;

public class TodoBadRequestException  extends RuntimeException{
    
    public TodoBadRequestException(String message){
        super(message);
    }
}
