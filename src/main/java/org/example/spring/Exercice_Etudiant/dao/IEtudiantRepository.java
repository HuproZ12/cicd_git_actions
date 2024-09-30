package org.example.spring.Exercice_Etudiant.dao;

import org.example.spring.Exercice_Etudiant.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IEtudiantRepository extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findByNomContainingIgnoreCase(String recherche);
}