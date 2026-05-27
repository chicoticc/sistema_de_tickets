package com.lpv.sistematickets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpv.sistematickets.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar un usuario por su correo electrónico
    Optional<Usuario> findByMail(String mail);

}
