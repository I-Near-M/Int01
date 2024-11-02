package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Grado;

import java.util.List;

public interface GradoService {
    void registrarGrado(Grado grado);
    Grado buscarGrado(int id);
    List<Grado> listarGrados();
    void modificarGrado(Grado grado);
    void eliminarGrado(int id);
}