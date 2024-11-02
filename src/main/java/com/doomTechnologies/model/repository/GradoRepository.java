package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Grado;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GradoRepository {

    public boolean registrarGrado(Grado grado) {
        String sql = "INSERT INTO Grado (nombre) VALUES (?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, grado.getNombre());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al registrar grado", e);
            return false;
        }
    }

    public List<Grado> listarGrados() {
        List<Grado> listaGrados = new ArrayList<>();
        String sql = "SELECT * FROM Grado";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Grado grado = new Grado();
                grado.setId(rs.getInt("id"));
                grado.setNombre(rs.getString("nombre"));

                listaGrados.add(grado);
            }

        } catch (SQLException e) {
            log.error("Error al listar grados", e);
        }
        return listaGrados;
    }

    public boolean eliminarGrado(int id) {
        String sql = "DELETE FROM Grado WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al eliminar grado", e);
            return false;
        }
    }

    public boolean modificarGrado(Grado grado) {
        String sql = "UPDATE Grado SET nombre=? WHERE id=?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, grado.getNombre());
            ps.setInt(2, grado.getId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al modificar grado", e);
            return false;
        }
    }

    public Grado buscarGrado(int id) {
        Grado grado = null;
        String sql = "SELECT * FROM Grado WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    grado = new Grado();
                    grado.setId(rs.getInt("id"));
                    grado.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar grado", e);
        }
        return grado;
    }
}
