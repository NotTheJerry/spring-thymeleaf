package com.jerry.curso.springboot.webapp.springbootweb.controllers;

import com.jerry.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details (Model model) {
        User user = new User("Gerardo", "Gonzalez");
        user.setEmail("gera@correo.com");

        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String list (ModelMap model) {
        
        // model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel () {
        List<User> users = Arrays.asList(
            new User("Pep", "Gonzalez"),
            new User("Lalo", "Perez", "lalo@correo.com"),
            new User("Juanita", "Roe", "juana@correo.com"),
            new User("Andres", "Gonzalez"));
        
        return users;
    }
}
