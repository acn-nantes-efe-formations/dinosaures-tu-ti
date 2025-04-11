package com.accenture.service;


import com.accenture.exception.DinosaureException;
import com.accenture.model.Dinosaure;

import java.time.LocalDate;
import java.util.List;

public interface DinosaureService {
    Dinosaure ajouter(Dinosaure dinosaure) throws DinosaureException;
    void supprimer(int id) throws DinosaureException;
    List<Dinosaure> trouverTous();
    List<Dinosaure> trouverParDateDecouverte(LocalDate dateDecouverte);

    List<Dinosaure> trouverParDateDecouverteAvant(LocalDate dateDecouverte);

    List<Dinosaure> trouverParDateDecouverteApres(LocalDate dateDecouverte);

    Dinosaure trouverParId(int id);

    String getAnneeCourante();
    long compter();
}
