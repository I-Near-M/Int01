package com.doomTechnologies.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apoderado {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
}
