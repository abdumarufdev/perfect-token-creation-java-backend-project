package com.example.web_toke1.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home_page")
public class Home_Control {
    @GetMapping
    public HttpEntity<?> Oqish(){
        return ResponseEntity.ok("Bosh_sahifa");
    }
}
