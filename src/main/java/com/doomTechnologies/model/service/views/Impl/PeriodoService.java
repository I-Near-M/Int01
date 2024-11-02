package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Periodo;

import java.util.List;

public interface PeriodoService {
    void registrarPeriodo(Periodo periodo);
    Periodo buscarPeriodo(int id);
    Periodo buscarPeriodoPorAño(int año);
    List<Periodo> listarPeriodos();
    void modificarPeriodo(Periodo periodo);
    void eliminarPeriodo(int id);
}