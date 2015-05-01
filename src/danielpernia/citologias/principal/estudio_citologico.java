package danielpernia.citologias.principal;

public class estudio_citologico {
	
	public int rowid,rowid_paciente; public String motivo_consulta;public String diagnostico; 
	public int embarazos;public int cesareas;public int partos;public int abortos;public String f_ultimo_embarazo;
	public int FUR; public String f_FUR;public int citologia; public String f_citologia; public int biopsia; public String f_biopsia;
	public String muestra_de;public String sitio_lesion; public int id_medico;
	public int irradiacion; public String f_irradiacion; public int quimio; public String f_quimio;
	public String quirurgico;public String hormonas; public int diu,anticonceptivo; public String d_anticonceptivo;
	public String resultado, cedula_paciente; public int info_muestra1;public int info_muestra2;public int info_muestra3;
	public int clasificacion1;public int clasificacion2;public int clasificacion3;public int clasificacion4;public String clasificacion_detalle;
	public int numero_impresiones;public String fecha_muestra;public String fecha_resultado; public String estado;
	
	public estudio_citologico() {
		// TODO Auto-generated constructor stub
		fecha_muestra = "2015-01-01";
		cedula_paciente = "";
	}
	
	

}
