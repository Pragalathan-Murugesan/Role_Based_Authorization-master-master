package com.example.Role.Based.Task.Controllr;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.UserDTO;
import com.example.Role.Based.Task.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UserControll {
    @Autowired
    private ApiResponse apiResponse;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/add/user")
    public  ApiResponse addUser(@RequestBody UserDTO userDTO) throws Exception {
        return userService.addUser(userDTO);
    }
    @GetMapping(value = "/users")
    public ApiResponse getAll() throws Exception {
        return userService.getAll();
    }
    @GetMapping(value = "/getbyid/{id}")
    public ApiResponse getById(@PathVariable("id")Long id) throws Exception {
        return userService.getById(id);
    }
}
