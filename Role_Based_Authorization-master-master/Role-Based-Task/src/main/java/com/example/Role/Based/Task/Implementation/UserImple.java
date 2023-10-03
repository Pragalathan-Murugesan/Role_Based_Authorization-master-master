package com.example.Role.Based.Task.Implementation;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.UserDTO;

public interface UserImple {
    ApiResponse addUser(UserDTO userDTO) throws Exception;


    ApiResponse getAll() throws Exception;

    ApiResponse getById(Long id) throws Exception;
}
