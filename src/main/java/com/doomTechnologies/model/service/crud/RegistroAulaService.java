package com.doomTechnologies.model.service.crud;

import com.doomTechnologies.model.entities.RegistroAula;

import java.util.List;

public interface RegistroAulaService {
    void registrarRegistroAula(RegistroAula registroAula);
    RegistroAula buscarRegistroAula(int idRegistroAula);
    List<RegistroAula> listarRegistrosAula();
    void modificarRegistroAula(RegistroAula registroAula);
    void eliminarRegistroAula(int idRegistroAula);
}