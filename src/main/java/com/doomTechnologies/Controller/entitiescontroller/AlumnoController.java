package com.doomTechnologies.Controller.entitiescontroller;

// AlumnoController.java
import com.doomTechnologies.model.entities.Alumno;
import com.doomTechnologies.model.service.crud.AlumnoService;
import com.doomTechnologies.model.service.crud.impl.AlumnoServiceImpl;

import java.util.List;

public class AlumnoController {
    private final AlumnoService alumnoService = new AlumnoServiceImpl();

    public boolean registrarAlumno(Alumno alumno) {
        return alumnoService.registrarAlumno(alumno);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoService.listarAlumnos();
    }

    public boolean eliminarAlumno(String dni) {
        return alumnoService.eliminarAlumno(dni);
    }

    public boolean modificarAlumno(Alumno alumno) {
        return alumnoService.modificarAlumno(alumno);
    }

    public Alumno buscarAlumno(String dni) {
        return alumnoService.buscarAlumno(dni);
    }
}
