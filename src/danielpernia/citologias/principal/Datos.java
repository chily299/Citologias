package danielpernia.citologias.principal;

import java.util.Vector;

public class Datos {
	
	public Vector<medico> medicos;
	public Vector<paciente> pacientes;
	public Vector<estudio_citologico> estudios;
	public Vector<usuario> usuarios;
	
	public Datos() {
		// TODO Auto-generated constructor stub
		medicos = new Vector<>(1);
		pacientes = new Vector<>(1);
		estudios = new Vector<>(1);
		usuarios = new Vector<>(1);
	}
	
	void clear(){
		medicos.clear();
		pacientes.clear();
		estudios.clear();
		usuarios.clear();
	}

}
