package com.example.Role.Based.Task.DTOClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {

    private  String name;
    private String emailID;
    private  String password;
    private String role;
}
