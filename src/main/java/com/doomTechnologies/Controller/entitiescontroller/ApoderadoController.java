package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Apoderado;
import com.doomTechnologies.model.service.crud.ApoderadoService;
import com.doomTechnologies.model.service.crud.impl.ApoderadoServiceImpl;

import java.util.List;

public class ApoderadoController {
    private final ApoderadoService apoderadoService = new ApoderadoServiceImpl();

    public boolean registrarApoderado(Apoderado apoderado) {
        return apoderadoService.registrarApoderado(apoderado);
    }

    public List<Apoderado> listarApoderados() {
        return apoderadoService.listarApoderados();
    }

    public boolean eliminarApoderado(int id) {
        return apoderadoService.eliminarApoderado(id);
    }

    public boolean modificarApoderado(Apoderado apoderado) {
        return apoderadoService.modificarApoderado(apoderado);
    }

    public Apoderado buscarApoderado(int id) {
        return apoderadoService.buscarApoderado(id);
    }
    public int registrarApoderadoRetornaID(Apoderado apoderado) {
        return apoderadoService.registrarApoderadoRetornaID(apoderado);
    }
}