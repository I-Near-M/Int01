package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Apoderado;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ApoderadoRepository {

    public boolean registrarApoderado(Apoderado apoderado) {
        String sql = "INSERT INTO Apoderado (nombre, apellidopaterno, apellidomaterno, telefono) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, apoderado.getNombre());
            ps.setString(2, apoderado.getApellidoPaterno());
            ps.setString(3, apoderado.getApellidoMaterno());
            ps.setString(4, apoderado.getTelefono());

            int result = ps.executeUpdate();

            return result > 0; // Devuelve true si se insertó al menos una fila
        } catch (SQLException e) {
            log.error("Error al registrar apoderado", e);
            return false; // Devuelve false si hay una excepción
        }
    }

    public int registrarApoderadoRetornaID(Apoderado apoderado) {
        String sql = "INSERT INTO Apoderado (nombre, apellidopaterno, apellidomaterno, telefono) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, apoderado.getNombre());
            ps.setString(2, apoderado.getApellidoPaterno());
            ps.setString(3, apoderado.getApellidoMaterno());
            ps.setString(4, apoderado.getTelefono());

            int result = ps.executeUpdate();

            if (result > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Retorna el ID generado
                    }
                }
            }
        } catch (SQLException e) {
            log.error("Error al registrar apoderado", e);
        }
        return -1; // Retorna -1 si hay una excepción o no se generó un ID
    }

    public List<Apoderado> listarApoderados() {
        List<Apoderado> listaApoderados = new ArrayList<>();
        String sql = "SELECT * FROM Apoderado";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Apoderado apoderado = new Apoderado();
                apoderado.setId(rs.getInt("id"));
                apoderado.setNombre(rs.getString("nombre"));
                apoderado.setApellidoPaterno(rs.getString("apellidopaterno"));
                apoderado.setApellidoMaterno(rs.getString("apellidomaterno"));
                apoderado.setTelefono(rs.getString("telefono"));
                listaApoderados.add(apoderado);
            }
        } catch (SQLException e) {
            log.error("Error al listar apoderados", e);
        }
        return listaApoderados;
    }

    public boolean eliminarApoderado(int id) {
        String sql = "DELETE FROM Apoderado WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            log.error("Error al eliminar apoderado", e);
            return false;
        }
    }

    public boolean modificarApoderado(Apoderado apoderado) {
        String sql = "UPDATE Apoderado SET nombre=?, apellidopaterno=?, apellidomaterno=?, telefono=? WHERE id=?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, apoderado.getNombre());
            ps.setString(2, apoderado.getApellidoPaterno());
            ps.setString(3, apoderado.getApellidoMaterno());
            ps.setString(4, apoderado.getTelefono());
            ps.setInt(5, apoderado.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            log.error("Error al modificar apoderado", e);
            return false;
        }
    }

    public Apoderado buscarApoderado(int id) {
        Apoderado apoderado = null;
        String sql = "SELECT * FROM Apoderado WHERE id = ?";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    apoderado = new Apoderado();
                    apoderado.setId(rs.getInt("id"));
                    apoderado.setNombre(rs.getString("nombre"));
                    apoderado.setApellidoPaterno(rs.getString("apellidopaterno"));
                    apoderado.setApellidoMaterno(rs.getString("apellidomaterno"));
                    apoderado.setTelefono(rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            log.error("Error al buscar apoderado", e);
        }
        return apoderado;
    }
}
