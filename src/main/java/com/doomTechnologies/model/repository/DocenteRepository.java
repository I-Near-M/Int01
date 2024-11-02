package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Docente;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@Slf4j
public class DocenteRepository {

    public void registrarDocente(Docente docente) {
        String sql = "INSERT INTO docente (dni, nombre, apellidopaterno, apellidomaterno, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docente.getDni());
            ps.setString(2, docente.getNombre());
            ps.setString(3, docente.getApellidoPaterno());
            ps.setString(4, docente.getApellidoMaterno());
            ps.setString(5, docente.getTelefono());
            ps.setString(6, docente.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar docente", e);
        }
    }

    public Docente buscarDocente(String dni) {
        Docente docente = null;
        String sql = "SELECT * FROM docente WHERE dni = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    docente = new Docente();
                    docente.setDni(rs.getString("dni"));
                    docente.setNombre(rs.getString("nombre"));
                    docente.setApellidoPaterno(rs.getString("apellidopaterno"));
                    docente.setApellidoMaterno(rs.getString("apellidomaterno"));
                    docente.setTelefono(rs.getString("telefono"));
                    docente.setEmail(rs.getString("email"));
                } else {
                    JOptionPane.showMessageDialog(null, "Docente con dni " + dni + " no encontrado");
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar docente", e);
        }
        return docente;
    }

    public List<Docente> listarDocentes() {
        List<Docente> docentes = new ArrayList<>();
        String sql = "SELECT * FROM docente";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Docente docente = new Docente();
                docente.setDni(rs.getString("dni"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellidoPaterno(rs.getString("apellidopaterno"));
                docente.setApellidoMaterno(rs.getString("apellidomaterno"));
                docente.setTelefono(rs.getString("telefono"));
                docente.setEmail(rs.getString("email"));
                docentes.add(docente);
            }

        } catch (SQLException e) {
            log.error("Error al listar docentes", e);
        }
        return docentes;
    }

    public void modificarDocente(Docente docente) {
        String sql = "UPDATE docente SET nombre = ?, apellidopaterno = ?, apellidomaterno = ?, telefono = ?, email = ? WHERE dni = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getApellidoPaterno());
            ps.setString(3, docente.getApellidoMaterno());
            ps.setString(4, docente.getTelefono());
            ps.setString(5, docente.getEmail());
            ps.setString(6, docente.getDni());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Docente con dni: " + docente.getDni() + " actualizado correctamente");

        } catch (SQLException e) {
            log.error("Error al modificar docente", e);
        }
    }

    public void eliminarDocente(String dni) {
        String sql = "DELETE FROM docente WHERE dni = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                log.warn("El docente con DNI " + dni + " no existe");
            } else {
                log.info("Docente eliminado correctamente");
            }

        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                log.error("No se puede eliminar el docente porque tiene asignaturas relacionadas");
                JOptionPane.showMessageDialog(null, "No se puede eliminar el docente porque tiene asignaturas relacionadas");
            } else {
                log.error("Error al eliminar docente", e);
            }
        }
    }
}
