package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.RolDto;

public class RolRepository {
	
	// OBTENER LOS ROLES QUE SE TIENEN EN LA BASE DE DATOS
	public List<RolDto> obtenerRoles() throws SQLException, Exception {
		
		List<RolDto> lista = new ArrayList<>();
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cn = AccesoDB.getConnection();
			
			String sql = """
                   SELECT * FROM Rol
									 """;
			
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RolDto dto = new RolDto(rs.getInt("idRol"), rs.getString("descripcion"));
				lista.add(dto);
			}
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD.");
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e) {
			}
		}
		
		return lista;
		
	}
	
}
