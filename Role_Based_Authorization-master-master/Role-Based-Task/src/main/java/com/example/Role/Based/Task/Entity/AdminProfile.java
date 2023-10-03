package com.example.Role.Based.Task.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "adminProfileInfo")
public class AdminProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "location")
    private String location;
    @Column(name = "city")
    private  String city;
}
