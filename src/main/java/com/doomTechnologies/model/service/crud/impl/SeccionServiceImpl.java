package com.doomTechnologies.model.service.crud.impl;

import com.doomTechnologies.model.entities.Seccion;
import com.doomTechnologies.model.repository.SeccionRepository;
import com.doomTechnologies.model.service.crud.SeccionService;

import java.util.List;

public class SeccionServiceImpl implements SeccionService {
    private final SeccionRepository seccionRepository = new SeccionRepository();

    @Override
    public void registrarSeccion(Seccion seccion) {
        seccionRepository.registrarSeccion(seccion);
    }

    @Override
    public Seccion buscarSeccion(int id) {
        return seccionRepository.buscarSeccion(id);
    }

    @Override
    public List<Seccion> listarSecciones() {
        return seccionRepository.listarSecciones();
    }

    @Override
    public void modificarSeccion(Seccion seccion) {
        seccionRepository.modificarSeccion(seccion);
    }

    @Override
    public void eliminarSeccion(int id) {
        seccionRepository.eliminarSeccion(id);
    }
}