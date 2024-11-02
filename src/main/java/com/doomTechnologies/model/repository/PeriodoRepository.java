package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Periodo;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PeriodoRepository {

    public void registrarPeriodo(Periodo periodo) {
        String sql = "INSERT INTO periodo (año) VALUES (?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, periodo.getAño());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar periodo", e);
        }
    }

    public Periodo buscarPeriodo(int id) {
        Periodo periodo = null;
        String sql = "SELECT * FROM periodo WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    periodo = new Periodo();
                    periodo.setId(rs.getInt("id"));
                    periodo.setAño(rs.getInt("año"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar periodo", e);
        }
        return periodo;
    }

    public Periodo buscarPeriodoPorAño(int año) {
        Periodo periodo = null;
        String sql = "SELECT * FROM periodo WHERE año = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, año);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    periodo = new Periodo();
                    periodo.setId(rs.getInt("id"));
                    periodo.setAño(rs.getInt("año"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar periodo por año", e);
        }
        return periodo;
    }

    public List<Periodo> listarPeriodos() {
        List<Periodo> periodos = new ArrayList<>();
        String sql = "SELECT * FROM periodo";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Periodo periodo = new Periodo();
                periodo.setId(rs.getInt("id"));
                periodo.setAño(rs.getInt("año"));
                periodos.add(periodo);
            }

        } catch (SQLException e) {
            log.error("Error al listar periodos", e);
        }
        return periodos;
    }

    public void modificarPeriodo(Periodo periodo) {
        String sql = "UPDATE periodo SET año = ? WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, periodo.getAño());
            ps.setInt(2, periodo.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar periodo", e);
        }
    }

    public void eliminarPeriodo(int id) {
        String sql = "DELETE FROM periodo WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar periodo", e);
        }
    }
}
