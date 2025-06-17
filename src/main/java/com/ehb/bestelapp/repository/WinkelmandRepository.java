package com.ehb.bestelapp.repository;

import com.ehb.bestelapp.model.User;
import com.ehb.bestelapp.model.Winkelmand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WinkelmandRepository extends JpaRepository<Winkelmand, Long> {
    List<Winkelmand> findByTechnieker(User technieker);
    void deleteByTechnieker(User technieker);
}
