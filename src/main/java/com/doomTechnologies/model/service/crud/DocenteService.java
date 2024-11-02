package com.doomTechnologies.model.service.crud;

import com.doomTechnologies.model.entities.Docente;

import java.util.List;

public interface DocenteService {
    void registrarDocente(Docente docente);
    Docente buscarDocente(String dni);
    List<Docente> listarDocentes();
    void modificarDocente(Docente docente);
    void eliminarDocente(String dni);
}