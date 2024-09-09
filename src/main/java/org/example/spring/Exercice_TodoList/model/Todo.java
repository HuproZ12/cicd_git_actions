package org.example.spring.Exercice_TodoList.model;

import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor

public class Todo {
    private String name;
    private String description;
    private boolean isDone;
}