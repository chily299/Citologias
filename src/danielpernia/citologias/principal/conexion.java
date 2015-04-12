package danielpernia.citologias.principal;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.itextpdf.awt.geom.misc.Messages;



public class conexion {
	
	public String ruta,consulta;
	Connection conn = null;
	Statement sentencia = null;
	
	public conexion(){
		 ruta = "C:\\Users\\Daniel Pernia\\workspace\\citologias\\db.sqlite";
		 //ruta = "..\\db.sqlite";
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
			String sql = "UPDATE INTO usuario (rol,nombre,contrasenna) " +
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
			String sql = "INSERT INTO consulta (motivo_consulta,diagnostico,embarazos,cesareas,partos,abortos,ultimo_embarazo,"
					+ "fur,fecha_fur,citologia,citologia_fecha,biopsia,biopsia_fecha,muestra_de,sitio_lesion,id_medico,"
					+ "irradiacion,irradiacion_fecha,quimioterapia,quimioterapia_fecha,quirurgico,hormonas,diu,anticonceptivos_orales,anticonceptivos_orales_descripcion,"
					+ "resultado,info_muestra_1,info_muestra_2,info_muestra_3,clasificacion_1,clasificacion_2,clasificacion_3,clasificacion_4,clasificacion_descripcion,"
					+ "numero_impresion,fecha_muestra,fecha_resultado,estado,cedula_pasiente) " +
	                   "VALUES ( '"+estudio.motivo_consulta+"','"+estudio.diagnostico+"',"
	                   		+ ""+estudio.embarazos+","+estudio.cesareas+","+estudio.partos+","+estudio.abortos+",'"+estudio.f_ultimo_embarazo+"',"
	                   		+ ""+estudio.FUR+",'"+estudio.f_FUR+"',"+estudio.diu+","+estudio.citologia+",'"+estudio.f_citologia+"',"+estudio.biopsia+",'"+estudio.f_biopsia+"',"
	                   		+ "'"+estudio.muestra_de+"','"+estudio.sitio_lesion+"',"+estudio.id_medico+","
	                   		+ ""+estudio.irradiacion+",'"+estudio.f_irradiacion+"',"+estudio.quimio+",'"+estudio.f_quimio+"',"
	                   		+ "'"+estudio.quirurgico+"','"+estudio.hormonas+"',"+estudio.anticonceptivo+",'"+estudio.d_anticonceptivo+"',"
	                   		+ "'"+estudio.resultado+"',"+estudio.info_muestra1+","+estudio.info_muestra2+","+estudio.info_muestra3+","
	                   		+ ""+estudio.clasificacion1+","+estudio.clasificacion2+","+estudio.clasificacion3+","+estudio.clasificacion4+",'"+estudio.clasificacion_detalle+"',"
	                   		+ ""+estudio.numero_impresiones+",'"+estudio.fecha_muestra+"','"+estudio.fecha_resultado+"','"+estudio.estado+"','"+estudio.cedula_pasiente+"');"; 
			sentencia.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Estudio Registrado");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problemas Registrando. Codigo: "+e.getErrorCode());
		}
	
		return 0;
	}

	public int buscarEstudioCedula(String cedula,Vector<estudio_citologico> estudio){
		estudio_citologico estudio_ ;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where cedula_pasiente = '"+cedula+"';" );
			int i =0;
			
			while ( rs.next() ) {
				estudio_ = new estudio_citologico();
				//estudio_.rowid = rs.getInt("rowid");
				estudio_.motivo_consulta = rs.getString("motivo_consulta");
				estudio_.diagnostico = rs.getString("diagnostico");
			     
				estudio_.embarazos = rs.getInt("embarazos");
				estudio_.cesareas = rs.getInt("cesareas");
				estudio_.partos = rs.getInt("partos");
				estudio_.abortos = rs.getInt("abortos");
				estudio_.f_ultimo_embarazo = rs.getString("ultimo_embarazo");
				estudio_.FUR = rs.getInt("fur");
				estudio_.f_FUR = rs.getString("fecha_fur");
				estudio_.citologia = rs.getInt("citologia");
				estudio_.f_citologia = rs.getString("biopsia_fecha");
				estudio_.biopsia = rs.getInt("biopsia");
				estudio_.f_biopsia = rs.getString("biopsia_fecha");
				estudio_.muestra_de = rs.getString("muestra_de");
				estudio_.sitio_lesion = rs.getString("sitio_lesion");
				estudio_.id_medico = rs.getInt("id_medico");
			     
			   	estudio_.irradiacion = rs.getInt("irradiacion");
				estudio_.f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio_.quimio = rs.getInt("quimioterapia");
			    estudio_.f_quimio = rs.getString("quimioterapia_fecha");
			    estudio_.quirurgico = rs.getString("quirurgico");
			    estudio_.hormonas = rs.getString("hormonas");
			    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
			    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio_.resultado = rs.getString("resultado");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_2");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_2");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_4");
			     
			    estudio_.numero_impresiones = rs.getInt("numero_impresion");
			    estudio_.fecha_muestra = rs.getString("fecha_muestra");
			    estudio_.fecha_resultado = rs.getString("fecha_resultado");
			    estudio_.estado = rs.getString("estado");
			     
			     estudio.add(estudio_);
			     
			     //imprimir
			     //System.out.println( "ID_ 2312 = " + estudio_.motivo_consulta );
			    // System.out.println( "ROL = " + estudio[i].diagnostico );
			    // System.out.println();
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
				estudio[i].FUR = rs.getInt("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getInt("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getInt("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getInt("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getInt("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getInt("anticonceptivos_orales");
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
				estudio[i].FUR = rs.getInt("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getInt("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getInt("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getInt("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getInt("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getInt("anticonceptivos_orales");
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
				estudio[i].FUR = rs.getInt("fur");
				estudio[i].f_FUR = rs.getString("fecha_fur");
				estudio[i].citologia = rs.getInt("citologia");
				estudio[i].f_citologia = rs.getString("biopsia_fecha");
				estudio[i].biopsia = rs.getInt("biopsia");
				estudio[i].f_biopsia = rs.getString("biopsia_fecha");
				estudio[i].muestra_de = rs.getString("muestra_de");
				estudio[i].sitio_lesion = rs.getString("sitio_lesion");
				estudio[i].id_medico = rs.getInt("id_medico");
			     
			   	estudio[i].irradiacion = rs.getInt("irradiacion");
				estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
			    estudio[i].quimio = rs.getInt("quimioterapia");
			    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
			    estudio[i].quirurgico = rs.getString("quirurgico");
			    estudio[i].hormonas = rs.getString("hormonas");
			    estudio[i].anticonceptivo = rs.getInt("anticonceptivos_orales");
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
			estudio[i].FUR = rs.getInt("fur");
			estudio[i].f_FUR = rs.getString("fecha_fur");
			estudio[i].citologia = rs.getInt("citologia");
			estudio[i].f_citologia = rs.getString("biopsia_fecha");
			estudio[i].biopsia = rs.getInt("biopsia");
			estudio[i].f_biopsia = rs.getString("biopsia_fecha");
			estudio[i].muestra_de = rs.getString("muestra_de");
			estudio[i].sitio_lesion = rs.getString("sitio_lesion");
			estudio[i].id_medico = rs.getInt("id_medico");
		     
		   	estudio[i].irradiacion = rs.getInt("irradiacion");
			estudio[i].f_irradiacion = rs.getString("irradiacion_fecha");
		    estudio[i].quimio = rs.getInt("quimioterapia");
		    estudio[i].f_quimio = rs.getString("quimioterapia_fecha");
		    estudio[i].quirurgico = rs.getString("quirurgico");
		    estudio[i].hormonas = rs.getString("hormonas");
		    estudio[i].anticonceptivo = rs.getInt("anticonceptivos_orales");
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
	
	
	public void registrarPasiente(pasiente pasiente_){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO pasiente (cedula,nombres,apellidos,fecha_nacimiento,procedencia,direccion,telefono) " +
	                   "VALUES ('"+pasiente_.cedula+"', '"+pasiente_.nombres+"','"+pasiente_.Apellidos+"','"+pasiente_.f_nacimiento+" 00:00:00','"+pasiente_.procedencia+"','"+pasiente_.direccion+"','"+pasiente_.telefono+"');"; 
			sentencia.executeUpdate(sql);
			//System.out.println("fin insert exitoso");
			JOptionPane.showMessageDialog(null, "Pasiente "+pasiente_.cedula+" Registrado");
		} catch (SQLException e) {
			if(e.getErrorCode() == 0){
				JOptionPane.showMessageDialog(null, "Cedula "+pasiente_.cedula+" Ya esta Registrada. Codigo:"+e.getErrorCode());
			}else{
				JOptionPane.showMessageDialog(null, "Tengo problemas para Registrada. Codigo:"+e.getErrorCode());
			}
		}
		
		
	}
	
	public int buscarPasientePorCedula(pasiente pasiente_){
		int encontrado =0;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM pasiente WHERE cedula = '"+pasiente_.cedula+"';" );
			
			while ( rs.next() ) {
				encontrado = 1;
				//pasiente_.rowid = rs.getInt("rowid");
				pasiente_.cedula = rs.getString("cedula");
				pasiente_.nombres = rs.getString("nombres");
				pasiente_.Apellidos = rs.getString("apellidos");
				pasiente_.f_nacimiento = rs.getString("fecha_nacimiento");
				pasiente_.procedencia = rs.getString("procedencia");
				pasiente_.direccion = rs.getString("direccion");
				pasiente_.telefono = rs.getString("telefono");
				//pasiente_.rowid = rs.getInt(0);

			}

			rs.close();
			sentencia.close();
			return encontrado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return 0;
	}
	
	public int buscarPasientePorRowId(pasiente pasiente_){
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where rowid = '"+pasiente_.rowid+"';" );
			
			while ( rs.next() ) {
				pasiente_.rowid = rs.getInt("rowid");
				pasiente_.cedula = rs.getString("cedula");
				pasiente_.nombres = rs.getString("nombres");
				pasiente_.Apellidos = rs.getString("apellidos");
				pasiente_.f_nacimiento = rs.getString("fecha_nacimiento");
				pasiente_.procedencia = rs.getString("procedencia");
				pasiente_.direccion = rs.getString("direccion");
			     
			     //imprimir
			     System.out.println( "ID = " + pasiente_.rowid );
			     System.out.println( "ROL = " +pasiente_.cedula);
			     System.out.println();
		
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
	public int EditarPasiente(pasiente pasiente_){
		
		try {
			sentencia = conn.createStatement();
			String sql = 	"UPDATE INTO usuario (nombres,apellidos,fecha_nacimiento,procedencia,direccion) " +
	                   		"VALUES ('"+pasiente_.nombres+"','"+pasiente_.Apellidos+"','"+pasiente_.f_nacimiento+"','"+pasiente_.procedencia+"','"+pasiente_.direccion+"')"
	                   		+ " WHERE rowid = "+pasiente_.rowid+";"; 
			sentencia.executeUpdate(sql);
			//System.out.println("fin insert exitoso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int registrarMedico(medico medico_){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO medico (rif,nombres,apellidos) " +
	                   "VALUES ('"+medico_.rif+"', '"+medico_.nombres+"','"+medico_.Apellidos+"');"; 
			sentencia.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Medico "+medico_.rif+" Registrado");
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			if(e.getErrorCode()==0){
				JOptionPane.showMessageDialog(null, " RIF Ya de encuentra registrado - Puede Editar o usar un nuevo RIF. Codigo: "+e.getErrorCode());
				
			}else{
				JOptionPane.showMessageDialog(null, " No se puede registrar, Falla Codigo "+e.getErrorCode() +"descripcion: " +e.getMessage());
			}
		
		}	
		
		
		return 0;
	}
	
	public int buscarMedico(medico medico_){
		
		int encontrado =0;
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM medico where rif = '"+medico_.rif+"';" );
			System.out.println("busco medico"+medico_.rif);
			
			while ( rs.next() ) {
				encontrado = 1;
				medico_.id_medico = rs.getInt("id_medico");
				medico_.rif = rs.getString("rif");
				medico_.nombres = rs.getString("nombres");
				medico_.Apellidos = rs.getString("apellidos");
				

			     System.out.println( "id = " +medico_.id_medico);
				
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(encontrado==0){
			medico_.id_medico = -1;
			JOptionPane.showMessageDialog(null, "Medico "+medico_.rif+" No encontrado");
		}
		return encontrado;
	}
	
	public int listarMedicos(Vector<medico> medico_v){
		int i =0;
		medico medico_;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM medico;" );
			
			
			while ( rs.next() ) {
				medico_ = new medico();
				medico_.id_medico = rs.getInt("id_medico");
				medico_.rif = rs.getString("rif");
				medico_.nombres = rs.getString("nombres");
				medico_.Apellidos = rs.getString("apellidos");
			    
				medico_v.add(medico_);
			     //imprimir
			     System.out.println( "ID = " + medico_.id_medico );
			     System.out.println( "ROL = " +medico_.rif);
		
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	public int editarMedico(medico medico_){
		
		try {
			
			//imprimir
		     System.out.println( "ID = " + medico_.id_medico );
		     System.out.println( "rif = " +medico_.rif);
		     System.out.println( "nombre = " +medico_.nombres);
		     System.out.println( "apellidos = " +medico_.Apellidos);
		     System.out.println();
			
			sentencia = conn.createStatement();
			String sql = "UPDATE medico SET rif = '"+medico_.rif+"',nombres = '"+medico_.nombres+"',apellidos= '"+medico_.Apellidos+"' "
	                   	 + " WHERE id_medico = "+medico_.id_medico+";"; 
			sentencia.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Medico "+medico_.rif+" Fue Actualizado");
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Medico "+medico_.rif+" No se puede Actualizar - Codigo: "+e.getErrorCode());
		}	
		
		return 0;
	}
	
	
}

