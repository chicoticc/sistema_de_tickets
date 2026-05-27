package com.lpv.sistematickets.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lpv.sistematickets.entities.Usuario;
import com.lpv.sistematickets.repositories.UsuarioRepository;
import com.lpv.sistematickets.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
    }

    @Override
    public Usuario getByMail(String mail) {
        return usuarioRepository.findByMail(mail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con mail " + mail));
    }

    @Override
    public Usuario save(Usuario usuario) {
        if (usuarioRepository.findByMail(usuario.getMail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con el mail " + usuario.getMail());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioExistente = getById(id);

        usuarioExistente.setNombres(usuario.getNombres());
        usuarioExistente.setApellidos(usuario.getApellidos());
        usuarioExistente.setRol(usuario.getRol());
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void delete(Long id) {
        Usuario usuarioExistente = getById(id);
        usuarioRepository.delete(usuarioExistente);
    }

}
