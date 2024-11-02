package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Rol;
import com.doomTechnologies.model.repository.RolRepository;
import com.doomTechnologies.model.service.crud.RolService;

import java.util.List;

public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository = new RolRepository();

    @Override
    public void registrarRol(Rol rol) {
        rolRepository.registrarRol(rol);
    }

    @Override
    public Rol buscarRol(int id) {
        return rolRepository.buscarRol(id);
    }

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.listarRoles();
    }

    @Override
    public void modificarRol(Rol rol) {
        rolRepository.modificarRol(rol);
    }

    @Override
    public void eliminarRol(int id) {
        rolRepository.eliminarRol(id);
    }
}