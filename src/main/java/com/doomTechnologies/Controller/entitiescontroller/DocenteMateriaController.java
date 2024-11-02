package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.DocenteMateria;
import com.doomTechnologies.model.service.crud.DocenteMateriaServicio;
import com.doomTechnologies.model.service.crud.impl.DocenteMateriaServicioImpl;

import java.util.List;

public class DocenteMateriaController {
    private final DocenteMateriaServicio docenteMateriaServicio = new DocenteMateriaServicioImpl();

    public void registrarDocenteMateria(DocenteMateria docenteMateria) {
        docenteMateriaServicio.registrarDocenteMateria(docenteMateria);
    }

    public DocenteMateria buscarDocenteMateria(int id) {
        return docenteMateriaServicio.buscarDocenteMateria(id);
    }

    public List<DocenteMateria> listarDocenteMaterias() {
        return docenteMateriaServicio.listarDocenteMaterias();
    }

    public void modificarDocenteMateria(DocenteMateria docenteMateria) {
        docenteMateriaServicio.modificarDocenteMateria(docenteMateria);
    }

    public void eliminarDocenteMateria(int id) {
        docenteMateriaServicio.eliminarDocenteMateria(id);
    }
}