package com.proyecto.Libreria.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/all")
    public String buscarLibros(){
        return "Hola";
    };
}
