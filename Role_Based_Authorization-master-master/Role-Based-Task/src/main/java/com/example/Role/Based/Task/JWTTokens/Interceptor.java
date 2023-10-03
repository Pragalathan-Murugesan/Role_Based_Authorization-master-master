package com.example.Role.Based.Task.JWTTokens;

import com.example.Role.Based.Task.ApiResponse.ApiResponse;
import com.example.Role.Based.Task.DTOClass.AdminDTO;
import com.example.Role.Based.Task.DTOClass.UserDTO;
import com.example.Role.Based.Task.GlobalException.IllegalException;
import com.example.Role.Based.Task.GlobalException.NotValidException;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    private GenerateToken generateToken;
    @Autowired
    private ApiResponse apiResponse;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwts = null;
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer")) {
            jwts = token.substring(7, token.length());
        }
        if (!(request.getRequestURI().contains("/admin/api/login")||request.getRequestURI().contains("/admin/api/add/admin") || request.getRequestURI().contains("/user/api/getbyid")||request.getRequestURI().contains("/user/api/add/user"))) {
//            Claims claims = null;
            try {
               Claims claims = generateToken.verifyToken(jwts);
                if (claims.getIssuer().equals("Admin")) {

                    if (!request.getRequestURI().contains("/admin/api")) {
                        throw new NotValidException("Token not Verified");
                    }

                }else if (claims.getIssuer().equals("User")) {

                        if (!request.getRequestURI().contains("/user/api")) {
                            throw  new NotValidException("Token Not Valid");
                        }
                }
            }catch (NotValidException e){
                throw  new NotValidException("Unauthorized Access final");
            }}
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}