package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.RegistroAula;
import com.doomTechnologies.model.repository.RegistroAulaRepository;
import com.doomTechnologies.model.service.crud.RegistroAulaService;

import java.util.List;

public class RegistroAulaServiceImpl implements RegistroAulaService {
    private final RegistroAulaRepository registroAulaRepository = new RegistroAulaRepository();

    @Override
    public void registrarRegistroAula(RegistroAula registroAula) {
        registroAulaRepository.registrarRegistroAula(registroAula);
    }

    @Override
    public RegistroAula buscarRegistroAula(int idRegistroAula) {
        return registroAulaRepository.buscarRegistroAula(idRegistroAula);
    }

    @Override
    public List<RegistroAula> listarRegistrosAula() {
        return registroAulaRepository.listarRegistrosAula();
    }

    @Override
    public void modificarRegistroAula(RegistroAula registroAula) {
        registroAulaRepository.modificarRegistroAula(registroAula);
    }

    @Override
    public void eliminarRegistroAula(int idRegistroAula) {
        registroAulaRepository.eliminarRegistroAula(idRegistroAula);
    }
}