package com.doomTechnologies.model.repository;

import com.doomTechnologies.config.ConexionDB;
import com.doomTechnologies.model.entities.Usuario;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UsuarioRepository {

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (username, password, email, rol_id) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getRolId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al registrar usuario", e);
            return false;
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRolId(rs.getInt("rol_id"));

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            log.error("Error al listar usuarios", e);
        }
        return listaUsuarios;
    }

    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al eliminar usuario", e);
            return false;
        }
    }

    public boolean modificarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET username=?, password=?, email=?, rol_id=? WHERE id=?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getRolId());
            ps.setInt(5, usuario.getId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al modificar usuario", e);
            return false;
        }
    }

    public Usuario buscarUsuario(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setRolId(rs.getInt("rol_id"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar usuario", e);
        }
        return usuario;
    }

    public Usuario buscarUsuario(String username) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE username = ?";
        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setRolId(rs.getInt("rol_id"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar usuario por nombre de usuario", e);
        }
        return usuario;
    }
}
