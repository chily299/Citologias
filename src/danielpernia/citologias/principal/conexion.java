package danielpernia.citologias.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class conexion {
	
	public String ruta,consulta;
	Connection conn = null;
	Statement sentencia = null;
	
	public conexion(){
		 ruta = "C:\\Users\\Daniel Pernia\\workspace\\citologias\\db.sqlite";
		 
		}
	
	public void conectar(){
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+ruta);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	}	
	
	public boolean validarAcceso(int id, int rol, String nombre, String constrasenna){
		
		boolean usuarioAutorizado = false;
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM usuario where nombre = '"+nombre+"' AND constrassena = '"+constrasenna+"';" );
			while ( rs.next() ) {
				 usuarioAutorizado = true;
			     id = rs.getInt("rowid");
			     rol = rs.getInt("rol");
			     String  name = rs.getString("nombre");
			     String age  = rs.getString("contrasenna");
			     System.out.println( "ID = " + id );
			     System.out.println( "ROL = " + rol );
			     System.out.println( "NAME = " + name );
			     System.out.println( "contrasenna = " + age );
			     System.out.println();
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return usuarioAutorizado;
		
	}
	
	public int registrarUsuarioNuevo(int rol,String nombre, String contrasenna){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO usuario (rol,nombre,contrasenna) " +
	                   "VALUES ("+rol+", '"+nombre+"','"+contrasenna+"');"; 
			sentencia.executeUpdate(sql);
			//System.out.println("fin insert exitoso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int actualizarUsuario(int rol,String nombre, String contrasenna){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO usuario (rol,nombre,contrasenna) " +
	                   "VALUES ("+rol+", '"+nombre+"','"+contrasenna+"');"; 
			sentencia.executeUpdate(sql);
			//System.out.println("fin insert exitoso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int guardarEstudio(String motivo_consulta,String diagnostico, 
			int embatazos,int cesareas,int partos,int abortos,String f_ultimo_embarazo,
			boolean FUR, String f_FUR,boolean citologia, String f_citologia, boolean biopsia, String f_biopsia,
			String muestra_de,String sitio_lesion, int id_medico,
			boolean irradiacion, String f_irradiacion, boolean quimio, String f_quimio,
			String quirurgico,String hormonas, boolean anticonceptivo, String f_anticonceptivo,
			String resultado, int info_muestra1,int info_muestra2,int info_muestra3,
			int clasificacion1,int clasificacion2,int clasificacion3,int clasificacion4,String clasificacion_detalle,
			int numero_impresiones
			){
	
		return 0;
	}

	public int buscarEstudioCedula(String cedula,String motivo_consulta,String diagnostico, 
			int embatazos,int cesareas,int partos,int abortos,String f_ultimo_embarazo,
			boolean FUR, String f_FUR,boolean citologia, String f_citologia, boolean biopsia, String f_biopsia,
			String muestra_de,String sitio_lesion, int id_medico,
			boolean irradiacion, String f_irradiacion, boolean quimio, String f_quimio,
			String quirurgico,String hormonas, boolean anticonceptivo, String f_anticonceptivo,
			String resultado, int info_muestra1,int info_muestra2,int info_muestra3,
			int clasificacion1,int clasificacion2,int clasificacion3,int clasificacion4,String clasificacion_detalle,
			int numero_impresiones
			){
		
		return 0;
	}
	
	public int EditarEstudio(int rowid,String motivo_consulta,String diagnostico, 
			int embatazos,int cesareas,int partos,int abortos,String f_ultimo_embarazo,
			boolean FUR, String f_FUR,boolean citologia, String f_citologia, boolean biopsia, String f_biopsia,
			String muestra_de,String sitio_lesion, int id_medico,
			boolean irradiacion, String f_irradiacion, boolean quimio, String f_quimio,
			String quirurgico,String hormonas, boolean anticonceptivo, String f_anticonceptivo,
			String resultado, int info_muestra1,int info_muestra2,int info_muestra3,
			int clasificacion1,int clasificacion2,int clasificacion3,int clasificacion4,String clasificacion_detalle,
			int numero_impresiones
			){
		
		return 0;
	}
	
	
	public void registrarPasiente(){
		
	}
}

