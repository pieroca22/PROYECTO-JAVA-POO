package pe.edu.uni.mecafab.prueba;

import java.sql.Connection;
import pe.edu.uni.mecafab.db.AccesoDB;

public class PruebaA1_Conexion {
    
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion ok.");
            cn.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
