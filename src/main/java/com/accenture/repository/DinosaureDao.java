package com.accenture.repository;

import com.accenture.model.Dinosaure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DinosaureDao extends JpaRepository<Dinosaure, Integer> {
    List<Dinosaure> findByDateDecouverte(LocalDate date);

    @Query("SELECT d FROM Dinosaure d WHERE d.dateDecouverte <= ?1")
    List<Dinosaure> findByDateDecouverteAvant(LocalDate dateDecouverte);

    @Query("SELECT d FROM Dinosaure d WHERE d.dateDecouverte >= ?1")
    List<Dinosaure> findByDateDecouverteApres(LocalDate dateDecouverte);
}
