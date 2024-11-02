package com.doomTechnologies.model.service.crud.impl;

import com.doomTechnologies.model.entities.RegistroDeNotas;
import com.doomTechnologies.model.repository.RegistroDeNotasRepository;
import com.doomTechnologies.model.service.crud.RegistroDeNotasService;

import java.util.List;

public class RegistroDeNotasServiceImpl implements RegistroDeNotasService {
    private final RegistroDeNotasRepository registroDeNotasRepository = new RegistroDeNotasRepository();

    @Override
    public void registrarRegistroDeNotas(RegistroDeNotas registroDeNotas) {
        registroDeNotasRepository.registrarRegistroDeNotas(registroDeNotas);
    }

    @Override
    public RegistroDeNotas buscarRegistroDeNotas(int idRegistroDeNotas) {
        return registroDeNotasRepository.buscarRegistroDeNotas(idRegistroDeNotas);
    }

    @Override
    public List<RegistroDeNotas> listarRegistrosDeNotas() {
        return registroDeNotasRepository.listarRegistrosDeNotas();
    }

    @Override
    public void modificarRegistroDeNotas(RegistroDeNotas registroDeNotas) {
        registroDeNotasRepository.modificarRegistroDeNotas(registroDeNotas);
    }

    @Override
    public void eliminarRegistroDeNotas(int idRegistroDeNotas) {
        registroDeNotasRepository.eliminarRegistroDeNotas(idRegistroDeNotas);
    }
}