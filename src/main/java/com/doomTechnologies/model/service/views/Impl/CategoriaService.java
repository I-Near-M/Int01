package com.doomTechnologies.model.service.views.Impl;

import com.doomTechnologies.model.entities.Categoria;

import java.util.List;

public interface CategoriaService {
    void registrarCategoria(Categoria categoria);
    Categoria buscarCategoria(int id);
    Categoria buscarCategoria(String nombre);
    List<Categoria> listarCategorias();
    void modificarCategoria(Categoria categoria);
    void eliminarCategoria(int id);
}