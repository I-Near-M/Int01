package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Aula;
import com.doomTechnologies.model.repository.AulaRepository;
import com.doomTechnologies.model.service.crud.AulaService;

import java.util.List;

public class AulaServiceImpl implements AulaService {
    private final AulaRepository aulaRepository = new AulaRepository();

    @Override
    public void registrarAula(Aula aula) {
        aulaRepository.registrarAula(aula);
    }

    @Override
    public List<Aula> listarAulas() {
        return  aulaRepository.listarAulas();
    }

    @Override
    public void eliminarAula(String id) {
         aulaRepository.eliminarAula(id);
    }

    @Override
    public void modificarAula(Aula aula) {
        aulaRepository.modificarAula(aula);
    }

    @Override
    public Aula buscarAula(String id) {
        return aulaRepository.buscarAula(id);
    }
}
