package com.ehb.bestelapp.repository;

import com.ehb.bestelapp.model.Materiaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaalRepository extends JpaRepository<Materiaal, Long> {
    // om toegang te hebben tot standaard database-operaties (save() enz)
}
