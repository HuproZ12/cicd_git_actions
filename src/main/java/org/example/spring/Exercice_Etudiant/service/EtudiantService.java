package org.example.spring.Exercice_Etudiant.service;

import org.example.spring.Exercice_Etudiant.model.Etudiant;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantService {
    private List<Etudiant> etudiants = new ArrayList<>();

    public EtudiantService() {
        etudiants.add(new Etudiant(7, "DUTILLEEUX", "Hugo", 25, "hugodtlx@outlook.com"));
        etudiants.add(new Etudiant(10, "DUTOIS", "Jean", 75, "jean.dutois@hotmail.fr"));
        etudiants.add(new Etudiant(12, "BUTCHER", "William", 50, "william.butcher@theboys.us"));
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiants;
    }

    public List<Etudiant> recherche(String recherche) {
        List<Etudiant> matchs = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNom().toLowerCase().contains(recherche.toLowerCase())) {
                matchs.add(etudiant);
            }
        }
        return matchs;
    }

    public void save(Etudiant etudiant) {
        etudiants.add(etudiant);
    }
}