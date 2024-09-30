package org.example.spring.Exercice_Etudiant.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "user")

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String username;
    private String password;
    private String role;

}