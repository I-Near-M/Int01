package com.doomTechnologies.Controller.viewscontroller;

import com.doomTechnologies.model.service.views.Impl.LoginServiceImpl;
import com.doomTechnologies.model.service.views.LoginService;

public class LoginController {
    private final LoginService loginService = new LoginServiceImpl();

    public boolean validarUsuario(String username, String password) {
        return loginService.validarUsuario(username, password);
    }
}
