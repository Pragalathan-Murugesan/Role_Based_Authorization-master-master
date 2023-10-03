package com.example.Role.Based.Task.GlobalException;

import org.springframework.stereotype.Component;


public class IllegalException extends RuntimeException {
    public IllegalException(String message){
        super(message);
    }
}
