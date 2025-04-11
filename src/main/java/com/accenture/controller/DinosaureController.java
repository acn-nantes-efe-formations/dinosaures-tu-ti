package com.accenture.controller;


import com.accenture.model.Dinosaure;
import com.accenture.service.DinosaureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dinos")
public class DinosaureController {


    private final DinosaureService dinosaureService;

    public DinosaureController(DinosaureService dinosaureService) {
        this.dinosaureService = dinosaureService;
    }


    @GetMapping
    public List<Dinosaure> trouverTous(){
        return dinosaureService.trouverTous();
    }

    @GetMapping("/{id}")
    public Dinosaure trouver(@PathVariable("id") int id){
        return dinosaureService.trouverParId(id);
    }

    @GetMapping("/date/{date}")
    public List<Dinosaure> trouverParDate(@PathVariable("date")LocalDate date){
        return dinosaureService.trouverParDateDecouverte(date);
    }

    @GetMapping("/date/avant/{date}")
    public List<Dinosaure> trouverParDateAvant(@PathVariable("date")LocalDate date){
        return dinosaureService.trouverParDateDecouverteAvant(date);
    }

    @GetMapping("/date/apres/{date}")
    public List<Dinosaure> trouverParDateApres(@PathVariable("date")LocalDate date){
        return dinosaureService.trouverParDateDecouverteApres(date);
    }

    @GetMapping("/count")
    public long compterDinos() {
        return dinosaureService.compter();
    }

    @PostMapping
    public ResponseEntity<Dinosaure> ajouter(@RequestBody Dinosaure dinosaure){
        Dinosaure dinoSauve = dinosaureService.ajouter(dinosaure);
        return ResponseEntity.status(HttpStatus.CREATED).body(dinoSauve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable("id") int id){
        dinosaureService.supprimer(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/annee")
    public String annee(){
        return dinosaureService.getAnneeCourante();
    }
}
