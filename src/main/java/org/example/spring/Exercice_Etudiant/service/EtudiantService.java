package org.example.spring.Exercice_Etudiant.service;

import org.example.spring.Exercice_Etudiant.model.Etudiant;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantService {
    private List<Etudiant> etudiants = new ArrayList<>();
    private int compteur = 1;

    public EtudiantService(){
        etudiants.add(new Etudiant(compteur++, "DUTILLEEUX", "Hugo", 25, "hugodtlx@outlook.com"));
        etudiants.add(new Etudiant(compteur++, "DUTOIS", "Jean", 75, "jean.dutois@hotmail.fr"));
        etudiants.add(new Etudiant(compteur++, "BUTCHER", "William", 50, "william.butcher@theboys.us"));
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
        etudiant.setId(compteur++);
        etudiants.add(etudiant);
    }

    public void delete(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    public void update(Etudiant etudiant) {
        for(Etudiant e : etudiants){
            if(e.getId() == etudiant.getId()){
                e.setNom(etudiant.getNom());
                e.setPrenom(etudiant.getPrenom());
                e.setAge(etudiant.getAge());
                e.setMail(etudiant.getMail());
            }
        }
    }
}