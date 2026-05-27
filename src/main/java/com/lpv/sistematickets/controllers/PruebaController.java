package com.lpv.sistematickets.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/api/data")
    public Map<String, Object> sendData() {
        return Map.of("id", 1, "nombre", "Leonel", "mayorEdad", true);
    }

    @GetMapping("/api/prueba")
    public String probarBackend() {
        return "Backend de sistema de tickets funcionando correctamente";
    }

}
