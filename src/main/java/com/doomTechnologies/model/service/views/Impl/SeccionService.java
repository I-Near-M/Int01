package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Seccion;

import java.util.List;

public interface SeccionService {
    void registrarSeccion(Seccion seccion);
    Seccion buscarSeccion(int id);
    List<Seccion> listarSecciones();
    void modificarSeccion(Seccion seccion);
    void eliminarSeccion(int id);
}