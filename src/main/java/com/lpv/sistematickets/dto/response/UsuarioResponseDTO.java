package com.lpv.sistematickets.dto.response;

import com.lpv.sistematickets.enums.RolUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDTO {

    private Long id;
    private String nombres;
    private String apellidos;
    private String mail;
    private RolUsuario rol;

}