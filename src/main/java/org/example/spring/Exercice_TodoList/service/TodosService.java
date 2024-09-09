package org.example.spring.Exercice_TodoList.service;

import org.example.spring.Exercice_TodoList.model.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodosService {
    private List<Todo> todos = new ArrayList<>();

    public TodosService() {
        todos.add(new Todo("Tâche 1", "Description de la tâche 1", false));
        todos.add(new Todo("Tâche 2", "Description de la tâche 2", true));
    }

    public Todo getOneTodo(int index) {
        return todos.get(index);
    }

    public List<Todo> getAllTodos() {
        return todos;
    }
}