/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doomTechnologies.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class RegistroDeNotas {
    private int idRegistroDeNotas;
    private int idRegistroAula;
    private float bimestre1;
    private float bimestre2;
    private float bimestre3;
    private float bimestre4;
    private float promedioFinal;

}
