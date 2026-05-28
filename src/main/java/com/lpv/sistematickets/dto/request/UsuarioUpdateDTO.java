package com.lpv.sistematickets.dto.request;

import com.lpv.sistematickets.enums.RolUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    private String nombres;
    private String apellidos;
    private RolUsuario rol;

}
