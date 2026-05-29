import java.sql.*;

public class DatabaseManager {
    // CONFIGURACIÓN DE MYSQL - CAMBIA ESTOS DATOS POR LOS TUYOS
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB_NAME = "Practica_socket";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";

    public static void init() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            if (conn != null) {
                System.out.println("Conexión exitosa a MySQL: " + DB_NAME);
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar con MySQL: " + e.getMessage());
        }
    }

    public static void saveMessage(String usuario, String mensaje) {
        // En MySQL se usa INSERT IGNORE para evitar duplicados en la tabla clientes
        String sqlCliente = "INSERT IGNORE INTO clientes (usuario) VALUES (?)";
        String sqlMensaje = "INSERT INTO mensajes (usuario, mensaje) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Registrar el usuario si no existe
            try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlCliente)) {
                pstmtCliente.setString(1, usuario);
                pstmtCliente.executeUpdate();
            }

            // Guardar el mensaje
            try (PreparedStatement pstmtMensaje = conn.prepareStatement(sqlMensaje)) {
                pstmtMensaje.setString(1, usuario);
                pstmtMensaje.setString(2, mensaje);
                pstmtMensaje.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar el mensaje en MySQL: " + e.getMessage());
        }
    }
}

// en Mysql workbench
//CREATE DATABASE Practica_socket;
//Use Practica_socket;
//
//CREATE TABLE clientes (
//    id_cliente INTEGER PRIMARY KEY auto_increment,
//    usuario VARCHAR(50) UNIQUE NOT NULL,
//    password VARCHAR(255) NOT NULL,
//    nombre_completo VARCHAR(100)
//);
//
//CREATE TABLE mensajes (
//    id_mensaje INTEGER PRIMARY KEY AUTO_INCREMENT,
//    id_remitente INTEGER NOT NULL,
//    id_destinatario INTEGER, -- Puede ser NULL si el mensaje es global
//    contenido TEXT NOT NULL,
//    fecha_mensaje TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- <--- AQUÍ ESTABA EL ERROR (Agregué 'fecha_mensaje')
//    FOREIGN KEY (id_remitente) REFERENCES clientes(id_cliente),
//    FOREIGN KEY (id_destinatario) REFERENCES clientes(id_cliente)
//);