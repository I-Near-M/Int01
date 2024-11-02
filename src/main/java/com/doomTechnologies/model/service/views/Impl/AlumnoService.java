package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Alumno;

import java.util.List;

// IAlumnoService.java
public interface AlumnoService {
    boolean registrarAlumno(Alumno alumno);
    List<Alumno> listarAlumnos();
    boolean eliminarAlumno(String dni);
    boolean modificarAlumno(Alumno alumno);
    Alumno buscarAlumno(String dni);
}
