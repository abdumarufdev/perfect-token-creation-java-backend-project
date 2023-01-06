package com.example.web_toke1.Controller;

import com.example.web_toke1.DTO.API_Respons;
import com.example.web_toke1.DTO.User_Dto;
import com.example.web_toke1.Entity.Webtokinbaza;
import com.example.web_toke1.Services.User_Servis;
import com.example.web_toke1.Tokin_yaratish.Get_Tokin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login2")
public class User_Control2 {

    @Autowired
    User_Servis user_servis;

    @PostMapping
    public HttpEntity<?> Kirish(@RequestBody Webtokinbaza webtokinbaza){
        API_Respons api_respons=user_servis.ADDQOSH(webtokinbaza);
        return ResponseEntity.status(api_respons.isXolat()?200:208).body(api_respons.getHabar());
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> DElete(@PathVariable Integer id){
        API_Respons api_respons=user_servis.DElete(id);
        return ResponseEntity.status(api_respons.isXolat()?200:208).body(api_respons.getHabar());
    }

    @GetMapping("/{id}")
    public HttpEntity<?> Uqish(@PathVariable Integer id){
        API_Respons api_respons=user_servis.IDUQISH(id);
        return ResponseEntity.status(api_respons.isXolat()?200:208).body(api_respons.getHabar());
    }

    @GetMapping
    public HttpEntity<?> UqishHam(){
        API_Respons api_respons=user_servis.UQISH2();
        return ResponseEntity.status(api_respons.isXolat()?200:208).body(api_respons.getHabar());
    }

    @PutMapping("/{id}")
    public HttpEntity<?> Taxrirsh(@PathVariable Integer id,@RequestBody Webtokinbaza webtokinbaza){
        API_Respons api_respons=user_servis.Taxrirla(id,webtokinbaza);
        return ResponseEntity.status(api_respons.isXolat()?200:208).body(api_respons.getHabar());
    }
}
