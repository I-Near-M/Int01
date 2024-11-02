package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Apoderado;

import java.util.List;

public interface ApoderadoService {
    boolean registrarApoderado(Apoderado apoderado);
    List<Apoderado> listarApoderados();
    boolean eliminarApoderado(int id);
    boolean modificarApoderado(Apoderado apoderado);
    Apoderado buscarApoderado(int id);
    int registrarApoderadoRetornaID(Apoderado apoderado);
}
