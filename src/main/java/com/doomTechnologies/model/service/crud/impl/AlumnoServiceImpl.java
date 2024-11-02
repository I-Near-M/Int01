package com.doomTechnologies.model.service.crud.impl;

// AlumnoService.java
import com.doomTechnologies.model.entities.Alumno;
import com.doomTechnologies.model.repository.AlumnoRepository;
import com.doomTechnologies.model.service.crud.AlumnoService;

import java.util.List;


public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository = new AlumnoRepository();

    @Override
    public boolean registrarAlumno(Alumno alumno) {
        return alumnoRepository.registrarAlumno(alumno);
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.listarAlumnos();
    }

    @Override
    public boolean eliminarAlumno(String dni) {
        return alumnoRepository.eliminarAlumno(dni);
    }

    @Override
    public boolean modificarAlumno(Alumno alumno) {
        return alumnoRepository.modificarAlumno(alumno);
    }

    @Override
    public Alumno buscarAlumno(String dni) {
        return alumnoRepository.buscarAlumno(dni);
    }
}
