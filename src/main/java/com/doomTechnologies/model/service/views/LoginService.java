package com.doomTechnologies.model.service.views;

import com.doomTechnologies.model.entities.Usuario;

public interface LoginService {
    boolean validarUsuario(String username, String password);
}