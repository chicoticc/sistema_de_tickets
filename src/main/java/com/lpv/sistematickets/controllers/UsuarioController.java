package com.lpv.sistematickets.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpv.sistematickets.dto.request.UsuarioRequestDTO;
import com.lpv.sistematickets.dto.request.UsuarioUpdateDTO;
import com.lpv.sistematickets.dto.response.UsuarioResponseDTO;
import com.lpv.sistematickets.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity<UsuarioResponseDTO> getByMail(@PathVariable String mail) {
        return ResponseEntity.ok(usuarioService.getByMail(mail));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable Long id,
            @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        return ResponseEntity.ok(usuarioService.update(id, usuarioUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}