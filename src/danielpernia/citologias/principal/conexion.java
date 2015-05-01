package danielpernia.citologias.principal;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;




public class conexion {
	
	public String ruta,consulta;
	Connection conn = null;
	Statement sentencia = null;
	
	public conexion(){
		// ruta = "C:\\Program Files (x86)\\citologias\\db.sqlite";
		 ruta = "db.sqlite";
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
			     //String  name = rs.getString("nombre");
			     //String age  = rs.getString("contrasenna");
			     //System.out.println( "ID = " + id );
			     //System.out.println( "ROL = " + rol );
			     //System.out.println( "NAME = " + name );
			     //System.out.println( "contrasenna = " + age );
			     //System.out.println();
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return usuarioAutorizado;
		
	}
	
	public int listarPacientes(Vector<paciente> paciente_v){
		int i =0;
		paciente paciente_;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM paciente;" );
			
			
			while ( rs.next() ) {
				paciente_ = new paciente();
				
				paciente_.cedula = rs.getString("cedula");
				paciente_.nombres = rs.getString("nombres");
				paciente_.Apellidos = rs.getString("apellidos");
				paciente_.edad = rs.getInt("edad");
				paciente_.procedencia = rs.getString("procedencia");
				paciente_.direccion = rs.getString("direccion");
				paciente_.telefono = rs.getString("telefono");
			    
				paciente_v.add(paciente_);
			     //imprimir
			    // System.out.println( "ID = " + medico_.id_medico );
			    // System.out.println( "ROL = " +medico_.rif);
		
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	
	public boolean buscarUsuarioPorCedula(usuario usu,boolean alerta){
		
		boolean usuarioAutorizado = false;
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM usuario where cedula = '"+usu.cedula+"';" );
			while ( rs.next() ) {
				 usuarioAutorizado = true;
			     //id = rs.getInt("rowid");
			     usu.nombres = rs.getString("nombre");
			     usu.apellidos= rs.getString("apellidos");
			     usu.rol = rs.getInt("rol");
			     usu.clave  = rs.getString("contrasenna");
			}

			rs.close();
			sentencia.close();
			return usuarioAutorizado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		if(alerta)
			JOptionPane.showMessageDialog(null, "No se encuentra");
		
		return usuarioAutorizado;
		
	}
	
	public int registrarUsuarioNuevo(usuario usu,boolean alerta){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO usuario (rol,nombre,contrasenna,cedula,apellidos) " +
	                   "VALUES ("+usu.rol+", '"+usu.nombres+"','"+usu.clave+"','"+usu.cedula+"','"+usu.apellidos+"');"; 
			sentencia.executeUpdate(sql);
			if(alerta)
				JOptionPane.showMessageDialog(null, "Usuario Registrado");
			return 1;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuario No Registrado Codigo: "+e.getErrorCode());
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int actualizarUsuario(usuario usu){
		
		try {
			sentencia = conn.createStatement();
			String sql = "UPDATE usuario SET rol="+usu.rol+",nombre='"+usu.nombres+"',contrasenna='"+usu.clave+"',apellidos='"+usu.apellidos+"' " +
	                   "WHERE cedula ='"+usu.cedula+"';"; 
			sentencia.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Usuario "+usu.cedula+" Actualizado");
			return 1;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas para actualizar Codigo: "+e.getErrorCode());
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int guardarEstudio(estudio_citologico estudio,boolean alerta){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO consulta (motivo_consulta,diagnostico,embarazos,cesareas,partos,abortos,ultimo_embarazo,"
					+ "fur,fecha_fur,citologia,citologia_fecha,biopsia,biopsia_fecha,muestra_de,sitio_lesion,id_medico,"
					+ "irradiacion,irradiacion_fecha,quimioterapia,quimioterapia_fecha,quirurgico,hormonas,diu,anticonceptivos_orales,anticonceptivos_orales_descripcion,"
					+ "resultado,info_muestra_1,info_muestra_2,info_muestra_3,clasificacion_1,clasificacion_2,clasificacion_3,clasificacion_4,clasificacion_descripcion,"
					+ "numero_impresion,fecha_muestra,fecha_resultado,estado,cedula_paciente) " +
	                   "VALUES ( '"+estudio.motivo_consulta+"','"+estudio.diagnostico+"',"
	                   		+ ""+estudio.embarazos+","+estudio.cesareas+","+estudio.partos+","+estudio.abortos+",'"+estudio.f_ultimo_embarazo+"',"
	                   		+ ""+estudio.FUR+",'"+estudio.f_FUR+"',"+estudio.citologia+",'"+estudio.f_citologia+"',"+estudio.biopsia+",'"+estudio.f_biopsia+"',"
	                   		+ "'"+estudio.muestra_de+"','"+estudio.sitio_lesion+"',"+estudio.id_medico+","
	                   		+ ""+estudio.irradiacion+",'"+estudio.f_irradiacion+"',"+estudio.quimio+",'"+estudio.f_quimio+"',"
	                   		+ "'"+estudio.quirurgico+"','"+estudio.hormonas+"',"+estudio.diu+","+estudio.anticonceptivo+",'"+estudio.d_anticonceptivo+"',"
	                   		+ "'"+estudio.resultado+"',"+estudio.info_muestra1+","+estudio.info_muestra2+","+estudio.info_muestra3+","
	                   		+ ""+estudio.clasificacion1+","+estudio.clasificacion2+","+estudio.clasificacion3+","+estudio.clasificacion4+",'"+estudio.clasificacion_detalle+"',"
	                   		+ ""+estudio.numero_impresiones+",'"+estudio.fecha_muestra+"','"+estudio.fecha_resultado+"','"+estudio.estado+"','"+estudio.cedula_paciente+"');"; 
			sentencia.executeUpdate(sql);
			if(alerta)
				JOptionPane.showMessageDialog(null, "Estudio Registrado");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			if(alerta)
				JOptionPane.showMessageDialog(null, "Problemas Registrando. Codigo: "+e.getErrorCode());
		}
	
		return 0;
	}

	public int buscarEstudioPorId(estudio_citologico estudio_){
		int encontrado =0;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where id_consulta = "+estudio_.rowid+";" );
			
			while ( rs.next() ) {
				encontrado = 1;
				//estudio_ = new estudio_citologico();
				
				estudio_.rowid = rs.getInt("id_consulta");
				//System.out.println("rowid ? "+estudio_.rowid);
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
				estudio_.f_citologia = rs.getString("citologia_fecha");
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
			    estudio_.diu = rs.getInt("DIU");
			    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
			    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio_.resultado = rs.getString("resultado");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
			    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
			    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
			    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
			    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
			    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
			     
			    estudio_.numero_impresiones = rs.getInt("numero_impresion");
			    estudio_.fecha_muestra = rs.getString("fecha_muestra");
			    estudio_.fecha_resultado = rs.getString("fecha_resultado");
			    estudio_.estado = rs.getString("estado");
			    estudio_.cedula_paciente = rs.getString("cedula_paciente");
			    //System.out.println("cedula en la busqueda "+estudio_.cedula_paciente);
			    
			   
			  }
			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return encontrado;
	}
	
	public int buscarEstudioCedula(String cedula,Vector<estudio_citologico> estudio){
		estudio_citologico estudio_ ;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where cedula_paciente = '"+cedula+"';" );
			
			while ( rs.next() ) {
				estudio_ = new estudio_citologico();
				
				estudio_.rowid = rs.getInt("id_consulta");
				//System.out.println("rowid ? "+estudio_.rowid);
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
				estudio_.f_citologia = rs.getString("citologia_fecha");
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
			    estudio_.diu = rs.getInt("DIU");
			    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
			    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio_.resultado = rs.getString("resultado");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
			    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
			    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
			    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
			    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
			    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
			     
			    estudio_.numero_impresiones = rs.getInt("numero_impresion");
			    estudio_.fecha_muestra = rs.getString("fecha_muestra");
			    estudio_.fecha_resultado = rs.getString("fecha_resultado");
			    estudio_.estado = rs.getString("estado");
			    estudio_.cedula_paciente = rs.getString("cedula_paciente");
			    estudio.add(estudio_);
			    
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
			String sql = "UPDATE consulta SET motivo_consulta ='"+estudio.motivo_consulta+"',diagnostico='"+estudio.diagnostico+"',"
					+ "embarazos="+estudio.embarazos+",cesareas="+estudio.cesareas+",partos="+estudio.partos+",abortos="+estudio.abortos+",ultimo_embarazo='"+estudio.f_ultimo_embarazo+"',"
					+ "fur="+estudio.FUR+",fecha_fur='"+estudio.f_FUR+"',citologia="+estudio.citologia+",citologia_fecha='"+estudio.f_citologia+"',biopsia="+estudio.biopsia+",biopsia_fecha='"+estudio.f_biopsia+"',"
					+ "muestra_de='"+estudio.muestra_de+"',sitio_lesion='"+estudio.sitio_lesion+"',id_medico="+estudio.id_medico+","
					+ "irradiacion="+estudio.irradiacion+",irradiacion_fecha='"+estudio.f_irradiacion+"',quimioterapia="+estudio.quimio+",quimioterapia_fecha='"+estudio.f_quimio+"',"
					+ "quirurgico='"+estudio.quirurgico+"',hormonas='"+estudio.hormonas+"',anticonceptivos_orales="+estudio.anticonceptivo+",anticonceptivos_orales_descripcion='"+estudio.d_anticonceptivo+"',"
					+ "resultado='"+estudio.resultado+"',info_muestra_1="+estudio.info_muestra1+",info_muestra_2="+estudio.info_muestra2+",info_muestra_3="+estudio.info_muestra3+","
					+ "clasificacion_1="+estudio.clasificacion1+",clasificacion_2="+estudio.clasificacion2+",clasificacion_3="+estudio.clasificacion3+",clasificacion_4="+estudio.clasificacion4+","
					+ "clasificacion_descripcion='"+estudio.clasificacion_detalle+"',"
					+ "fecha_muestra='"+estudio.fecha_muestra+"',fecha_resultado=datetime(),estado= '"+estudio.estado+"'"
					+ " WHERE id_consulta ="+estudio.rowid+";"; 
			sentencia.executeUpdate(sql);
			
			
			
			
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede Editar. Codigo: "+e.getErrorCode());
		}
	
		return 0;
	}
	
	public int actualizarImpresionesDeEstudio(estudio_citologico estudio){
		estudio.numero_impresiones++;
		try {
			sentencia = conn.createStatement();
			String sql = "UPDATE consulta SET numero_impresion = "+estudio.numero_impresiones+" " +
	                     " WHERE id_consulta ="+estudio.rowid+";"; 
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return 0;
	}
	
	public int buscarEstudiosPendientesPorImprimir(Vector<estudio_citologico> estudio){
		estudio_citologico estudio_ ;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where numero_impresion < 1 AND estado = 'terminado'" );
			
			while ( rs.next() ) {
				estudio_ = new estudio_citologico();
				
				estudio_.rowid = rs.getInt("id_consulta");
				//System.out.println("rowid ? "+estudio_.rowid);
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
				estudio_.f_citologia = rs.getString("citologia_fecha");
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
			    estudio_.diu = rs.getInt("DIU");
			    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
			    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio_.resultado = rs.getString("resultado");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
			    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
			    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
			    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
			    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
			    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
			     
			    estudio_.numero_impresiones = rs.getInt("numero_impresion");
			    estudio_.fecha_muestra = rs.getString("fecha_muestra");
			    estudio_.fecha_resultado = rs.getString("fecha_resultado");
			    estudio_.estado = rs.getString("estado");
			    estudio_.cedula_paciente = rs.getString("cedula_paciente");
			     estudio.add(estudio_);
			     
			     //imprimir
			     //System.out.println( "ID_ 2312 = " + estudio_.motivo_consulta );
			    // System.out.println( "ROL = " + estudio[i].diagnostico );
			    // System.out.println();
			     
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
	public int buscarEstudiosPendientesPorResultado( Vector<estudio_citologico> estudio){
		
		estudio_citologico estudio_ ;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where estado = 'esperando resultado'" );
			//int i =0;
			
			while ( rs.next() ) {
				estudio_ = new estudio_citologico();
				
				estudio_.rowid = rs.getInt("id_consulta");
				//System.out.println("rowid ? "+estudio_.rowid);
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
				estudio_.f_citologia = rs.getString("citologia_fecha");
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
			    estudio_.diu = rs.getInt("DIU");
			    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
			    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio_.resultado = rs.getString("resultado");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
			    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
			    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
			    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
			    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
			    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
			     
			    estudio_.numero_impresiones = rs.getInt("numero_impresion");
			    estudio_.fecha_muestra = rs.getString("fecha_muestra");
			    estudio_.fecha_resultado = rs.getString("fecha_resultado");
			    estudio_.estado = rs.getString("estado");
			    estudio_.cedula_paciente = rs.getString("cedula_paciente");
			    estudio.add(estudio_);
			     
			     //imprimir
			     //System.out.println( "ID_ 2312 = " + estudio_.motivo_consulta );
			    // System.out.println( "ROL = " + estudio[i].diagnostico );
			    // System.out.println();
			    // i++;
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}
	
	public int buscarEstudiosPorDia(Vector<estudio_citologico> estudio){
		estudio_citologico estudio_ ;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where fecha_resultado >= date('now','-1 day') AND estado ='terminado';" );
			//int i =0;
			
			while ( rs.next() ) {
				estudio_ = new estudio_citologico();
				
				estudio_.rowid = rs.getInt("id_consulta");
				//System.out.println("rowid ? "+estudio_.rowid);
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
				estudio_.f_citologia = rs.getString("citologia_fecha");
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
			    estudio_.diu = rs.getInt("DIU");
			    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
			    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
			     
			    estudio_.resultado = rs.getString("resultado");
			    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
			    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
			    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
			    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
			    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
			    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
			    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
			     
			    estudio_.numero_impresiones = rs.getInt("numero_impresion");
			    estudio_.fecha_muestra = rs.getString("fecha_muestra");
			    estudio_.fecha_resultado = rs.getString("fecha_resultado");
			    estudio_.estado = rs.getString("estado");
			    estudio_.cedula_paciente = rs.getString("cedula_paciente");
			    estudio.add(estudio_);
			     
			     //imprimir
			     //System.out.println( "ID_ 2312 = " + estudio_.motivo_consulta );
			    // System.out.println( "ROL = " + estudio[i].diagnostico );
			    // System.out.println();
			     //i++;
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;			


	}

	public int buscarEstudiosPorSemana(Vector<estudio_citologico> estudio){
	estudio_citologico estudio_;
	
	try {
		sentencia = conn.createStatement();
		ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where fecha_resultado >= date('now','-7 day') AND estado ='terminado';" );
		//int i =0;
		
		while ( rs.next() ) {
			estudio_ = new estudio_citologico();
			
			estudio_.rowid = rs.getInt("id_consulta");
			//System.out.println("rowid ? "+estudio_.rowid);
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
			estudio_.f_citologia = rs.getString("citologia_fecha");
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
		    estudio_.diu = rs.getInt("DIU");
		    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
		    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
		     
		    estudio_.resultado = rs.getString("resultado");
		    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
		    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
		    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
		    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
		    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
		    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
		    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
		     
		    estudio_.numero_impresiones = rs.getInt("numero_impresion");
		    estudio_.fecha_muestra = rs.getString("fecha_muestra");
		    estudio_.fecha_resultado = rs.getString("fecha_resultado");
		    estudio_.estado = rs.getString("estado");
		    estudio_.cedula_paciente = rs.getString("cedula_paciente");
		    estudio.add(estudio_);
		     
		     //imprimir
		     //System.out.println( "ID_ 2312 = " + estudio_.motivo_consulta );
		    // System.out.println( "ROL = " + estudio[i].diagnostico );
		    // System.out.println();
		    // i++;
		}

		rs.close();
		sentencia.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	return 0;
}
	
	public int listarTodosLosEstudios(Vector<estudio_citologico> estudio){
	estudio_citologico estudio_;
	
	try {
		sentencia = conn.createStatement();
		ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta ;" );
		//int i =0;
		
		while ( rs.next() ) {
			estudio_ = new estudio_citologico();
			
			estudio_.rowid = rs.getInt("id_consulta");
			//System.out.println("rowid ? "+estudio_.rowid);
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
			estudio_.f_citologia = rs.getString("citologia_fecha");
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
		    estudio_.diu = rs.getInt("DIU");
		    estudio_.anticonceptivo = rs.getInt("anticonceptivos_orales");
		    estudio_.d_anticonceptivo = rs.getString("anticonceptivos_orales_descripcion");
		     
		    estudio_.resultado = rs.getString("resultado");
		    estudio_.info_muestra1 = rs.getInt("info_muestra_1");
		    estudio_.info_muestra2 = rs.getInt("info_muestra_2");
		    estudio_.info_muestra3 = rs.getInt("info_muestra_3");
		    estudio_.clasificacion1 = rs.getInt("clasificacion_1");
		    estudio_.clasificacion2 = rs.getInt("clasificacion_2");
		    estudio_.clasificacion3 = rs.getInt("clasificacion_3");
		    estudio_.clasificacion4 = rs.getInt("clasificacion_4");
		     
		    estudio_.numero_impresiones = rs.getInt("numero_impresion");
		    estudio_.fecha_muestra = rs.getString("fecha_muestra");
		    estudio_.fecha_resultado = rs.getString("fecha_resultado");
		    estudio_.estado = rs.getString("estado");
		    estudio_.cedula_paciente = rs.getString("cedula_paciente");
		    estudio.add(estudio_);
		     
		     //imprimir
		     //System.out.println( "ID_ 2312 = " + estudio_.motivo_consulta );
		    // System.out.println( "ROL = " + estudio[i].diagnostico );
		    // System.out.println();
		    // i++;
		}

		rs.close();
		sentencia.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	return 0;
}

	public void registrarPasiente(paciente paciente_,boolean alerta){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO paciente (cedula,nombres,apellidos,edad,procedencia,direccion,telefono) " +
	                   "VALUES ('"+paciente_.cedula+"', '"+paciente_.nombres+"','"+paciente_.Apellidos+"',"+paciente_.edad+",'"+paciente_.procedencia+"','"+paciente_.direccion+"','"+paciente_.telefono+"');"; 
			sentencia.executeUpdate(sql);
			//System.out.println("fin insert exitoso");
			if(alerta)
				JOptionPane.showMessageDialog(null, "Pasiente "+paciente_.cedula+" Registrado");
		} catch (SQLException e) {
			if(e.getErrorCode() == 0){
				JOptionPane.showMessageDialog(null, "Cedula "+paciente_.cedula+" Ya esta Registrada. Codigo:"+e.getErrorCode());
			}else{
				JOptionPane.showMessageDialog(null, "Tengo problemas para Registrada. Codigo:"+e.getErrorCode());
			}
		}
		
		
	}
	
	public int buscarPasientePorCedula(paciente paciente_){
		int encontrado =0;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM paciente WHERE cedula = '"+paciente_.cedula+"';" );
			
			while ( rs.next() ) {
				encontrado = 1;
				//paciente_.rowid = rs.getInt("rowid");
				paciente_.cedula = rs.getString("cedula");
				paciente_.nombres = rs.getString("nombres");
				paciente_.Apellidos = rs.getString("apellidos");
				paciente_.edad = rs.getInt("edad");
				paciente_.procedencia = rs.getString("procedencia");
				paciente_.direccion = rs.getString("direccion");
				paciente_.telefono = rs.getString("telefono");
				//paciente_.rowid = rs.getInt(0);

			}

			rs.close();
			sentencia.close();
			return encontrado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return encontrado;
	}
	
	public int buscarPasientePorRowId(paciente paciente_){
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM consulta where rowid = '"+paciente_.rowid+"';" );
			
			while ( rs.next() ) {
				paciente_.rowid = rs.getInt("rowid");
				paciente_.cedula = rs.getString("cedula");
				paciente_.nombres = rs.getString("nombres");
				paciente_.Apellidos = rs.getString("apellidos");
				paciente_.edad = rs.getInt("edad");
				paciente_.procedencia = rs.getString("procedencia");
				paciente_.direccion = rs.getString("direccion");
			     
			     //imprimir
			   //  System.out.println( "ID = " + paciente_.rowid );
			   //  System.out.println( "ROL = " +paciente_.cedula);
			   //  System.out.println();
		
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
	public int EditarPasiente(paciente paciente_){
		
		try {
			sentencia = conn.createStatement();
			String sql = 	"UPDATE INTO usuario (nombres,apellidos,edad,procedencia,direccion) " +
	                   		"VALUES ('"+paciente_.nombres+"','"+paciente_.Apellidos+"',"+paciente_.edad+",'"+paciente_.procedencia+"','"+paciente_.direccion+"')"
	                   		+ " WHERE rowid = "+paciente_.rowid+";"; 
			sentencia.executeUpdate(sql);
			//System.out.println("fin insert exitoso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int listarUsuarios(Vector<usuario> usuario_v){
		int i =0;
		usuario usuario_;
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM usuario;" );
			
			
			while ( rs.next() ) {
				usuario_ = new usuario();
				
				 usuario_.cedula = rs.getString("cedula");
				 usuario_.nombres = rs.getString("nombre");
				 usuario_.apellidos= rs.getString("apellidos");
				 usuario_.rol = rs.getInt("rol");
			     usuario_.clave  = rs.getString("contrasenna");
			    
				usuario_v.add(usuario_);
			     //imprimir
			    // System.out.println( "ID = " + medico_.id_medico );
			    // System.out.println( "ROL = " +medico_.rif);
		
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	public int registrarMedico(medico medico_,boolean alerta){
		
		try {
			sentencia = conn.createStatement();
			String sql = "INSERT INTO medico (rif,nombres,apellidos) " +
	                   "VALUES ('"+medico_.rif+"', '"+medico_.nombres+"','"+medico_.Apellidos+"');"; 
			sentencia.executeUpdate(sql);
			if(alerta)
				JOptionPane.showMessageDialog(null, "Medico "+medico_.rif+" Registrado");
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			if(e.getErrorCode()==0){
				if(alerta)
					JOptionPane.showMessageDialog(null, " RIF Ya de encuentra registrado - Puede Editar o usar un nuevo RIF. Codigo: "+e.getErrorCode());
				
			}else{
				if(alerta)
					JOptionPane.showMessageDialog(null, " No se puede registrar, Falla Codigo "+e.getErrorCode() +"descripcion: " +e.getMessage());
			}
			
			e.printStackTrace();
		
		}	
		
		
		return 0;
	}
	
	public int buscarMedico(medico medico_,boolean alertas){
		
		int encontrado =0;
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM medico where rif = '"+medico_.rif+"';" );
			//System.out.println("busco medico"+medico_.rif);
			
			while ( rs.next() ) {
				encontrado = 1;
				medico_.id_medico = rs.getInt("id_medico");
				medico_.rif = rs.getString("rif");
				medico_.nombres = rs.getString("nombres");
				medico_.Apellidos = rs.getString("apellidos");
				

			     //System.out.println( "id = " +medico_.id_medico);
				
			}

			rs.close();
			sentencia.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(encontrado==0){
			medico_.id_medico = -1;
			if(alertas)
			JOptionPane.showMessageDialog(null, "Medico "+medico_.rif+" No encontrado");
		}
		return encontrado;
	}
	
	public int buscarMedicoPorId(medico medico_){
		
		int encontrado =0;
		
		try {
			sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery( "SELECT * FROM medico where id_medico = "+medico_.id_medico+";" );
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
	
	public void consultaEstadistica( String rif_medico, int edad_minima,int edad_maxima, int rango_fecha_dias, int categoria1,int categoria2,int categoria3,int categoria4,int estudios_consultados,int resultado){
		
		//estudios_consultados =0;
		//resultado =0;
		String info_categoria="";
		
		medico medico_ = new medico();
		if(!rif_medico.equals("Todos")){
			medico_.rif = rif_medico;
			buscarMedico(medico_, false);
			info_categoria+="Medico: "+medico_.rif+" ";
		}else{
			info_categoria+="Medico: Todos ";
		}
		
		
		
		String SQL =  "SELECT * FROM consulta AS con JOIN paciente AS pas ON con.cedula_paciente = pas.cedula WHERE ";
		
		if(!rif_medico.equals("Todos")){
			SQL+= "con.id_medico = "+medico_.id_medico+" AND ";
		}
		
		if(edad_minima!= -1){
			SQL+="pas.edad BETWEEN "+edad_minima+" AND "+edad_maxima+" AND ";
			info_categoria+="Edad: "+edad_minima+"-"+edad_maxima+" ";
		}else{
			info_categoria+="Edad: Todas ";
		}
		
		if(rango_fecha_dias != -1){
			SQL+="con.fecha_resultado >= date('now','-"+rango_fecha_dias+" day') AND ";
			info_categoria+="Tiempo: "+rango_fecha_dias+" dias \n";
		}else{
			info_categoria+="Tiempo: Todo el periodo \n";
		}
		
		String SQL_Total = SQL;
		
		if(categoria1!=-1){
			SQL+= "con.clasificacion_1 = "+categoria1+" AND ";
		}
		
		if(categoria2!=-1){
			SQL+= "con.clasificacion_2 = "+categoria2+" AND ";
		}
		
		if(categoria3!=-1){
			SQL+= "con.clasificacion_3 = "+categoria3+" AND ";
		}
		
		if(categoria4!=-1){
			SQL+= "con.clasificacion_4 = "+categoria4+" AND ";
		}
		
		if(categoria1 == 0){
			info_categoria+="NEGATIVO PARA LESIÓN INTRAEPITELIAL O MALIGNIDAD\n";
			if(categoria2 == 0){
				info_categoria+="MICROORGANISMOS ";
				if(categoria3 == 0){
					info_categoria+="Trichomonas vaginalis ";
				}else if(categoria3 == 1){
					info_categoria+="Elementos micóticos de características morfológicas compatibles con Candida ";
				}else if(categoria3 == 2){
					info_categoria+="Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA ";
				}else if(categoria3 == 3){
					info_categoria+="Bacterias de características morfológicas compatibles con Actinomyces ";
				}else if(categoria3 == 4){
					info_categoria+="Cambios celulares compatibles con HERPES SIMPLE ";
				}
			}else if(categoria2 == 1){
				info_categoria+="OTROS HALLAZGOS NO NEOPLÁSICOS";
				if(categoria3 == 0){
					info_categoria+="Cambios celulares reactivos asosiados a: ";
					if(categoria4 == 0){
						info_categoria+="Inflamación ";
					}else if(categoria4 == 1){
						info_categoria+="Radiación ";
					}else if(categoria4 == 2){
						info_categoria+="Dispositivo intrauterino (DIU) ";
					}
				}else if(categoria3 == 1){
					info_categoria+="Células glandulares poshisterectomía ";
				}else if(categoria3 == 2){
					info_categoria+="Atrofia ";
				}
			}
		}else if(categoria1 == 1){
			info_categoria+="OTROS HALLAZGOS\n";
			 if(categoria2 == 0){
					info_categoria+="CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años)  ";
					if(categoria3 == 0){
						info_categoria+="NEGATIVO PARA LESIÓN ESCAMOSA INTRAEPITELIAL ";
				 }
			 }
		}else if(categoria1 == 2){
			info_categoria+="ANOMALÍAS DE LAS CÉLULAS EPITELIALES\n";
			
		}else if(categoria1 == 3){
			info_categoria+="OTRAS NEOPLASIAS MALIGNAS\n";
			if(categoria2 == 0){
				info_categoria+="CÉLULAS ESCAMOSAS ";
				if(categoria3 == 0){
					info_categoria+="CÉLULAS ESCAMOSAS ATÍPICAS ";
					if(categoria4 == 0){
						info_categoria+="de significado indeterminado (ASC-US) ";
					}else if(categoria4 == 1){
						info_categoria+="no se puede descartar lesion escamosa intraepitelial de alto grado (ASC-H) ";
					}
				}else if(categoria3 == 1){
					info_categoria+="LESIÓN ESCAMOSA INTRAEPITELIAL DE BAJO GRADO (LSIL) ";
				}else if(categoria3 == 2){
					info_categoria+="LESIÓN ESCAMOSA INTRAEPITELIAL DE ALTO GRADO (HSIL) ";
					if(categoria4 == 0){
						info_categoria+="con hallazgos sospechosos de invación ";
					}
				}else if(categoria3 == 3){
					info_categoria+="CARCINOMA ESCAMOSO ";
				} 
		 }
			if(categoria2 == 1){
				info_categoria+="CÉLULAS GLANDULARES ";
				if(categoria3 == 0){
					info_categoria+="ATÍPICAS ";
					if(categoria4 == 0){
						info_categoria+="Células endocervicales ";
					}else if(categoria4 == 1){
						info_categoria+="Células endometriales ";
					}else if(categoria4 == 2){
						info_categoria+="Células glandulares ";
					}
				}else if(categoria3 == 1){
					info_categoria+="ATÍPICAS SUGESTIVAS A NEOPLASIA ";
					if(categoria4 == 0){
						info_categoria+="Células endocervicales ";
					}else if(categoria4 == 1){
						info_categoria+="Células glandulares ";
					}
				}else if(categoria3 == 2){
					info_categoria+="ADENOCARCINOMA ENDOCERVICAL (in situ) ";
				}else if(categoria3 == 3){
					info_categoria+="ADENOCARCINOMA ";
					if(categoria4 == 0){
						info_categoria+="Endocervical ";
					}else if(categoria4 == 1){
						info_categoria+="Endometrial ";
					}else if(categoria4 == 2){
						info_categoria+="Extrauterino ";
					}else if(categoria4 == 3){
						info_categoria+="Sin Especificar ";
					}
				} 
		 }
		}
		
		SQL+=		"con.estado ='terminado';";
		SQL_Total+= "con.estado ='terminado';";
		//System.out.println("SQL: "+SQL);
		
		
		try {
			sentencia = conn.createStatement();
			
			// calculo el total
			ResultSet rs = sentencia.executeQuery(SQL_Total);
			
			while ( rs.next() ) {
				
				estudios_consultados++;
			}
			// calculo por lesion
			rs = sentencia.executeQuery(SQL);
			
			while ( rs.next() ) {

				
				resultado++;
			}
			
			JOptionPane.showMessageDialog(null,info_categoria+" \nTodos los estudios sin tomar en cuenta la lesion: "+estudios_consultados+"\nEstudios encontrados con lesion: "+resultado);
			
			System.out.println("total "+estudios_consultados);
			System.out.println("resultado "+resultado);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void sincronizaDatos(Datos datos){
		int contMedicosNuevos=0;
		int contPacientesNuevos=0;
		int contEstudiosNuevos=0;
		int contUsuariosNuevos=0;
	    
		//medicos
		for (medico medicoNuevo : datos.medicos) {
			medico medicoAlmacenado = new medico();
			
			medicoAlmacenado.rif = medicoNuevo.rif;
			
			if(buscarMedico(medicoAlmacenado,false)!=1){
				
				registrarMedico(medicoNuevo,false);
				
				buscarMedico(medicoAlmacenado,false);
				
				for (estudio_citologico estudio : datos.estudios) {
					if(estudio.id_medico == medicoNuevo.id_medico){ // busco estudios con el id viejo
						estudio.id_medico = medicoAlmacenado.id_medico;
					}
				}
				
				contMedicosNuevos++;
			}else{
				if(medicoAlmacenado.id_medico == medicoNuevo.id_medico){
					
				}else{
					// si los id son diferentes se actualizan
					for (estudio_citologico estudio : datos.estudios) {
						if(estudio.id_medico == medicoNuevo.id_medico){ //
							estudio.id_medico = medicoAlmacenado.id_medico;
						}
					}
				}
			}
			
			
		}
		
		for (paciente pacienteNuevo : datos.pacientes) {
			paciente pacienteAlmacenado = new paciente();
			pacienteAlmacenado.cedula = pacienteNuevo.cedula;
			
			if(buscarPasientePorCedula(pacienteAlmacenado)==0){
				registrarPasiente(pacienteNuevo,false);
				contPacientesNuevos++;
			}
		}
		
		for (estudio_citologico estudioNuevo : datos.estudios) {
			Vector<estudio_citologico> estudioAlmacenado_v = new Vector<>(1);
			
			buscarEstudioCedula(estudioNuevo.cedula_paciente, estudioAlmacenado_v);
			boolean estudioYaEstaRegistado = false;
			
			for (estudio_citologico estudioAlmacenado : estudioAlmacenado_v) {
				if(estudioAlmacenado.fecha_muestra.equals(estudioNuevo.fecha_muestra)){
					estudioYaEstaRegistado = true;
				}
			}
			
			if(!estudioYaEstaRegistado){
				guardarEstudio(estudioNuevo,false);
				contEstudiosNuevos++;
			}
			
		}
		
		for (usuario usuarioNuevo : datos.usuarios) {
			usuario usuarioAlmacenado = new usuario();
			usuarioAlmacenado.cedula = usuarioNuevo.cedula;
			
			if(buscarUsuarioPorCedula(usuarioAlmacenado,false)){
				
			}else{
				registrarUsuarioNuevo(usuarioNuevo,false);
				contUsuariosNuevos++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Importacion de datos completa. Registros Nuevos: "+(contEstudiosNuevos+contMedicosNuevos+contPacientesNuevos+contUsuariosNuevos)+"");
	}
	
	public void analizar(){
		
	}
	
	
}

