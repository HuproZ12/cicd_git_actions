package org.example.spring.Exercice_Etudiant.service;

import org.example.spring.Exercice_Etudiant.dao.IEtudiantRepository;
import org.example.spring.Exercice_Etudiant.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private IEtudiantRepository iEtudiantRepository;

    public List<Etudiant> getAllEtudiants() {
        return iEtudiantRepository.findAll();
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {
        Etudiant etuSaved = iEtudiantRepository.save(etudiant);
        return etuSaved;
    }

    public void deleteEtudiant(Etudiant etudiant) {
        iEtudiantRepository.delete(etudiant);
    }

    public List<Etudiant> recherche(String recherche) {
        return iEtudiantRepository.findByNomContainingIgnoreCase(recherche);
    }
}