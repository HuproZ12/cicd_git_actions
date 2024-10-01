package org.example.spring_demo_base_01.controller;

import org.example.spring_demo_base_01.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    // Injection de dépendance
    private final GreetingsService greetingsService;

//    @Autowired
    public HelloController(@Qualifier("salutations") GreetingsService greetingsService){
        this.greetingsService = greetingsService;
    }

    @RequestMapping("/")
    public String home(){
        return "hello";
    }

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(greetingsService.sayHello());
        return "hello";
    }

    @RequestMapping("/json")
    // Conversion automatique de la valeur de retour en format JSON
    @ResponseBody
    public List<String> getPersons(){
        return List.of("Toto", "Tata", "Titi");
    }

    @RequestMapping("/person")
    public String personName(Model model){
        model.addAttribute("firstname", "Toto");
        model.addAttribute("lastname", "Doe");

        List<String> persons = List.of("Toto", "Tata", "Titi");

        model.addAttribute("persons", persons);

        return "person/details";
    }
}
