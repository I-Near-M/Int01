package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Docente;
import com.doomTechnologies.model.service.crud.DocenteService;
import com.doomTechnologies.model.service.crud.impl.DocenteServiceImpl;

import java.util.List;

public class DocenteController {
    private final DocenteService docenteService = new DocenteServiceImpl();

    public void registrarDocente(Docente docente) {
        docenteService.registrarDocente(docente);
    }

    public Docente buscarDocente(String dni) {
        return docenteService.buscarDocente(dni);
    }

    public List<Docente> listarDocentes() {
        return docenteService.listarDocentes();
    }

    public void modificarDocente(Docente docente) {
        docenteService.modificarDocente(docente);
    }

    public void eliminarDocente(String dni) {
        docenteService.eliminarDocente(dni);
    }
}