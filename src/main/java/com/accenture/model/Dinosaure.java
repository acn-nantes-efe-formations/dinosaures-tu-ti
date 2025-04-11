package com.accenture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dinosaure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String espece;
    private String prenom;
    private LocalDate dateDecouverte;

    public Dinosaure(String espece, String prenom, LocalDate dateDecouverte) {
        this.espece = espece;
        this.prenom = prenom;
        this.dateDecouverte = dateDecouverte;
    }
}
