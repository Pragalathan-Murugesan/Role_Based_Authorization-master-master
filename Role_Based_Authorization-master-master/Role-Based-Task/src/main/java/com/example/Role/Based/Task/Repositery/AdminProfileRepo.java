package com.example.Role.Based.Task.Repositery;

import com.example.Role.Based.Task.Entity.AdminProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProfileRepo extends JpaRepository<AdminProfile,Long> {
}
