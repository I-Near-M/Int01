package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Materia;
import com.doomTechnologies.model.service.crud.MateriaService;
import com.doomTechnologies.model.service.crud.impl.MateriaServiceImpl;

import java.util.List;

public class MateriaController {
    private final MateriaService materiaService = new MateriaServiceImpl();

    public void registrarMateria(Materia materia) {
        materiaService.registrarMateria(materia);
    }

    public Materia buscarMateria(int id) {
        return materiaService.buscarMateria(id);
    }

    public Materia buscarMateria(String nombre) {
        return materiaService.buscarMateria(nombre);
    }

    public List<Materia> listarMaterias() {
        return materiaService.listarMaterias();
    }

    public void modificarMateria(Materia materia) {
        materiaService.modificarMateria(materia);
    }

    public void eliminarMateria(int id) {
        materiaService.eliminarMateria(id);
    }
}