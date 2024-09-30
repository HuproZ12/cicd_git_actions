package org.example.spring.Exercice_Etudiant.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.spring.Exercice_Etudiant.validation.ValidNom;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "etudiant")

public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @ValidNom private String nom;
    private String prenom;
    private int age;
    private String mail;
}