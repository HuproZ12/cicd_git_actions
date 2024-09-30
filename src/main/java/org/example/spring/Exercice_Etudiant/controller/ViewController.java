package org.example.spring.Exercice_Etudiant.controller;

import jakarta.validation.Valid;
import org.example.spring.Exercice_Etudiant.entity.Etudiant;
import org.example.spring.Exercice_Etudiant.service.EtudiantService;
import org.example.spring.Exercice_Etudiant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class ViewController {

    private String location = "src/main/resources/static/images";

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private UserService userService;

    ///////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/")
    public String home() {
        if (userService.isLogged()) {
            return "Exercice_Etudiant/Accueil";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @GetMapping("/liste-etudiants")
    public String listeEtudiants(Model model) {
        if (userService.isLogged()) {
            model.addAttribute("etudiants", etudiantService.getAllEtudiants());
            return "Exercice_Etudiant/Liste";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @GetMapping("/inscription")
    public String inscription(Model model) {
        if (userService.isLogged()) {
            model.addAttribute("etudiant", new Etudiant());
            return "Exercice_Etudiant/Inscription";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/liste-etudiants")
    public String recherche(@RequestParam("recherche") String recherche, Model model) {
        if (userService.isLogged()) {
            List<Etudiant> etudiants = etudiantService.recherche(recherche);
            model.addAttribute("etudiants", etudiants);
            model.addAttribute("isRecherche", true);
            model.addAttribute("recherche", recherche);
            return "Exercice_Etudiant/Liste";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @PostMapping("/details")
    public String details(@RequestParam(value = "recherche", required = false) String recherche, @ModelAttribute Etudiant etudiant, Model model) {
        if (userService.isLogged()) {
            model.addAttribute("etudiant", etudiant);
            model.addAttribute("recherche", recherche);
            return "Exercice_Etudiant/Details";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @PostMapping("/inscription")
    public String inscription(@RequestParam("image") MultipartFile image, @Valid @ModelAttribute Etudiant etudiant, BindingResult bindingResult) throws IOException {
        if (userService.isLogged()) {
            if (bindingResult.hasErrors()) {
                return "Exercice_Etudiant/Inscription";
            } else {
                Etudiant etuSaved = etudiantService.saveEtudiant(etudiant);
                String filename = "" + etuSaved.getId() + ".png";
                Path destinationFile = Paths.get(location).resolve(filename).toAbsolutePath();
                InputStream inputStream = image.getInputStream();
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                return "redirect:/liste-etudiants";
            }
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @PostMapping("/suppression")
    public String suppression(@ModelAttribute Etudiant etudiant) {
        if (userService.isLogged()) {
            etudiantService.deleteEtudiant(etudiant);
            return "redirect:/liste-etudiants";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @PostMapping("/modification")
    public String modification(@ModelAttribute Etudiant etudiant, Model model) {
        if (userService.isLogged()) {
            model.addAttribute("etudiant", etudiant);
            return "Exercice_Etudiant/Modification";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @PostMapping("/modification-apply")
    public String modificationApply(@ModelAttribute Etudiant etudiant, Model model) {
        if (userService.isLogged()) {
            etudiantService.saveEtudiant(etudiant);
            model.addAttribute("etudiant", etudiant);
            return "Exercice_Etudiant/Details";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }

    @PostMapping("/connexion")
    public String connexion(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean connected = userService.login(username, password);
        if (connected) {
            return "Exercice_Etudiant/Accueil";
        } else {
            return "Exercice_Etudiant/Connexion";
        }
    }
}