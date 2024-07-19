package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserInfo(JwtAuthenticationToken principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal cannot be null");
        }

        String email = principal.getToken().getClaimAsString("unique_name");
        String name = principal.getToken().getClaimAsString("name");
        String userName = principal.getToken().getClaimAsString("username");
        String phoneNumber = principal.getToken().getClaimAsString("phone_number");
        String address = principal.getToken().getClaimAsString("address");
        String lastLogin = principal.getToken().getClaimAsString("last_login");
//        String userName = principal.getToken().getClaimAsString();
//        String userName = principal.getToken().getClaimAsString();


        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
        }
        return user;
    }
}
