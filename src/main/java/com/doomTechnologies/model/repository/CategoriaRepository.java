package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Categoria;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@Slf4j
public class CategoriaRepository {

    public void registrarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nombre) VALUES (?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();

        } catch (SQLException e) {
            // Detectar si la excepción se debe a la violación de unicidad del campo nombre
            if (e.getErrorCode() == 1062) { // Código de error para violación de clave única
                log.warn("El nombre de la categoría ya existe: {}", categoria.getNombre());
                JOptionPane.showMessageDialog(null, "El nombre de la categoría ya existe: " + categoria.getNombre());
            } else {
                log.error("Error al registrar categoría", e);
            }
        }
    }

    public Categoria buscarCategoria(int id) {
        Categoria categoria = null;
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar categoria", e);
        }
        return categoria;
    }

    public Categoria buscarCategoria(String nombre) {
        Categoria categoria = null;
        String sql = "SELECT * FROM categoria WHERE nombre = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar categoria por nombre", e);
        }
        return categoria;
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            log.error("Error al listar categorias", e);
        }
        return categorias;
    }

    public void modificarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre = ? WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar categoria", e);
        }
    }

    public void eliminarCategoria(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar categoria", e);
        }
    }
}
