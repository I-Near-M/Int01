package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.Controller.entitiescontroller.UsuarioController;
import com.doomTechnologies.model.entities.Usuario;
import com.doomTechnologies.model.service.views.LoginService;

public class LoginServiceImpl implements LoginService {
    private final UsuarioController usuarioController = new UsuarioController();

    @Override
    public boolean validarUsuario(String username, String password) {
        Usuario usuario = usuarioController.buscarUsuarioPorUsername(username);
        return usuario != null && usuario.getPassword().equals(password);
    }
}