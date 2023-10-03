package com.example.Role.Based.Task.JWTTokens;

import com.example.Role.Based.Task.DTOClass.AdminDTO;
import com.example.Role.Based.Task.Entity.Admin;
import com.example.Role.Based.Task.GlobalException.IllegalException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateToken {
    private  static  final String  privateKey= "This Private Key is Admin";
    Long duration = 604800L;
    Long takenTime = System.currentTimeMillis();
    Long expiredTime = duration + takenTime * 1000L;
    Date takenAt = new Date(takenTime);
    Date expiredAt = new Date(expiredTime);
    public String generateTokens(AdminDTO adminDTO){
        Claims claims = Jwts.claims()
                .setExpiration(expiredAt)
                .setIssuedAt(takenAt)
                .setIssuer(adminDTO.getRole());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS384,privateKey).compact();

    }
    public Claims verifyToken(String authorization) throws Exception {
        try {
            Claims claims = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(authorization).getBody();
            return claims;
        }catch (IllegalException e){
            throw  new IllegalException("Unauthorized Access");
        }
    }
}
