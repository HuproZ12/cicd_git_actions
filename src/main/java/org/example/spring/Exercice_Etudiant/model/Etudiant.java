package org.example.spring.Exercice_Etudiant.model;

import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String mail;
}