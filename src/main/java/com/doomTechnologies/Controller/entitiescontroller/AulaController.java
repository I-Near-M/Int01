package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Aula;
import com.doomTechnologies.model.service.crud.AulaService;
import com.doomTechnologies.model.service.crud.impl.AulaServiceImpl;

import java.util.List;

public class AulaController {
    private final AulaService aulaService = new AulaServiceImpl();

    public void registrarAula(Aula aula) {
        aulaService.registrarAula(aula);
    }

    public List<Aula> listarAulas() {
        return aulaService.listarAulas();
    }

    public void eliminarAula(String id) {
        aulaService.eliminarAula(id);
    }

    public void modificarAula(Aula aula) {
        aulaService.modificarAula(aula);
    }

    public Aula buscarAula(String id) {
        return aulaService.buscarAula(id);
    }
}