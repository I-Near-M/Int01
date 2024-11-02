package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean regitrarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    boolean eliminarUsuario(int id);
    boolean modificarUsuario(Usuario usuario);
    Usuario buscarUsuario(int id);
    Usuario buscarUsuarioPorUsername(String username);
}
