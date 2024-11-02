package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Periodo;
import com.doomTechnologies.model.repository.PeriodoRepository;
import com.doomTechnologies.model.service.crud.PeriodoService;

import java.util.List;

public class PeriodoServiceImpl implements PeriodoService {
    private final PeriodoRepository periodoRepository = new PeriodoRepository();

    @Override
    public void registrarPeriodo(Periodo periodo) {
        periodoRepository.registrarPeriodo(periodo);
    }

    @Override
    public Periodo buscarPeriodo(int id) {
        return periodoRepository.buscarPeriodo(id);
    }

    @Override
    public Periodo buscarPeriodoPorAño(int año) {
        return periodoRepository.buscarPeriodoPorAño(año);
    }

    @Override
    public List<Periodo> listarPeriodos() {
        return periodoRepository.listarPeriodos();
    }

    @Override
    public void modificarPeriodo(Periodo periodo) {
        periodoRepository.modificarPeriodo(periodo);
    }

    @Override
    public void eliminarPeriodo(int id) {
        periodoRepository.eliminarPeriodo(id);
    }
}