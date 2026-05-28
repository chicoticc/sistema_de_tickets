package com.lpv.sistematickets.services;

import java.util.List;

import com.lpv.sistematickets.dto.request.UsuarioRequestDTO;
import com.lpv.sistematickets.dto.request.UsuarioUpdateDTO;
import com.lpv.sistematickets.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO getById(Long id);

    UsuarioResponseDTO getByMail(String mail);

    UsuarioResponseDTO save(UsuarioRequestDTO usuario);

    UsuarioResponseDTO update(Long id, UsuarioUpdateDTO usuario);

    void delete(Long id);

}
