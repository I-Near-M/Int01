package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Seccion;
import com.doomTechnologies.model.service.crud.SeccionService;
import com.doomTechnologies.model.service.crud.impl.SeccionServiceImpl;

import java.util.List;

public class SeccionController {
    private final SeccionService seccionService = new SeccionServiceImpl();

    public void registrarSeccion(Seccion seccion) {
        seccionService.registrarSeccion(seccion);
    }

    public Seccion buscarSeccion(int id) {
        return seccionService.buscarSeccion(id);
    }

    public List<Seccion> listarSecciones() {
        return seccionService.listarSecciones();
    }

    public void modificarSeccion(Seccion seccion) {
        seccionService.modificarSeccion(seccion);
    }

    public void eliminarSeccion(int id) {
        seccionService.eliminarSeccion(id);
    }
}