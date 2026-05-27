package com.lpv.sistematickets.services;

import java.util.List;
import com.lpv.sistematickets.entities.Usuario;

public interface UsuarioService {

    List<Usuario> getAll();

    Usuario getById(Long id);

    Usuario getByMail(String mail);

    Usuario save(Usuario usuario);

    Usuario update(Long id, Usuario usuario);

    void delete(Long id);

}
