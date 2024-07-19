package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/info")
    public User getUserInfo(JwtAuthenticationToken principal) {
        return userService.getUserInfo(principal);
    }

//    @GetMapping("/user/info")
//    public String getUserInfo(@AuthenticationPrincipal OidcUser principal) {
//        if (principal != null) {
//            String email = principal.getEmail();
//            String fullName = principal.getFullName(); // Or concatenate given_name and family_name
//            // Access other claims as needed
//
//            // Example: Persist user info to database
//            // userService.saveUserInfo(email, fullName);
//
//            return "User Info: " + fullName + " - " + email;
//        } else {
//            return "No user info available";
//        }
//    }
}
