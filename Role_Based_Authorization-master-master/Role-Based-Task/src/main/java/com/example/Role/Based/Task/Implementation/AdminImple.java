package com.example.Role.Based.Task.Implementation;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.AdminDTO;

public interface AdminImple {
    ApiResponse addUser(AdminDTO adminDTO) throws Exception;

    ApiResponse login(AdminDTO adminDTO) throws Exception;

    ApiResponse getAll() throws Exception;
}
