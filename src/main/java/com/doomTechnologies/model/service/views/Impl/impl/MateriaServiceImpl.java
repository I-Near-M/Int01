package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Materia;
import com.doomTechnologies.model.repository.MateriaRepository;
import com.doomTechnologies.model.service.crud.MateriaService;

import java.util.List;

public class MateriaServiceImpl implements MateriaService {
    private final MateriaRepository materiaRepository = new MateriaRepository();

    @Override
    public void registrarMateria(Materia materia) {
        materiaRepository.registrarMateria(materia);
    }

    @Override
    public Materia buscarMateria(int id) {
        return materiaRepository.buscarMateria(id);
    }

    @Override
    public Materia buscarMateria(String nombre) {
        return materiaRepository.buscarMateria(nombre);
    }

    @Override
    public List<Materia> listarMaterias() {
        return materiaRepository.listarMaterias();
    }

    @Override
    public void modificarMateria(Materia materia) {
        materiaRepository.modificarMateria(materia);
    }

    @Override
    public void eliminarMateria(int id) {
        materiaRepository.eliminarMateria(id);
    }
}