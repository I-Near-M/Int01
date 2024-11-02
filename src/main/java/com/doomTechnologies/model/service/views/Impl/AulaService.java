package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Aula;

import java.util.List;

public interface AulaService {
    void registrarAula(Aula aula);
    List<Aula> listarAulas();
    void eliminarAula(String id);
    void modificarAula(Aula aula);
    Aula buscarAula(String id);
}
