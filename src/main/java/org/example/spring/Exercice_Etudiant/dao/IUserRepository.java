package org.example.spring.Exercice_Etudiant.dao;

import org.example.spring.Exercice_Etudiant.entity.Etudiant;
import org.example.spring.Exercice_Etudiant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}