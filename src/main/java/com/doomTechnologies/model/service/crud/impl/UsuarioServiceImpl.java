package com.doomTechnologies.model.service.crud.impl;

import com.doomTechnologies.model.entities.Usuario;
import com.doomTechnologies.model.repository.UsuarioRepository;
import com.doomTechnologies.model.service.crud.UsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    @Override
    public boolean regitrarUsuario(Usuario usuario) {
        return usuarioRepository.registrarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    @Override
    public boolean eliminarUsuario(int id) {
        return usuarioRepository.eliminarUsuario(id);
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        return usuarioRepository.modificarUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuario(int id) {
        return usuarioRepository.buscarUsuario(id);
    }

    @Override
    public Usuario buscarUsuarioPorUsername(String username) {
        return usuarioRepository.buscarUsuario(username);
    }
}
