package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Usuario;
import com.doomTechnologies.model.service.crud.UsuarioService;
import com.doomTechnologies.model.service.crud.impl.UsuarioServiceImpl;

public class UsuarioController {

        private final UsuarioService usuarioService = new UsuarioServiceImpl();

        public boolean regitrarUsuario(Usuario usuario) {
            return usuarioService.regitrarUsuario(usuario);
        }

        public boolean eliminarUsuario(int id) {
            return usuarioService.eliminarUsuario(id);
        }

        public boolean modificarUsuario(Usuario usuario) {
            return usuarioService.modificarUsuario(usuario);
        }

        public Usuario buscarUsuario(int id) {
            return usuarioService.buscarUsuario(id);
        }

        public Usuario buscarUsuarioPorUsername(String username) {
            return usuarioService.buscarUsuarioPorUsername(username);
        }




}
