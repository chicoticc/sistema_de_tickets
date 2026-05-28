package com.lpv.sistematickets.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lpv.sistematickets.dto.request.UsuarioRequestDTO;
import com.lpv.sistematickets.dto.request.UsuarioUpdateDTO;
import com.lpv.sistematickets.dto.response.UsuarioResponseDTO;
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
    public List<UsuarioResponseDTO> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public UsuarioResponseDTO getById(Long id) {
        Usuario usuario = searchById(id);
        return toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO getByMail(String mail) {
        Usuario usuario = usuarioRepository.findByMail(mail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con mail " + mail));
        return toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.findByMail(usuarioRequestDTO.getMail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con el mail " + usuarioRequestDTO.getMail());
        }

        Usuario usuario = new Usuario();
        usuario.setNombres(usuarioRequestDTO.getNombres());
        usuario.setApellidos(usuarioRequestDTO.getApellidos());
        usuario.setMail(usuarioRequestDTO.getMail());
        usuario.setRol(usuarioRequestDTO.getRol());

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return toResponseDTO(usuarioGuardado);
    }

    @Override
    public UsuarioResponseDTO update(Long id, UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuarioExistente = searchById(id);

        usuarioExistente.setNombres(usuarioUpdateDTO.getNombres());
        usuarioExistente.setApellidos(usuarioUpdateDTO.getApellidos());
        usuarioExistente.setRol(usuarioUpdateDTO.getRol());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
        return toResponseDTO(usuarioActualizado);

    }

    @Override
    public void delete(Long id) {
        Usuario usuarioExistente = searchById(id);
        usuarioRepository.delete(usuarioExistente);
    }

    private Usuario searchById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getMail(),
                usuario.getRol());
    }

}
