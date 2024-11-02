package com.doomTechnologies.model.service.views.Impl.impl;
import com.doomTechnologies.model.entities.Apoderado;
import com.doomTechnologies.model.repository.ApoderadoRepository;
import com.doomTechnologies.model.service.crud.ApoderadoService;

import java.util.List;


public class ApoderadoServiceImpl implements ApoderadoService {

    private final ApoderadoRepository apoderadoRepository = new ApoderadoRepository();

    @Override
    public boolean registrarApoderado(Apoderado apoderado) {
        return apoderadoRepository.registrarApoderado(apoderado);
    }

    @Override
    public List<Apoderado> listarApoderados() {
        return apoderadoRepository.listarApoderados();
    }

    @Override
    public boolean eliminarApoderado(int id) {
        return apoderadoRepository.eliminarApoderado(id);
    }

    @Override
    public boolean modificarApoderado(Apoderado apoderado) {
        return apoderadoRepository.modificarApoderado(apoderado);
    }

    @Override
    public Apoderado buscarApoderado(int id) {
        return apoderadoRepository.buscarApoderado(id);
    }

    @Override
    public int registrarApoderadoRetornaID(Apoderado apoderado) {
        return apoderadoRepository.registrarApoderadoRetornaID(apoderado);
    }
}
