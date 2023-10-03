package com.example.Role.Based.Task.DTOClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String userName;

    private String emailID;

    private String password;
    private  String role;
}
