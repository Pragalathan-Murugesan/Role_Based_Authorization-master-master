package com.example.Role.Based.Task.Controllr;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.AdminDTO;
import com.example.Role.Based.Task.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
public class AdminControll  {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/add/admin")
    public ApiResponse addUser(@RequestBody AdminDTO adminDTO) throws Exception {
        return adminService.addUser(adminDTO);
    }
    @PostMapping(value = "/login")
    public ApiResponse login(@RequestBody AdminDTO adminDTO) throws Exception {
        return adminService.login(adminDTO);
    }

    @GetMapping(value = "/users")
    public ApiResponse getAll() throws Exception {
        return adminService.getAll();
    }
}
