package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Materia;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MateriaRepository {

    public void registrarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, categoriaid) VALUES (?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getCategoriaId());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar materia", e);
        }
    }

    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT * FROM materia WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    materia = new Materia();
                    materia.setId(rs.getInt("id"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setCategoriaId(rs.getInt("categoriaid"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar materia", e);
        }
        return materia;
    }

    public Materia buscarMateria(String nombre) {
        Materia materia = null;
        String sql = "SELECT * FROM materia WHERE nombre = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    materia = new Materia();
                    materia.setId(rs.getInt("id"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setCategoriaId(rs.getInt("categoriaid"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar materia por nombre", e);
        }
        return materia;
    }

    public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setCategoriaId(rs.getInt("categoriaid"));
                materias.add(materia);
            }

        } catch (SQLException e) {
            log.error("Error al listar materias", e);
        }
        return materias;
    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ?, categoriaid = ? WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getCategoriaId());
            ps.setInt(3, materia.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar materia", e);
        }
    }

    public void eliminarMateria(int id) {
        String sql = "DELETE FROM materia WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar materia", e);
        }
    }
}
