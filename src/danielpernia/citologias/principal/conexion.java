package danielpernia.citologias.principal;

import java.sql.Connection;
import java.sql.Date;
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
		 //ruta = "db.sqlite";
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
	
	public int guardarEstudio(estudio_citologico estudio){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO consulta (id_pasiente,motivo_consulta,diagnostico,embarazos,cesareas,partos,abortos,ultimo_embarazo"
					+ "fur,fecha_fur,citologia,citologia_fecha,biopsia,biopsia_fecha,muestra_de,sitio_lesion,id_medico"
					+ "irradiacion,irradiacion_fecha,quimioterapia,quimioterapia_fecha,quirurgico,hormonas,anticonceptivos_orales,anticonceptivos_orales_descripcion"
					+ "resultado,info_muestra_1,info_muestra_2,info_muestra_3,clasificacion_1,clasificacion_2,clasificacion_3,clasificacion_4,clasificacion_descripcion,numero_impresion,fecha_muestra,fecha_resultado,estado) " +
	                   "VALUES ("+estudio.rowid_pasiente+", '"+estudio.motivo_consulta+"','"+estudio.diagnostico+"',"
	                   		+ ""+estudio.embarazos+","+estudio.cesareas+","+estudio.partos+","+estudio.abortos+",'"+estudio.f_ultimo_embarazo+"',"
	                   		+ ""+estudio.FUR+",'"+estudio.f_FUR+"',"+estudio.citologia+",'"+estudio.f_citologia+"',"+estudio.biopsia+",'"+estudio.f_biopsia+"',"
	                   		+ "'"+estudio.muestra_de+"','"+estudio.sitio_lesion+"',"+estudio.id_medico+","
	                   		+ ""+estudio.irradiacion+",'"+estudio.f_irradiacion+"',"+estudio.quimio+",'"+estudio.f_quimio+"',"
	                   		+ "'"+estudio.quirurgico+"','"+estudio.hormonas+"',"+estudio.anticonceptivo+",'"+estudio.d_anticonceptivo+"',"
	                   		+ "'"+estudio.resultado+"',"+estudio.info_muestra1+","+estudio.info_muestra2+","+estudio.info_muestra3+","
	                   		+ ""+estudio.clasificacion1+","+estudio.clasificacion2+","+estudio.clasificacion3+","+estudio.clasificacion4+",'"+estudio.clasificacion_detalle+"',"
	                   		+ ""+estudio.numero_impresiones+",'"+estudio.fecha_muestra+"','"+estudio.fecha_resultado+"','"+estudio.estado+"');"; 
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return 0;
	}

	public int buscarEstudioCedula(String cedula,estudio_citologico estudio[]){
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where id_pasiente = '"+cedula+"';" );
			int i =0;
			
			while ( rs.next() ) {
				estudio[i].rowid = rs.getInt("rowid");
				estudio[i].motivo_consulta = rs.getString("motivo_consulta");
				estudio[i].diagnostico = rs.getString("diagnostico");
			     
				estudio[i].embarazos = rs.getInt("embarazos");
				estudio[i].cesareas = rs.getInt("cesareas");
				estudio[i].partos = rs.getInt("partos");
				estudio[i].abortos = rs.getInt("abortos");
				estudio[i].f_ultimo_embarazo = rs.getString("ultimo_embarazo");
				estudio[i].FUR = rs.getBoolean("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getBoolean("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getBoolean("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getBoolean("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getBoolean("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getBoolean("anticonceptivos_orales");
			    estudio[i].d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio[i].resultado = rs.getString("resultado");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_1");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_2");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_1");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_2");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_4");
			     
			    estudio[i].numero_impresiones = rs.getInt("numero_impresion");
			    estudio[i].fecha_muestra = rs.getString("fecha_muestra");
			    estudio[i].fecha_resultado = rs.getString("fecha_resultado");
			    estudio[i].estado = rs.getString("estado");
			     
			     
			     
			     //imprimir
			     System.out.println( "ID = " + estudio[i].motivo_consulta );
			     System.out.println( "ROL = " + estudio[i].diagnostico );
			     System.out.println();
			     i++;
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
	public int EditarEstudio(estudio_citologico estudio){
		
		try {
			sentencia = conn.createStatement();
			String sql = "UPDATE INTO consulta (motivo_consulta,diagnostico,embarazos,cesareas,partos,abortos,ultimo_embarazo"
					+ "fur,fecha_fur,citologia,citologia_fecha,biopsia,biopsia_fecha,muestra_de,sitio_lesion,id_medico"
					+ "irradiacion,irradiacion_fecha,quimioterapia,quimioterapia_fecha,quirurgico,hormonas,anticonceptivos_orales,anticonceptivos_orales_descripcion"
					+ "resultado,info_muestra_1,info_muestra_2,info_muestra_3,clasificacion_1,clasificacion_2,clasificacion_3,clasificacion_4,clasificacion_descripcion,numero_impresion,fecha_muestra,fecha_resultado,estado) " +
	                   "VALUES ('"+estudio.motivo_consulta+"','"+estudio.diagnostico+"',"
	                   		+ ""+estudio.embarazos+","+estudio.cesareas+","+estudio.partos+","+estudio.abortos+",'"+estudio.f_ultimo_embarazo+"',"
	                   		+ ""+estudio.FUR+",'"+estudio.f_FUR+"',"+estudio.citologia+",'"+estudio.f_citologia+"',"+estudio.biopsia+",'"+estudio.f_biopsia+"',"
	                   		+ "'"+estudio.muestra_de+"','"+estudio.sitio_lesion+"',"+estudio.id_medico+","
	                   		+ ""+estudio.irradiacion+",'"+estudio.f_irradiacion+"',"+estudio.quimio+",'"+estudio.f_quimio+"',"
	                   		+ "'"+estudio.quirurgico+"','"+estudio.hormonas+"',"+estudio.anticonceptivo+",'"+estudio.d_anticonceptivo+"',"
	                   		+ "'"+estudio.resultado+"',"+estudio.info_muestra1+","+estudio.info_muestra2+","+estudio.info_muestra3+","
	                   		+ ""+estudio.clasificacion1+","+estudio.clasificacion2+","+estudio.clasificacion3+","+estudio.clasificacion4+",'"+estudio.clasificacion_detalle+"',"+estudio.numero_impresiones+""
	                   		+ ""+estudio.numero_impresiones+",'"+estudio.fecha_muestra+"','"+estudio.fecha_resultado+"','"+estudio.estado+"')"
	                   		+ " WHERE rowid ="+estudio.rowid+";"; 
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return 0;
	}
	
	public int actualizarImpresionesDeEstudio(estudio_citologico estudio){
		estudio.numero_impresiones++;
		try {
			sentencia = conn.createStatement();
			String sql = "UPDATE INTO consulta (numero_impresion) " +
	                   "VALUES ("+estudio.numero_impresiones+")"
	                   		+ " WHERE rowid ="+estudio.rowid+";"; 
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return 0;
	}
	
	public int buscarEstudiosPendientesPorImprimir(estudio_citologico estudio[]){
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where numero_impresiones = 0;" );
			int i =0;
			
			while ( rs.next() ) {
				estudio[i].rowid = rs.getInt("rowid");
				estudio[i].motivo_consulta = rs.getString("motivo_consulta");
				estudio[i].diagnostico = rs.getString("diagnostico");
			     
				estudio[i].embarazos = rs.getInt("embarazos");
				estudio[i].cesareas = rs.getInt("cesareas");
				estudio[i].partos = rs.getInt("partos");
				estudio[i].abortos = rs.getInt("abortos");
				estudio[i].f_ultimo_embarazo = rs.getString("ultimo_embarazo");
				estudio[i].FUR = rs.getBoolean("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getBoolean("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getBoolean("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getBoolean("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getBoolean("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getBoolean("anticonceptivos_orales");
			    estudio[i].d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio[i].resultado = rs.getString("resultado");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_1");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_2");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_1");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_2");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_4");
			     
			    estudio[i].numero_impresiones = rs.getInt("numero_impresion");
			    estudio[i].fecha_muestra = rs.getString("fecha_muestra");
			    estudio[i].fecha_resultado = rs.getString("fecha_resultado");
			    estudio[i].estado = rs.getString("estado");
			     
			     
			     
			     //imprimir
			     System.out.println( "ID = " + estudio[i].motivo_consulta );
			     System.out.println( "ROL = " + estudio[i].diagnostico );
			     System.out.println();
			     i++;
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
	public int buscarEstudiosPendientesPorResultado(estudio_citologico estudio[]){
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where estado = 'resultado_pendiente';" );
			int i =0;
			
			while ( rs.next() ) {
				estudio[i].rowid = rs.getInt("rowid");
				estudio[i].motivo_consulta = rs.getString("motivo_consulta");
				estudio[i].diagnostico = rs.getString("diagnostico");
			     
				estudio[i].embarazos = rs.getInt("embarazos");
				estudio[i].cesareas = rs.getInt("cesareas");
				estudio[i].partos = rs.getInt("partos");
				estudio[i].abortos = rs.getInt("abortos");
				estudio[i].f_ultimo_embarazo = rs.getString("ultimo_embarazo");
				estudio[i].FUR = rs.getBoolean("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getBoolean("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getBoolean("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getBoolean("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getBoolean("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getBoolean("anticonceptivos_orales");
			    estudio[i].d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio[i].resultado = rs.getString("resultado");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_1");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_2");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_1");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_2");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_4");
			     
			    estudio[i].numero_impresiones = rs.getInt("numero_impresion");
			    estudio[i].fecha_muestra = rs.getString("fecha_muestra");
			    estudio[i].fecha_resultado = rs.getString("fecha_resultado");
			    estudio[i].estado = rs.getString("estado");
			     
			     
			     
			     //imprimir
			     System.out.println( "ID = " + estudio[i].motivo_consulta );
			     System.out.println( "ROL = " + estudio[i].diagnostico );
			     System.out.println();
			     i++;
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
public int buscarEstudiosPorDia(estudio_citologico estudio[]){
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where fecha_resultado > "+"fecha_dia"+";" );
			int i =0;
			
			while ( rs.next() ) {
				estudio[i].rowid = rs.getInt("rowid");
				estudio[i].motivo_consulta = rs.getString("motivo_consulta");
				estudio[i].diagnostico = rs.getString("diagnostico");
			     
				estudio[i].embarazos = rs.getInt("embarazos");
				estudio[i].cesareas = rs.getInt("cesareas");
				estudio[i].partos = rs.getInt("partos");
				estudio[i].abortos = rs.getInt("abortos");
				estudio[i].f_ultimo_embarazo = rs.getString("ultimo_embarazo");
				estudio[i].FUR = rs.getBoolean("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getBoolean("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getBoolean("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getBoolean("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getBoolean("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getBoolean("anticonceptivos_orales");
			    estudio[i].d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio[i].resultado = rs.getString("resultado");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_1");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_2");
			    estudio[i].info_muestra1 = rs.getInt("info_muestra_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_1");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_2");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_3");
			    estudio[i].clasificacion1 = rs.getInt("clasificacion_4");
			     
			    estudio[i].numero_impresiones = rs.getInt("numero_impresion");
			    estudio[i].fecha_muestra = rs.getString("fecha_muestra");
			    estudio[i].fecha_resultado = rs.getString("fecha_resultado");
			    estudio[i].estado = rs.getString("estado");
			     
			     
			     
			     //imprimir
			     System.out.println( "ID = " + estudio[i].motivo_consulta );
			     System.out.println( "ROL = " + estudio[i].diagnostico );
			     System.out.println();
			     i++;
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}

public int buscarEstudiosPorSemana(estudio_citologico estudio[]){
	
	try {
		sentencia = conn.createStatement();
		ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where fecha_resultado > '"+"fecha_semana"+"';" );
		int i =0;
		
		while ( rs.next() ) {
			estudio[i].rowid = rs.getInt("rowid");
			estudio[i].motivo_consulta = rs.getString("motivo_consulta");
			estudio[i].diagnostico = rs.getString("diagnostico");
		     
			estudio[i].embarazos = rs.getInt("embarazos");
			estudio[i].cesareas = rs.getInt("cesareas");
			estudio[i].partos = rs.getInt("partos");
			estudio[i].abortos = rs.getInt("abortos");
			estudio[i].f_ultimo_embarazo = rs.getString("ultimo_embarazo");
			estudio[i].FUR = rs.getBoolean("fur");
			estudio[i].f_FUR = rs.getString("fecha_fur");
			estudio[i].citologia = rs.getBoolean("citologia");
			estudio[i].f_citologia = rs.getString("biopsia_fecha");
			estudio[i].biopsia = rs.getBoolean("biopsia");
			estudio[i].f_biopsia = rs.getString("biopsia_fecha");
			estudio[i].muestra_de = rs.getString("muestra_de");
			estudio[i].sitio_lesion = rs.getString("sitio_lesion");
			estudio[i].id_medico = rs.getInt("id_medico");
		     
		   	estudio[i].irradiacion = rs.getBoolean("irradiacion");
			estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
		    estudio[i].quimio = rs.getBoolean("quimioterapia");
		    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
		    estudio[i].quirurgico = rs.getString("quirurgico");
		    estudio[i].hormonas = rs.getString("hormonas");
		    estudio[i].anticonceptivo = rs.getBoolean("anticonceptivos_orales");
		    estudio[i].d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
		     
		    estudio[i].resultado = rs.getString("resultado");
		    estudio[i].info_muestra1 = rs.getInt("info_muestra_1");
		    estudio[i].info_muestra1 = rs.getInt("info_muestra_2");
		    estudio[i].info_muestra1 = rs.getInt("info_muestra_3");
		    estudio[i].clasificacion1 = rs.getInt("clasificacion_1");
		    estudio[i].clasificacion1 = rs.getInt("clasificacion_2");
		    estudio[i].clasificacion1 = rs.getInt("clasificacion_3");
		    estudio[i].clasificacion1 = rs.getInt("clasificacion_4");
		     
		    estudio[i].numero_impresiones = rs.getInt("numero_impresion");
		    estudio[i].fecha_muestra = rs.getString("fecha_muestra");
		    estudio[i].fecha_resultado = rs.getString("fecha_resultado");
		    estudio[i].estado = rs.getString("estado");
		     
		     
		     
		     //imprimir
		     System.out.println( "ID = " + estudio[i].motivo_consulta );
		     System.out.println( "ROL = " + estudio[i].diagnostico );
		     System.out.println();
		     i++;
		}

		rs.close();
		sentencia.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	
	return 0;
}
	
	
	public void registrarPasiente(String cedula, String nombres, String Apellidos, String f_nacimiento, String procedencia, String direccion){
		
	}
	
	public int buscarPasiente(String cedula, String nombres, String Apellidos, String f_nacimiento, String procedencia, String direccion){
		return 0;
	}
	
	public int EditarPasiente(String cedula, String nombres, String Apellidos, String f_nacimiento, String procedencia, String direccion){
		
		return 0;
	}
	
	public int registrarMedico(String rif, String nombres, String Apellidos){
		
		return 0;
	}
	
	public int buscarMedico(String rif, String nombres, String Apellidos){
		
		return 0;
	}
	
	public String listarMedicos(){
		
		return "";
	}
	
	public int editarMedico(String rif, String nombres, String Apellidos){
		
		return 0;
	}
	
	
}

