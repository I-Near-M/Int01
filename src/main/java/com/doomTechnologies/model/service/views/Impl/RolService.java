package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Rol;

import java.util.List;

public interface RolService {
    void registrarRol(Rol rol);
    Rol buscarRol(int id);
    List<Rol> listarRoles();
    void modificarRol(Rol rol);
    void eliminarRol(int id);
}