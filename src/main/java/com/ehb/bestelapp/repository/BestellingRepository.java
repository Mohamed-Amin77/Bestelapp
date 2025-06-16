package com.ehb.bestelapp.repository;

import com.ehb.bestelapp.model.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellingRepository extends JpaRepository<Bestelling, Long> {

   List<Bestelling> findByTechnieker_Email(String email);

   List<Bestelling> findByTechniekerEmail(String email);
}
