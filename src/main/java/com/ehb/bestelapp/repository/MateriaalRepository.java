package com.ehb.bestelapp.repository;

import com.ehb.bestelapp.model.Materiaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Deze import heb je nodig voor List

@Repository
public interface MateriaalRepository extends JpaRepository<Materiaal, Long> {

    // Alle standaardmethodes zoals save(), findById(), findAll(), deleteById()
    // worden automatisch voorzien door JpaRepository.

    // Extra methode die Spring automatisch implementeert:
    // Haal alle materialen op die behoren tot een bepaalde categorie.
    List<Materiaal> findByCategorie(String categorie);
}
