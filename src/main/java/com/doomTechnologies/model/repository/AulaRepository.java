package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Aula;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AulaRepository {

    public void registrarAula(Aula aula) {
        String sql = "INSERT INTO aula (id, grado_id, seccion_id, periodo_id, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, aula.getId());
            ps.setInt(2, aula.getGradoId());
            ps.setInt(3, aula.getSeccionId());
            ps.setInt(4, aula.getPeriodoId());
            ps.setBoolean(5, aula.isEstado());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar aula", e);
        }
    }

    public Aula buscarAula(String id) {
        Aula aula = null;
        String sql = "SELECT * FROM aula WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    aula = new Aula();
                    aula.setId(rs.getString("id"));
                    aula.setGradoId(rs.getInt("grado_id"));
                    aula.setSeccionId(rs.getInt("seccion_id"));
                    aula.setPeriodoId(rs.getInt("periodo_id"));
                    aula.setEstado(rs.getBoolean("estado"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar aula", e);
        }
        return aula;
    }

    public List<Aula> listarAulas() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM aula";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Aula aula = new Aula();
                aula.setId(rs.getString("id"));
                aula.setGradoId(rs.getInt("grado_id"));
                aula.setSeccionId(rs.getInt("seccion_id"));
                aula.setPeriodoId(rs.getInt("periodo_id"));
                aula.setEstado(rs.getBoolean("estado"));
                aulas.add(aula);
            }

        } catch (SQLException e) {
            log.error("Error al listar aulas", e);
        }
        return aulas;
    }

    public void modificarAula(Aula aula) {
        String sql = "UPDATE aula SET grado_id = ?, seccion_id = ?, periodo_id = ?, estado = ? WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, aula.getGradoId());
            ps.setInt(2, aula.getSeccionId());
            ps.setInt(3, aula.getPeriodoId());
            ps.setBoolean(4, aula.isEstado());
            ps.setString(5, aula.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar aula", e);
        }
    }

    public void eliminarAula(String id) {
        String sql = "DELETE FROM aula WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar aula", e);
        }
    }
}
