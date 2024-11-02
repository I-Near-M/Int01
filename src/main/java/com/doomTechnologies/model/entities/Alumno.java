/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doomTechnologies.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private char genero;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private int gradoId;
    private int seccionId;
    private int apoderadoId;
    private int usuarioId;
}
