package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
   public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/prueba";
        String username = "root";
        String password = "root";

        try (java.sql.Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos")) {
            
            while (rs.next()) {
                String name = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String fechaNac = rs.getString("fechaNac");
                System.out.println("Alumno: " + name + " " + apellido + " " + fechaNac);
            }
        }
    } 
}
