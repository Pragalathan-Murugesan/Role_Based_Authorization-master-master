package com.example.Role.Based.Task.Repositery;

import com.example.Role.Based.Task.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile,Long> {
}
