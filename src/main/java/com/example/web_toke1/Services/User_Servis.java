package com.example.web_toke1.Services;

import com.example.web_toke1.DTO.API_Respons;
import com.example.web_toke1.DTO.User_Dto;
import com.example.web_toke1.Entity.Webtokinbaza;
import com.example.web_toke1.Repository.Web_Repository;
import com.example.web_toke1.Tokin_yaratish.Get_Tokin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class User_Servis implements UserDetailsService {

    @Autowired
    Web_Repository web_repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user_list=new ArrayList<>(
                Arrays.asList(
                        new User("DavronbekR",passwordEncoder.encode("123"),new ArrayList<>()),
                        new User("DavronbekRustamov",passwordEncoder.encode("456"),new ArrayList<>()),
                        new User("Rustamov",passwordEncoder.encode("789"),new ArrayList<>())
                )
        );

        for (User user : user_list) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }




   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean b = web_repository.existsByUsername(username);
        if (b){

        }
        return null;
    }*/

    public API_Respons ADDQOSH(Webtokinbaza webtokinbaza) {
        web_repository.save(webtokinbaza);
        return new API_Respons("Saqlandi",true);
    }

    public API_Respons DElete(Integer id) {
        web_repository.deleteById(id);
        return new API_Respons("uchirildi",true);
    }

    public API_Respons IDUQISH(Integer id) {
        Optional<Webtokinbaza> byId = web_repository.findById(id);
        if (byId.isPresent()){
            return new API_Respons(byId.toString(),true);
        }
        return new API_Respons("bunday id mavjud emas",false);

    }

    public API_Respons UQISH2() {
        List<Webtokinbaza> all = web_repository.findAll();
        return new API_Respons(all.toString(),true);
    }
    public API_Respons Taxrirla(Integer id, Webtokinbaza webtokinbaza) {
        Optional<Webtokinbaza> byId = web_repository.findById(id);
        if (byId.isPresent()) {
            Webtokinbaza webtokinbaza1 = byId.get();
            if (webtokinbaza.getUsername() == "") {
                webtokinbaza1.setUsername(webtokinbaza1.getUsername());
            } else {
                webtokinbaza1.setUsername(webtokinbaza.getUsername());
            }
            if (webtokinbaza.getEmail() == "") {
                webtokinbaza1.setEmail(webtokinbaza1.getEmail());
            } else {
                webtokinbaza1.setEmail(webtokinbaza.getEmail());
            }
            if (webtokinbaza.getPassword() == "") {
                webtokinbaza1.setPassword(webtokinbaza1.getPassword());
            } else {
                webtokinbaza1.setPassword(webtokinbaza.getPassword());
            }
            web_repository.save(webtokinbaza1);
            return new API_Respons("taxrirlandi",true);
        }
        return new API_Respons("taxririlanmadi",false);
    }

}
