package com.example.Role.Based.Task.GlobalException;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Objects;


@RestControllerAdvice
public class GlobalException {
    @Autowired
      private ApiResponse apiResponse;
    public ApiResponse handleGlobalException(MethodArgumentNotValidException e){
        HashMap<String,Object> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error) ->{
          String fieldError = error.getField();
          String message=error.getDefaultMessage();
          errors.put(fieldError,message);
          apiResponse.setData(errors);
          apiResponse.setMessage("Something Went To Wrong");
          apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());

                });
        return apiResponse;
    }
@ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse IllegalException(IllegalArgumentException e){
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        apiResponse.setData(null);
        apiResponse.setMessage("Unauthorized Access");
        return apiResponse;
    }
    @ExceptionHandler(NotValidException.class)
    public ApiResponse notValidException(NotValidException e){
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        apiResponse.setData(null);
        apiResponse.setMessage("Unauthorized Token Access");
        return apiResponse;
    }
}
