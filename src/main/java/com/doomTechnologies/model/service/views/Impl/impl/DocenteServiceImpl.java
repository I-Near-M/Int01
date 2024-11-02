package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Docente;
import com.doomTechnologies.model.repository.DocenteRepository;
import com.doomTechnologies.model.service.crud.DocenteService;

import java.util.List;

public class DocenteServiceImpl implements DocenteService {
    private final DocenteRepository docenteRepository = new DocenteRepository();

    @Override
    public void registrarDocente(Docente docente) {
        docenteRepository.registrarDocente(docente);
    }

    @Override
    public Docente buscarDocente(String dni) {
        return docenteRepository.buscarDocente(dni);
    }

    @Override
    public List<Docente> listarDocentes() {
        return docenteRepository.listarDocentes();
    }

    @Override
    public void modificarDocente(Docente docente) {
        docenteRepository.modificarDocente(docente);
    }

    @Override
    public void eliminarDocente(String dni) {
        docenteRepository.eliminarDocente(dni);
    }
}