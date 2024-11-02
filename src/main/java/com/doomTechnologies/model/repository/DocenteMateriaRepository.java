package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Docente;
import com.doomTechnologies.model.entities.DocenteMateria;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@Slf4j
public class DocenteMateriaRepository {

    public void registrarDocenteMateria(DocenteMateria docenteMateria) {
        String sql = "INSERT INTO docente_materia (iddocente, idmateria) VALUES (?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docenteMateria.getIdDocente());
            ps.setInt(2, docenteMateria.getIdMateria());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar docente_materia", e);
        }
    }

    public void registrarDocenteMateria(String docenteId, int materiaId) {
        String sql = "INSERT INTO docente_materia (iddocente, idmateria) VALUES (?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docenteId);
            ps.setInt(2, materiaId);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar docente_materia", e);
        }
    }

    public DocenteMateria buscarDocenteMateria(int id) {
        DocenteMateria docenteMateria = null;
        String sql = "SELECT * FROM docente_materia WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    docenteMateria = new DocenteMateria();
                    docenteMateria.setId(rs.getInt("id"));
                    docenteMateria.setIdDocente(rs.getString("iddocente"));
                    docenteMateria.setIdMateria(rs.getInt("idmateria"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar docente_materia", e);
        }
        return docenteMateria;
    }

    public List<DocenteMateria> listarDocenteMaterias() {
        List<DocenteMateria> docenteMaterias = new ArrayList<>();
        String sql = "SELECT * FROM docente_materia";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DocenteMateria docenteMateria = new DocenteMateria();
                docenteMateria.setId(rs.getInt("id"));
                docenteMateria.setIdDocente(rs.getString("iddocente"));
                docenteMateria.setIdMateria(rs.getInt("idmateria"));
                docenteMaterias.add(docenteMateria);
            }

        } catch (SQLException e) {
            log.error("Error al listar docente_materias", e);
        }
        return docenteMaterias;
    }

    public void modificarDocenteMateria(DocenteMateria docenteMateria) {
        String sql = "UPDATE docente_materia SET iddocente = ?, idmateria = ? WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docenteMateria.getIdDocente());
            ps.setInt(2, docenteMateria.getIdMateria());
            ps.setInt(3, docenteMateria.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar docente_materia", e);
        }
    }

    public void eliminarDocenteMateria(int id) {
        String sql = "DELETE FROM docente_materia WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar docente_materia", e);
        }
    }

    public void eliminarMateriasDocente(Docente docente) {
        String sql = "DELETE FROM docente_materia WHERE iddocente = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, docente.getDni());
            ps.executeUpdate();
            log.info("Materias eliminadas para el docente " + docente.getNombre());
            JOptionPane.showMessageDialog(null, "Materias eliminadas para el docente " + docente.getNombre());
        } catch (SQLException e) {
            log.error("Error al eliminar materias del docente", e);
        }
    }
}
