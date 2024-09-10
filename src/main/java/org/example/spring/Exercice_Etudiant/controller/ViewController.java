package org.example.spring.Exercice_Etudiant.controller;

import org.example.spring.Exercice_Etudiant.model.Etudiant;
import org.example.spring.Exercice_Etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private EtudiantService etudiantService;

    ///////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/")
    public String home() {
        return "Exercice_Etudiant/Accueil";
    }

    @GetMapping("/liste-etudiants")
    public String listeEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "Exercice_Etudiant/Liste";
    }

    @GetMapping("/inscription")
    public String inscription(Model model) {
        return "Exercice_Etudiant/Inscription";
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/liste-etudiants")
    public String recherche(@RequestParam("recherche") String recherche, Model model) {
        List<Etudiant> etudiants = etudiantService.recherche(recherche);
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("isRecherche", true);
        model.addAttribute("recherche", recherche);
        return "Exercice_Etudiant/Liste";
    }

    @PostMapping("/details")
    public String details(@RequestParam(value = "recherche", required = false) String recherche, @ModelAttribute Etudiant etudiant, Model model) {
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("recherche", recherche);
        return "Exercice_Etudiant/Details";
    }

    @PostMapping("/inscription")
    public String inscription(@ModelAttribute Etudiant etudiant) {
        etudiantService.save(etudiant);
        return "redirect:/liste-etudiants";
    }
}