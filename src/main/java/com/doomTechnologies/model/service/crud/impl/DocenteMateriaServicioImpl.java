package com.doomTechnologies.model.service.crud.impl;
import com.doomTechnologies.model.entities.DocenteMateria;
import com.doomTechnologies.model.repository.DocenteMateriaRepository;
import com.doomTechnologies.model.service.crud.DocenteMateriaServicio;
import java.util.List;

public class DocenteMateriaServicioImpl implements DocenteMateriaServicio {
    private final DocenteMateriaRepository docenteMateriaRepository = new DocenteMateriaRepository();

    @Override
    public void registrarDocenteMateria(DocenteMateria docenteMateria) {
        docenteMateriaRepository.registrarDocenteMateria(docenteMateria);
    }

    @Override
    public DocenteMateria buscarDocenteMateria(int id) {
        return docenteMateriaRepository.buscarDocenteMateria(id);
    }

    @Override
    public List<DocenteMateria> listarDocenteMaterias() {
        return docenteMateriaRepository.listarDocenteMaterias();
    }

    @Override
    public void modificarDocenteMateria(DocenteMateria docenteMateria) {
        docenteMateriaRepository.modificarDocenteMateria(docenteMateria);
    }

    @Override
    public void eliminarDocenteMateria(int id) {
        docenteMateriaRepository.eliminarDocenteMateria(id);
    }
}
