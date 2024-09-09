package org.example.spring.Exercice_Etudiant.controller;

import org.example.spring.Exercice_Etudiant.model.Etudiant;
import org.example.spring.Exercice_Etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/")
    public String home() {
        return "Exercice_Etudiant/Accueil";
    }

    @GetMapping("/liste-etudiants")
    public String listeEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "Exercice_Etudiant/Liste";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") int id, Model model) {
        Etudiant etudiant = etudiantService.getById(id);
        model.addAttribute("etudiant", etudiant);
        return "Exercice_Etudiant/Details";
    }

    @GetMapping("/recherche")
    public String recherche(@RequestParam("nom") String nom, Model model) {
        List<Etudiant> etudiants = etudiantService.recherche(nom);
        model.addAttribute("etudiants", etudiants);
        return "Exercice_Etudiant/Recherche";
    }
}


