
package com.doomTechnologies.config;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConexionDB {

    private static final String DB_NAME = "test";
    private static final String DB_HOST = "localhost";
    private static final String DB_PASSWORD = "";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "root";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";

    // Singleton Instance
    private static ConexionDB instance;

    private ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            log.info("Driver de la base de datos cargado exitosamente.");
        } catch (ClassNotFoundException e) {
            log.error("Error al cargar el driver de la base de datos", e);
            throw new RuntimeException("Error al cargar el driver de la base de datos", e);
        }
    }

    //Método para obtener la instancia singleton
    public static ConexionDB getInstance() {
        if (instance == null) {
            synchronized (ConexionDB.class) {
                if (instance == null) {
                    instance = new ConexionDB();
                }
            }
        }
        return instance;
    }

    //Método para obtener una conexión a la base de datos
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    //Método para liberar recursos usando try-with-resources
    public static void closeConnection(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    log.error("Error al cerrar el recurso", e);
                }
            }
        }
    }
}

