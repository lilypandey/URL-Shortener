package com.url.shortener.controllers;


import com.url.shortener.models.User;
import com.url.shortener.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.url.shortener.dtos.RegisterRequest;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    @PostMapping("/public/register")
    public ResponseEntity<?> resgisterUser(@RequestBody RegisterRequest resgisterRequest){
        User user  = new User();
        user.setUsername(resgisterRequest.getUsername());
        user.setPassword(resgisterRequest.getPassword());
        user.setRole("ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok("User registration successful");
    }
}
