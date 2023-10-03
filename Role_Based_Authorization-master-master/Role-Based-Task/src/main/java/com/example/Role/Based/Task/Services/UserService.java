package com.example.Role.Based.Task.Services;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.AdminDTO;
import com.example.Role.Based.Task.DTOClass.UserDTO;
import com.example.Role.Based.Task.Entity.Admin;
import com.example.Role.Based.Task.Entity.User;
import com.example.Role.Based.Task.Implementation.UserImple;
import com.example.Role.Based.Task.JWTTokens.GenerateToken;
import com.example.Role.Based.Task.Repositery.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserImple {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ApiResponse apiResponse;
    @Autowired
    private GenerateToken generateToken;
  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public ApiResponse addUser(UserDTO userDTO) throws Exception {
        try {
            User user = new User();
         String  bcryptPassword =bCryptPasswordEncoder.encode(userDTO.getPassword());
            user.setUserName(userDTO.getUserName());
            user.setEmailID(userDTO.getEmailID());
            user.setPassword(bcryptPassword);
            userRepo.save(user);
            apiResponse.setMessage("User Added Successfully ");
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setData(user);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return apiResponse;
    }


    @Override
    public ApiResponse getAll() throws Exception {
        try {
            List<User> users = userRepo.findAll();
            apiResponse.setData(users);
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Data Received");
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse getById(Long id) throws Exception {
        try {
            Optional<User> users = userRepo.findId(id);
            apiResponse.setData(users);
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Data Received Without Token");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }
}
