package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.RegistroDeNotas;

import java.util.List;

public interface RegistroDeNotasService {
    void registrarRegistroDeNotas(RegistroDeNotas registroDeNotas);
    RegistroDeNotas buscarRegistroDeNotas(int idRegistroDeNotas);
    List<RegistroDeNotas> listarRegistrosDeNotas();
    void modificarRegistroDeNotas(RegistroDeNotas registroDeNotas);
    void eliminarRegistroDeNotas(int idRegistroDeNotas);
}