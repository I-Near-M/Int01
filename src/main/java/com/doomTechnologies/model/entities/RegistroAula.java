package com.doomTechnologies.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroAula {
    private int idRegistroAula;
    private String idAula;
    private String idAlumno;
    private int idDocenteMateria;

}
