package danielpernia.citologias.principal;

import java.util.Vector;

public class sincronizaDatos {

	
	public sincronizaDatos() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void importar(){
		
	}
	
	public void exportar(conexion db){
		Vector<medico> listaMedicos =new Vector<medico>(1);
		db.listarMedicos(listaMedicos);
		
		
	}
	
	public void analizar(){
		
	}
}
