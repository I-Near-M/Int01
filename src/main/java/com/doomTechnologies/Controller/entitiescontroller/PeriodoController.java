package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Periodo;
import com.doomTechnologies.model.service.crud.PeriodoService;
import com.doomTechnologies.model.service.crud.impl.PeriodoServiceImpl;

import java.util.List;

public class PeriodoController {
    private final PeriodoService periodoService = new PeriodoServiceImpl();

    public void registrarPeriodo(Periodo periodo) {
        periodoService.registrarPeriodo(periodo);
    }

    public Periodo buscarPeriodo(int id) {
        return periodoService.buscarPeriodo(id);
    }

    public Periodo buscarPeriodoPorAño(int año) {
        return periodoService.buscarPeriodoPorAño(año);
    }

    public List<Periodo> listarPeriodos() {
        return periodoService.listarPeriodos();
    }

    public void modificarPeriodo(Periodo periodo) {
        periodoService.modificarPeriodo(periodo);
    }

    public void eliminarPeriodo(int id) {
        periodoService.eliminarPeriodo(id);
    }
}