package com.lpv.sistematickets.dto.request;

import com.lpv.sistematickets.enums.RolUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDTO {

    private String nombres;
    private String apellidos;
    private String mail;
    private RolUsuario rol;

}
