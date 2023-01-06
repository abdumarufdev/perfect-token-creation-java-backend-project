package com.example.web_toke1.Tokin_yaratish;

import com.example.web_toke1.Services.User_Servis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Filter extends OncePerRequestFilter {
    @Autowired
    Get_Tokin tokin;

    @Autowired
    User_Servis user_servis;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String auth = request.getHeader("Auth");
        if (auth!=null){
            String s = tokin.Tokin1_kalit(auth);
            if(s!=null){
                UserDetails userDetails = user_servis.loadUserByUsername(s);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationTokin = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationTokin);
            }

        }
        filterChain.doFilter(request,response);
    }
}
