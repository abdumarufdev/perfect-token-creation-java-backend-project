package com.example.web_toke1.Tokin_yaratish;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Get_Tokin {
    public  String Tokin1_kalit(String Username){
        Integer vaqt=60*60*100*24;
        Date date=new Date(System.currentTimeMillis()+vaqt);
        String kalit="DavronbekRustamov";

        String tokin = Jwts
                .builder()
                .setSubject(Username)
                .setIssuedAt(new Date())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, kalit)
                .compact();

        return tokin;
    }


    /*public static void main(String[] args) {
        String name="Davronbek";
        System.out.println(Tokin1_kalit(name));
    }*/
}


