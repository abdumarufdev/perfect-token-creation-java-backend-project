package com.example.web_toke1.Repository;

import com.example.web_toke1.Entity.Webtokinbaza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Web_Repository extends JpaRepository<Webtokinbaza,Integer> {
    boolean existsByUsername(String username);
}
