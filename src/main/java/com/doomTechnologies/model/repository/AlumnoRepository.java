package com.doomTechnologies.model.repository;

import com.doomTechnologies.model.entities.Alumno;
import com.doomTechnologies.config.ConexionDB;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AlumnoRepository {

    public boolean registrarAlumno(Alumno alumno) {
        String sql = "INSERT INTO Alumno (dni, nombre, appaterno, apmaterno, genero, fechanacimiento, direccion, telefono, grado_id, seccion_id, apoderado_id, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellidoPaterno());
            ps.setString(4, alumno.getApellidoMaterno());
            ps.setString(5, String.valueOf(alumno.getGenero()));
            ps.setDate(6, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            ps.setString(7, alumno.getDireccion());
            ps.setString(8, alumno.getTelefono());
            ps.setInt(9, alumno.getGradoId());
            ps.setInt(10, alumno.getSeccionId());
            ps.setInt(11, alumno.getApoderadoId());
            ps.setInt(12, alumno.getUsuarioId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al registrar alumno", e);
            return false;
        }
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM Alumno";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setDni(rs.getString("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoPaterno(rs.getString("appaterno"));
                alumno.setApellidoMaterno(rs.getString("apmaterno"));
                alumno.setGenero(rs.getString("genero").charAt(0));
                alumno.setFechaNacimiento(rs.getDate("fechanacimiento"));
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setGradoId(rs.getInt("grado_id"));
                alumno.setSeccionId(rs.getInt("seccion_id"));
                alumno.setApoderadoId(rs.getInt("apoderado_id"));
                alumno.setUsuarioId(rs.getInt("usuario_id"));

                listaAlumnos.add(alumno);
            }

        } catch (SQLException e) {
            log.error("Error al listar alumnos", e);
        }
        return listaAlumnos;
    }

    public boolean eliminarAlumno(String dni) {
        String sql = "DELETE FROM Alumno WHERE dni = ?";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al eliminar alumno", e);
            return false;
        }
    }

    public boolean modificarAlumno(Alumno alumno) {
        String sql = "UPDATE Alumno SET nombre=?, appaterno=?, apmaterno=?, genero=?, fechanacimiento=?, direccion=?, telefono=?, grado_id=?, seccion_id=?, apoderado_id=?, usuario_id=? WHERE dni=?";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellidoPaterno());
            ps.setString(3, alumno.getApellidoMaterno());
            ps.setString(4, String.valueOf(alumno.getGenero()));
            ps.setDate(5, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            ps.setString(6, alumno.getDireccion());
            ps.setString(7, alumno.getTelefono());
            ps.setInt(8, alumno.getGradoId());
            ps.setInt(9, alumno.getSeccionId());
            ps.setInt(10, alumno.getApoderadoId());
            ps.setInt(11, alumno.getUsuarioId());
            ps.setString(12, alumno.getDni());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            log.error("Error al modificar alumno", e);
            return false;
        }
    }

    public Alumno buscarAlumno(String dni) {
        Alumno alumno = null;
        String sql = "SELECT * FROM Alumno WHERE dni = ?";

        try (Connection con = ConexionDB.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno();
                    alumno.setDni(rs.getString("dni"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellidoPaterno(rs.getString("appaterno"));
                    alumno.setApellidoMaterno(rs.getString("apmaterno"));
                    alumno.setGenero(rs.getString("genero").charAt(0));
                    alumno.setFechaNacimiento(rs.getDate("fechanacimiento"));
                    alumno.setDireccion(rs.getString("direccion"));
                    alumno.setTelefono(rs.getString("telefono"));
                    alumno.setGradoId(rs.getInt("grado_id"));
                    alumno.setSeccionId(rs.getInt("seccion_id"));
                    alumno.setApoderadoId(rs.getInt("apoderado_id"));
                    alumno.setUsuarioId(rs.getInt("usuario_id"));
                }
            }

        } catch (SQLException e) {
            log.error("Error al buscar alumno", e);
        }
        return alumno;
    }
}
