package danielpernia.citologias.principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class sincronizaDatos {

	Gson gson;
	String json;
	public Datos datos;
	
	
	public sincronizaDatos() {
		// TODO Auto-generated constructor stub
		gson = new Gson();
		datos = new Datos();
	}
	
	
	public void importar(conexion db, File rutaArchivo){
		  datos.clear();
	      FileReader fr = null;
	      BufferedReader br = null;
	 
	      try {
	         fr = new FileReader (rutaArchivo);
	         br = new BufferedReader(fr);
	 
	         // Lectura del fichero
	         String json;
	         while((json=br.readLine())!=null){
	        	 datos = gson.fromJson(json, Datos.class);
	         }
	         db.sincronizaDatos(datos);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	public void exportar(conexion db){
		datos.clear();
		db.listarMedicos(datos.medicos);
		db.listarPacientes(datos.pacientes);
		db.listarUsuarios(datos.usuarios);
		db.listarTodosLosEstudios(datos.estudios);
		
		json = gson.toJson(datos);

		
		Calendar fechaActual = new GregorianCalendar();
		
		String fecha = ""+fechaActual.get(Calendar.YEAR)+"-"+(fechaActual.get(Calendar.MONTH)+1)+"-"+fechaActual.get(Calendar.DAY_OF_MONTH);
		
		File archivo = new File("datos citologias-"+fecha+".dat");
		
		
		try {
			FileWriter w = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);	
			wr.write(json);
			wr.close();
			bw.close();
			
			JOptionPane.showMessageDialog(null, "Se exportaron todos los datos hasta "+fecha);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Se encontro un problema: "+e.getMessage());
		}
		
		/*
		System.out.println(" "+json);
		
		Datos datos2 = gson.fromJson(json, Datos.class);
		
		json = gson.toJson(datos2);
		
		System.out.println(" "+json);*/
		
		
	}
	
	public void analizar(){
		
	}
	
}
