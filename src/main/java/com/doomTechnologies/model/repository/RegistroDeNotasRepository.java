package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.RegistroDeNotas;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RegistroDeNotasRepository {

    public void registrarRegistroDeNotas(RegistroDeNotas registroDeNotas) {
        String sql = "INSERT INTO registrodenotas (idregistroaula, bimestre1, bimestre2, bimestre3, bimestre4, promediofinal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, registroDeNotas.getIdRegistroAula());
            ps.setFloat(2, registroDeNotas.getBimestre1());
            ps.setFloat(3, registroDeNotas.getBimestre2());
            ps.setFloat(4, registroDeNotas.getBimestre3());
            ps.setFloat(5, registroDeNotas.getBimestre4());
            ps.setFloat(6, registroDeNotas.getPromedioFinal());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar registro de notas", e);
        }
    }

    public RegistroDeNotas buscarRegistroDeNotas(int idRegistroDeNotas) {
        RegistroDeNotas registroDeNotas = null;
        String sql = "SELECT * FROM registrodenotas WHERE idregistrodenotas = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRegistroDeNotas);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    registroDeNotas = new RegistroDeNotas();
                    registroDeNotas.setIdRegistroDeNotas(rs.getInt("idregistrodenotas"));
                    registroDeNotas.setIdRegistroAula(rs.getInt("idregistroaula"));
                    registroDeNotas.setBimestre1(rs.getFloat("bimestre1"));
                    registroDeNotas.setBimestre2(rs.getFloat("bimestre2"));
                    registroDeNotas.setBimestre3(rs.getFloat("bimestre3"));
                    registroDeNotas.setBimestre4(rs.getFloat("bimestre4"));
                    registroDeNotas.setPromedioFinal(rs.getFloat("promediofinal"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar registro de notas", e);
        }
        return registroDeNotas;
    }

    public List<RegistroDeNotas> listarRegistrosDeNotas() {
        List<RegistroDeNotas> registrosDeNotas = new ArrayList<>();
        String sql = "SELECT * FROM registrodenotas";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RegistroDeNotas registroDeNotas = new RegistroDeNotas();
                registroDeNotas.setIdRegistroDeNotas(rs.getInt("idregistrodenotas"));
                registroDeNotas.setIdRegistroAula(rs.getInt("idregistroaula"));
                registroDeNotas.setBimestre1(rs.getFloat("bimestre1"));
                registroDeNotas.setBimestre2(rs.getFloat("bimestre2"));
                registroDeNotas.setBimestre3(rs.getFloat("bimestre3"));
                registroDeNotas.setBimestre4(rs.getFloat("bimestre4"));
                registroDeNotas.setPromedioFinal(rs.getFloat("promediofinal"));
                registrosDeNotas.add(registroDeNotas);
            }

        } catch (SQLException e) {
            log.error("Error al listar registros de notas", e);
        }
        return registrosDeNotas;
    }

    public void modificarRegistroDeNotas(RegistroDeNotas registroDeNotas) {
        String sql = "UPDATE registrodenotas SET idregistroaula = ?, bimestre1 = ?, bimestre2 = ?, bimestre3 = ?, bimestre4 = ?, promediofinal = ? WHERE idregistrodenotas = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, registroDeNotas.getIdRegistroAula());
            ps.setFloat(2, registroDeNotas.getBimestre1());
            ps.setFloat(3, registroDeNotas.getBimestre2());
            ps.setFloat(4, registroDeNotas.getBimestre3());
            ps.setFloat(5, registroDeNotas.getBimestre4());
            ps.setFloat(6, registroDeNotas.getPromedioFinal());
            ps.setInt(7, registroDeNotas.getIdRegistroDeNotas());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar registro de notas", e);
        }
    }

    public void eliminarRegistroDeNotas(int idRegistroDeNotas) {
        String sql = "DELETE FROM registrodenotas WHERE idregistrodenotas = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRegistroDeNotas);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar registro de notas", e);
        }
    }
}
