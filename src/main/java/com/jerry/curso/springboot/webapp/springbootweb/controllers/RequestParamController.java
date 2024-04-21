package com.jerry.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.curso.springboot.webapp.springbootweb.dto.ParamsDto;
import com.jerry.curso.springboot.webapp.springbootweb.dto.ParamsMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamsDto foo( @RequestParam(required = false, defaultValue = "Hola que tal")
                            String message ) {
        ParamsDto param = new ParamsDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/bar")
    public ParamsMixDto bar ( @RequestParam String text, @RequestParam Integer code ) {
        ParamsMixDto params = new ParamsMixDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request")
    public ParamsMixDto request (HttpServletRequest request) {

        ParamsMixDto params = new ParamsMixDto();
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;

    }

}
