package com.example.web_toke1.Controller;

import com.example.web_toke1.DTO.User_Dto;
import com.example.web_toke1.Services.User_Servis;
import com.example.web_toke1.Tokin_yaratish.Get_Tokin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class User_Controller {

    @Autowired
    User_Servis user_servis;
    @Autowired
    Get_Tokin get_tokin;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public HttpEntity<?> Kirish(@RequestBody User_Dto user_dto){
        //UserDetails userDetails = user_servis.loadUserByUsername(user_dto.getUsername());
        /*boolean equals = userDetails.getPassword().equals(user_dto.getPassword());
        if (equals){
            String s = get_tokin.Tokin1_kalit(user_dto.getUsername());
            return ResponseEntity.ok(s);

        }*/
       // boolean matches = passwordEncoder.matches(user_dto.getPassword(), userDetails.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user_dto.getUsername(), user_dto.getPassword()));
        if (authenticate.isAuthenticated()){
            String s = get_tokin.Tokin1_kalit(user_dto.getUsername());
            return ResponseEntity.ok("profilga Xush kelibsiz --> "+s);
        }
        return ResponseEntity.status(401).body("Login yoki parol hatpo");
    }


}
