package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Grado;
import com.doomTechnologies.model.service.crud.GradoService;
import com.doomTechnologies.model.service.crud.impl.GradoServiceImpl;

import java.util.List;

public class GradoController {
    private final GradoService gradoService = new GradoServiceImpl();

    public void registrarGrado(Grado grado) {
        gradoService.registrarGrado(grado);
    }

    public Grado buscarGrado(int id) {
        return gradoService.buscarGrado(id);
    }

    public List<Grado> listarGrados() {
        return gradoService.listarGrados();
    }

    public void modificarGrado(Grado grado) {
        gradoService.modificarGrado(grado);
    }

    public void eliminarGrado(int id) {
        gradoService.eliminarGrado(id);
    }
}