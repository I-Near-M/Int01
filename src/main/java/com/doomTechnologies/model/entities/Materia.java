
package com.doomTechnologies.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Materia {
    private int id;
    private String nombre;
    private int categoriaId;

}

