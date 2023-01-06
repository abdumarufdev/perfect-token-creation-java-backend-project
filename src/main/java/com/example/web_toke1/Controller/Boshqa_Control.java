package com.example.web_toke1.Controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boshqa_page")
public class Boshqa_Control {
    @GetMapping
    public HttpEntity<?> Korish(){
        return ResponseEntity.ok("boshqa_sahifa");
    }
}
