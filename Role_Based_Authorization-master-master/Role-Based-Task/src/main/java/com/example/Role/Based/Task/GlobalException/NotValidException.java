package com.example.Role.Based.Task.GlobalException;

public class NotValidException extends RuntimeException{
   public NotValidException(String message){
       super((String) message);
   }
}
