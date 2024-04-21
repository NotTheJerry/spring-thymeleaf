package com.jerry.curso.springboot.webapp.springbootweb.controllers;

import com.jerry.curso.springboot.webapp.springbootweb.dto.UserDto;
import com.jerry.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details () {
        UserDto userDto = new UserDto();
        User user = new User("Gerardo", "Gonzalez");

        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list () {
        User user = new User("Gerardo", "Gonzalez");
        User user2 = new User("Pepe", "Doe");
        User user3 = new User("John", "Doe");

        List<User> users = Arrays.asList(user, user2, user3);
//        List<User> users = new ArrayList<>();
//        users.add(user);
//        users.add(user2);
//        users.add(user3);

        return users;
    }


//    public Map<String, Object> details () {
//        User user = new User("Gerardo", "Gonzalez");
//        Map<String, Object> body = new HashMap<>();
//
//        body.put("title", "Hola Mundo Spring Boot");
//        body.put("user", user);
//        return body;
//    }
}
