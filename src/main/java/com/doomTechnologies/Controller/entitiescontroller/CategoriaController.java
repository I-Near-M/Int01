package com.doomTechnologies.Controller.entitiescontroller;

import com.doomTechnologies.model.entities.Categoria;
import com.doomTechnologies.model.service.crud.CategoriaService;
import com.doomTechnologies.model.service.crud.impl.CategoriaServiceImpl;

import java.util.List;

public class CategoriaController {
    private final CategoriaService categoriaService = new CategoriaServiceImpl();

    public void registrarCategoria(Categoria categoria) {
        categoriaService.registrarCategoria(categoria);
    }

    public Categoria buscarCategoria(int id) {
        return categoriaService.buscarCategoria(id);
    }

    public Categoria buscarCategoria(String nombre) {
        return categoriaService.buscarCategoria(nombre);
    }

    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    public void modificarCategoria(Categoria categoria) {
        categoriaService.modificarCategoria(categoria);
    }

    public void eliminarCategoria(int id) {
        categoriaService.eliminarCategoria(id);
    }
}