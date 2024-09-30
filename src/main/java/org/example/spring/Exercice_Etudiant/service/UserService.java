package org.example.spring.Exercice_Etudiant.service;

import jakarta.servlet.http.HttpSession;
import org.example.spring.Exercice_Etudiant.dao.IUserRepository;
import org.example.spring.Exercice_Etudiant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired private IUserRepository iUserRepository;
    @Autowired private HttpSession httpSession;

    public boolean login(String username, String password) {
        Optional<User> userOptional = iUserRepository.findByUsername(username);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword().equals(password)) {
                httpSession.setAttribute("User", user.getUsername());
                httpSession.setAttribute("Login", "ok");
                return true;
            }
        }
        return false;
    }

    public boolean isLogged() {
        Object loginAttribute = httpSession.getAttribute("Login");
        return loginAttribute != null && loginAttribute.equals("ok");
    }

    public void logout() {
        httpSession.invalidate();
    }
}