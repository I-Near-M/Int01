package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.RegistroDeNotas;
import com.doomTechnologies.model.service.crud.RegistroDeNotasService;
import com.doomTechnologies.model.service.crud.impl.RegistroDeNotasServiceImpl;

import java.util.List;

public class RegistroDeNotasController {
    private final RegistroDeNotasService registroDeNotasService = new RegistroDeNotasServiceImpl();

    public void registrarRegistroDeNotas(RegistroDeNotas registroDeNotas) {
        registroDeNotasService.registrarRegistroDeNotas(registroDeNotas);
    }

    public RegistroDeNotas buscarRegistroDeNotas(int idRegistroDeNotas) {
        return registroDeNotasService.buscarRegistroDeNotas(idRegistroDeNotas);
    }

    public List<RegistroDeNotas> listarRegistrosDeNotas() {
        return registroDeNotasService.listarRegistrosDeNotas();
    }

    public void modificarRegistroDeNotas(RegistroDeNotas registroDeNotas) {
        registroDeNotasService.modificarRegistroDeNotas(registroDeNotas);
    }

    public void eliminarRegistroDeNotas(int idRegistroDeNotas) {
        registroDeNotasService.eliminarRegistroDeNotas(idRegistroDeNotas);
    }
}