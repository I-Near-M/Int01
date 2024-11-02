package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Grado;
import com.doomTechnologies.model.repository.GradoRepository;
import com.doomTechnologies.model.service.crud.GradoService;

import java.util.List;

public class GradoServiceImpl implements GradoService {
    private final GradoRepository gradoRepository = new GradoRepository();

    @Override
    public void registrarGrado(Grado grado) {
        gradoRepository.registrarGrado(grado);
    }

    @Override
    public Grado buscarGrado(int id) {
        return gradoRepository.buscarGrado(id);
    }

    @Override
    public List<Grado> listarGrados() {
        return gradoRepository.listarGrados();
    }

    @Override
    public void modificarGrado(Grado grado) {
        gradoRepository.modificarGrado(grado);
    }

    @Override
    public void eliminarGrado(int id) {
        gradoRepository.eliminarGrado(id);
    }
}