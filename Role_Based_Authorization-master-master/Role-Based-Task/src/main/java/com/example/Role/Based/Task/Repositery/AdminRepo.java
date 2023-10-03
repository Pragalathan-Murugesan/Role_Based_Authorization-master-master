package com.example.Role.Based.Task.Repositery;

import com.example.Role.Based.Task.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    @Query(value = "select * from admin_info where emailid = :emailID",nativeQuery = true)
    Admin loginApi(String emailID);
}
