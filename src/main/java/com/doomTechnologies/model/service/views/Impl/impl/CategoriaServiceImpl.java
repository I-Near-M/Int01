package com.doomTechnologies.model.service.views.Impl.impl;

import com.doomTechnologies.model.entities.Categoria;
import com.doomTechnologies.model.repository.CategoriaRepository;
import com.doomTechnologies.model.service.crud.CategoriaService;

import java.util.List;

public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository = new CategoriaRepository();

    @Override
    public void registrarCategoria(Categoria categoria) {
        categoriaRepository.registrarCategoria(categoria);
    }

    @Override
    public Categoria buscarCategoria(int id) {
        return categoriaRepository.buscarCategoria(id);
    }

    @Override
    public Categoria buscarCategoria(String nombre) {
        return categoriaRepository.buscarCategoria(nombre);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listarCategorias();
    }

    @Override
    public void modificarCategoria(Categoria categoria) {
        categoriaRepository.modificarCategoria(categoria);
    }

    @Override
    public void eliminarCategoria(int id) {
        categoriaRepository.eliminarCategoria(id);
    }
}