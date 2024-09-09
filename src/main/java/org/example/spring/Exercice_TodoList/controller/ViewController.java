package org.example.spring.Exercice_TodoList.controller;

import org.example.spring.Exercice_TodoList.model.Todo;
import org.example.spring.Exercice_TodoList.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private TodosService todosService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/todo/{index}")
    public String todo(@PathVariable int index, Model model) {
        model.addAttribute("todo", todosService.getOneTodo(index-1));
        return "todo";
    }

    @GetMapping("/todos")
    @ResponseBody
    public List<Todo> todos() {
        return todosService.getAllTodos();
    }
}