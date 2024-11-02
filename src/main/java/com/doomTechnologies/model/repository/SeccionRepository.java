package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Seccion;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SeccionRepository {

    public boolean registrarSeccion(Seccion seccion) {
        String sql = "INSERT INTO Seccion (nombre) VALUES (?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, seccion.getNombre());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al registrar sección", e);
            return false;
        }
    }

    public List<Seccion> listarSecciones() {
        List<Seccion> listaSecciones = new ArrayList<>();
        String sql = "SELECT * FROM Seccion";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rs.getInt("id"));
                seccion.setNombre(rs.getString("nombre"));

                listaSecciones.add(seccion);
            }

        } catch (SQLException e) {
            log.error("Error al listar secciones", e);
        }
        return listaSecciones;
    }

    public boolean eliminarSeccion(int id) {
        String sql = "DELETE FROM Seccion WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al eliminar sección", e);
            return false;
        }
    }

    public boolean modificarSeccion(Seccion seccion) {
        String sql = "UPDATE Seccion SET nombre=? WHERE id=?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, seccion.getNombre());
            ps.setInt(2, seccion.getId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al modificar sección", e);
            return false;
        }
    }

    public Seccion buscarSeccion(int id) {
        Seccion seccion = null;
        String sql = "SELECT * FROM Seccion WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    seccion = new Seccion();
                    seccion.setId(rs.getInt("id"));
                    seccion.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar sección", e);
        }
        return seccion;
    }
}
