package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.RegistroAula;
import com.doomTechnologies.model.service.crud.RegistroAulaService;
import com.doomTechnologies.model.service.crud.impl.RegistroAulaServiceImpl;

import java.util.List;

public class RegistroAulaController {
    private final RegistroAulaService registroAulaService = new RegistroAulaServiceImpl();

    public void registrarRegistroAula(RegistroAula registroAula) {
        registroAulaService.registrarRegistroAula(registroAula);
    }

    public RegistroAula buscarRegistroAula(int idRegistroAula) {
        return registroAulaService.buscarRegistroAula(idRegistroAula);
    }

    public List<RegistroAula> listarRegistrosAula() {
        return registroAulaService.listarRegistrosAula();
    }

    public void modificarRegistroAula(RegistroAula registroAula) {
        registroAulaService.modificarRegistroAula(registroAula);
    }

    public void eliminarRegistroAula(int idRegistroAula) {
        registroAulaService.eliminarRegistroAula(idRegistroAula);
    }
}