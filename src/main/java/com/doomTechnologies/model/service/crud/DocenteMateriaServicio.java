package com.doomTechnologies.model.service.crud;
import com.doomTechnologies.model.entities.DocenteMateria;
import java.util.List;

public interface DocenteMateriaServicio {
    void registrarDocenteMateria(DocenteMateria docenteMateria);
    DocenteMateria buscarDocenteMateria(int id);
    List<DocenteMateria> listarDocenteMaterias();
    void modificarDocenteMateria(DocenteMateria docenteMateria);
    void eliminarDocenteMateria(int id);
}