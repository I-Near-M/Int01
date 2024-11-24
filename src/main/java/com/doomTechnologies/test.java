package com.doomTechnologies;

import com.doomTechnologies.model.entities.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {
    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();
        //    private String dni;
        //    private String nombre;
        //    private String apellidoPaterno;
        //    private String apellidoMaterno;
        //    private char genero;
        //    private Date fechaNacimiento;
        //    private String direccion;
        //    private String telefono;
        //    private int gradoId;
        //    private int seccionId;
        //    private int apoderadoId;
        //    private int usuarioId;
        alumnos.add(Alumno.builder().dni("12345678").nombre("Juan").apellidoPaterno("Perez").apellidoMaterno("Gomez").genero('M').fechaNacimiento(null).direccion("Av. Los Alamos 123").telefono("987654321").gradoId(1).seccionId(1).apoderadoId(1).usuarioId(1).build());
        alumnos.add(Alumno.builder().dni("87654321").nombre("Maria").apellidoPaterno("Gomez").apellidoMaterno("Perez").genero('F').fechaNacimiento(null).direccion("Av. Los Pinos 456").telefono("123456789").gradoId(2).seccionId(2).apoderadoId(2).usuarioId(2).build());
        alumnos.add(Alumno.builder().dni("11111111").nombre("Pedro").apellidoPaterno("Gomez").apellidoMaterno("Perez").genero('M').fechaNacimiento(null).direccion("Av. Los Pinos 456").telefono("123456789").gradoId(2).seccionId(2).apoderadoId(2).usuarioId(2).build());

        // Ordenar por nombre
//        alumnos.sort(Comparator.comparing(Alumno::getNombre));
        alumnos.stream().sorted(Comparator.comparing(Alumno::getNombre)).forEach(System.out::println);
        //ordenar por nombre desendentemente
        alumnos.stream().sorted(Comparator.comparing(Alumno::getNombre).reversed()).forEach(System.out::println);

//        // Mostrar los alumnos ordenados
//        for (Alumno alumno : alumnos) {
//            System.out.println(alumno);
//        }




    }
}
