package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Rol;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RolRepository {

    public boolean registrarRol(Rol rol) {
        String sql = "INSERT INTO Rol (nombre) VALUES (?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rol.getNombre());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al registrar rol", e);
            return false;
        }
    }

    public List<Rol> listarRoles() {
        List<Rol> listaRoles = new ArrayList<>();
        String sql = "SELECT * FROM Rol";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombre(rs.getString("nombre"));

                listaRoles.add(rol);
            }

        } catch (SQLException e) {
            log.error("Error al listar roles", e);
        }
        return listaRoles;
    }

    public boolean eliminarRol(int id) {
        String sql = "DELETE FROM Rol WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al eliminar rol", e);
            return false;
        }
    }

    public boolean modificarRol(Rol rol) {
        String sql = "UPDATE Rol SET nombre=? WHERE id=?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al modificar rol", e);
            return false;
        }
    }

    public Rol buscarRol(int id) {
        Rol rol = null;
        String sql = "SELECT * FROM Rol WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rol = new Rol();
                    rol.setId(rs.getInt("id"));
                    rol.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar rol", e);
        }
        return rol;
    }
}
