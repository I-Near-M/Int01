package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.RegistroAula;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RegistroAulaRepository {

    public void registrarRegistroAula(RegistroAula registroAula) {
        String sql = "INSERT INTO registroaula (idaula, idalumno, iddocentemateria) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, registroAula.getIdAula());
            ps.setString(2, registroAula.getIdAlumno());
            ps.setInt(3, registroAula.getIdDocenteMateria());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al registrar registro de aula", e);
        }
    }

    public RegistroAula buscarRegistroAula(int idRegistroAula) {
        RegistroAula registroAula = null;
        String sql = "SELECT * FROM registroaula WHERE idregistroAula = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRegistroAula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    registroAula = new RegistroAula();
                    registroAula.setIdRegistroAula(rs.getInt("idregistroAula"));
                    registroAula.setIdAula(rs.getString("idaula"));
                    registroAula.setIdAlumno(rs.getString("idalumno"));
                    registroAula.setIdDocenteMateria(rs.getInt("iddocentemateria"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar registro de aula", e);
        }
        return registroAula;
    }

    public List<RegistroAula> listarRegistrosAula() {
        List<RegistroAula> registrosAula = new ArrayList<>();
        String sql = "SELECT * FROM registroaula";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RegistroAula registroAula = new RegistroAula();
                registroAula.setIdRegistroAula(rs.getInt("idregistroAula"));
                registroAula.setIdAula(rs.getString("idaula"));
                registroAula.setIdAlumno(rs.getString("idalumno"));
                registroAula.setIdDocenteMateria(rs.getInt("iddocentemateria"));
                registrosAula.add(registroAula);
            }

        } catch (SQLException e) {
            log.error("Error al listar registros de aula", e);
        }
        return registrosAula;
    }

    public void modificarRegistroAula(RegistroAula registroAula) {
        String sql = "UPDATE registroaula SET idaula = ?, idalumno = ?, iddocentemateria = ? WHERE idregistroAula = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, registroAula.getIdAula());
            ps.setString(2, registroAula.getIdAlumno());
            ps.setInt(3, registroAula.getIdDocenteMateria());
            ps.setInt(4, registroAula.getIdRegistroAula());
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al modificar registro de aula", e);
        }
    }

    public void eliminarRegistroAula(int idRegistroAula) {
        String sql = "DELETE FROM registroaula WHERE idregistroAula = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRegistroAula);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error al eliminar registro de aula", e);
        }
    }
}
