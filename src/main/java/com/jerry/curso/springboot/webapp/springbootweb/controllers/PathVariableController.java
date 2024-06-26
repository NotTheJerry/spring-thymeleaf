package com.jerry.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.curso.springboot.webapp.springbootweb.dto.ParamsDto;
import com.jerry.curso.springboot.webapp.springbootweb.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")

public class PathVariableController {

    @Value("${config.username}")
    private String username;

    // @Value("${config.message}")
    // private String message;

    // @Value("${config.listOfValues}")
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',') }")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase() }")
    private String valueString;

    @Value("${config.code}")
    private Integer code;

    @Value( "#{${config.valuesMap}}" )
    private Map<String, Object> valuesMap;

    @Value( "#{${config.valuesMap}.product}" )
    private String product;

    @Value( "#{${config.valuesMap}.price}" )
    private Integer price;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamsDto baz ( @PathVariable String message ) {
        ParamsDto param = new ParamsDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(
        @PathVariable String product,
        @PathVariable Long id
    ) {
        Map <String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        //Hacer algo en la DB

        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values( @Value("${config.message}") String message ) {
        Map <String, Object> json = new HashMap<>();

        Long code2 = environment.getProperty("config.code", Long.class);

        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", code2 );
        json.put("listOfValues", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
        
    }
    

}
