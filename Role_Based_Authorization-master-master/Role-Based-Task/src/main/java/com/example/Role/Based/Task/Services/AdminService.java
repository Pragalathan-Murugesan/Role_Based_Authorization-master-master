package com.example.Role.Based.Task.Services;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.AdminDTO;
import com.example.Role.Based.Task.Entity.Admin;
import com.example.Role.Based.Task.Implementation.AdminImple;
import com.example.Role.Based.Task.JWTTokens.GenerateToken;
import com.example.Role.Based.Task.Repositery.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminService implements AdminImple {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private ApiResponse apiResponse;
    @Autowired
    private GenerateToken generateToken;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public ApiResponse addUser(AdminDTO adminDTO) throws Exception {
        try {
            Admin admin = new Admin();
            String becrypt = bCryptPasswordEncoder.encode(adminDTO.getPassword());
            admin.setName(adminDTO.getName());
            admin.setEmailID(adminDTO.getEmailID());
            admin.setPassword(becrypt);
            adminRepo.save(admin);
            apiResponse.setData(admin);
            apiResponse.setMessage("User Added Successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
            return apiResponse;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public ApiResponse login(AdminDTO adminDTO) throws Exception {
        try {
            Admin admin = adminRepo.loginApi(adminDTO.getEmailID());
            adminDTO.setRole(adminDTO.getRole());
            if (admin == null) {
                apiResponse.setMessage("Login Failed");
                apiResponse.setData(null);
                apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                return apiResponse;
            }
            if (bCryptPasswordEncoder.matches(adminDTO.getPassword(), admin.getPassword())) {
                String token = generateToken.generateTokens(adminDTO);
                HashMap<String, Object> data = new HashMap<>();
                data.put("token", token);
                apiResponse.setMessage("Login Successfully");
                apiResponse.setData(data);
                apiResponse.setStatus(HttpStatus.OK.value());
                return apiResponse;
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse getAll() throws Exception {
        try {
            List<Admin> admin = adminRepo.findAll();
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setData(admin);
            apiResponse.setMessage("Data Received");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }
}
