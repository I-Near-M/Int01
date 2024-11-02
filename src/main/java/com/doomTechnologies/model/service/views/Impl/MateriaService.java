package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Materia;

import java.util.List;

public interface MateriaService {
    void registrarMateria(Materia materia);
    Materia buscarMateria(int id);
    Materia buscarMateria(String nombre);
    List<Materia> listarMaterias();
    void modificarMateria(Materia materia);
    void eliminarMateria(int id);
}