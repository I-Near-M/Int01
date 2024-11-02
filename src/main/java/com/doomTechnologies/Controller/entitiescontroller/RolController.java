package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Rol;
import com.doomTechnologies.model.service.crud.RolService;
import com.doomTechnologies.model.service.crud.impl.RolServiceImpl;

import java.util.List;

public class RolController {
    private final RolService rolService = new RolServiceImpl();

    public void registrarRol(Rol rol) {
        rolService.registrarRol(rol);
    }

    public Rol buscarRol(int id) {
        return rolService.buscarRol(id);
    }

    public List<Rol> listarRoles() {
        return rolService.listarRoles();
    }

    public void modificarRol(Rol rol) {
        rolService.modificarRol(rol);
    }

    public void eliminarRol(int id) {
        rolService.eliminarRol(id);
    }
}