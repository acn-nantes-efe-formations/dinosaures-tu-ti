package com.accenture.service;

import com.accenture.exception.DinosaureException;
import com.accenture.model.Dinosaure;
import com.accenture.repository.DinosaureDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DinosaureServiceImpl implements DinosaureService {

    public static final String ID_NON_CONNU = "Id non connu : ";
    private final DinosaureDao dinosaureDao;

    @Value("${annee.courante}")
    private String anneeCourante;

    public DinosaureServiceImpl(DinosaureDao dinosaureDao) {
        this.dinosaureDao = dinosaureDao;
    }

    @Override
    public Dinosaure ajouter(Dinosaure dinosaure) throws DinosaureException {
        verification(dinosaure);

        return dinosaureDao.save(dinosaure);

    }
    @Override
    public void supprimer(int id) throws DinosaureException {
        if (dinosaureDao.existsById(id))
            dinosaureDao.deleteById(id);
        else
            throw new EntityNotFoundException(ID_NON_CONNU + id);
    }

    @Override
    public List<Dinosaure> trouverTous() {
        return dinosaureDao.findAll();
    }

    @Override
    public List<Dinosaure> trouverParDateDecouverte(LocalDate dateDecouverte) {
        return dinosaureDao.findByDateDecouverte(dateDecouverte);
    }
    @Override
    public List<Dinosaure> trouverParDateDecouverteAvant(LocalDate dateDecouverte) {
        return dinosaureDao.findByDateDecouverteAvant(dateDecouverte);
    }
    @Override
    public List<Dinosaure> trouverParDateDecouverteApres(LocalDate dateDecouverte) {
        return dinosaureDao.findByDateDecouverteApres(dateDecouverte);
    }

    @Override
    public Dinosaure trouverParId(int id) {
        return dinosaureDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ID_NON_CONNU + id));
    }

    @Override
    public String getAnneeCourante() {
        return anneeCourante;
    }


    private static void verification(Dinosaure dinosaure) {
        if (dinosaure == null)
            throw new DinosaureException(("Le dino doit exister"));
        if (dinosaure.getEspece() == null  || dinosaure.getEspece().isBlank())
            throw new DinosaureException(("L'espece est obligatoire"));
    }

    @Override
    public long compter() {
        return dinosaureDao.count();
    }
}
