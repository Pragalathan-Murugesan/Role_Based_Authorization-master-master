package com.example.Role.Based.Task.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "adminInfo")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private  String name;
    @Column(name = "emailID")
    private String emailID;
    @Column(name = "password")
    private String password;


}
