package danielpernia.citologias.principal;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class manejador_PDF {
	
	//conexion db = new conexion();
	
	public manejador_PDF() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int imprimirListaDeEstudios(Vector<estudio_citologico> estudio_v,conexion db ){
		Document documento = new Document(PageSize.LETTER, 50, 50, 0, 50);
		
		/*Font font_titulo = FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.BOLD,                   // estilo
				BaseColor.BLACK);*/
		
		Font font_sub_titulo= FontFactory.getFont("arial",   // fuente
				14,                            // tamaño
				Font.BOLD,                   // estilo
				BaseColor.BLACK);
		
		Font font_info = FontFactory.getFont("arial",   // fuente
				12,                            // tamaño
				Font.NORMAL,                   // estilo
				BaseColor.BLACK);
		
		Font font_info_pequena = FontFactory.getFont("arial",   // fuente
				10,                            // tamaño
				Font.NORMAL,                   // estilo
				BaseColor.BLACK);
		
		try {
			
			Image foto = Image.getInstance("cabecera.png");
			foto.scaleToFit(400, 100);
			foto.setAlignment(Chunk.ALIGN_CENTER);
			
			Image pie = Image.getInstance("pie.png");
			pie.scaleToFit(500, 100);
			pie.setAlignment(Chunk.ALIGN_CENTER);
			
			FileOutputStream ficheroPdf = new FileOutputStream("estudio_citologico_multiple"+estudio_v.size()+".pdf");
			
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			//-----------------------------------------------------------------------------------------
			
			documento.addTitle("Titulo documento");
			documento.addAuthor("Autor");
			documento.addSubject("Asunto");
			documento.addCreationDate();
			
			for (estudio_citologico estudio : estudio_v) {
				
				pasiente  pasiente_= new pasiente();
				pasiente_.cedula = estudio.cedula_pasiente;
				//System.out.println("--------------cedula: "+estudio.cedula_pasiente);
				medico medico_ = new medico();
				medico_.id_medico = estudio.id_medico;
				db.buscarPasientePorCedula(pasiente_);
				db.buscarMedicoPorId(medico_);
			
			//documento.add(new pa)
			String fecha;
			String sub_titulo_pasiente, info_pasiente;
			String sub_titulo_tratamiento, info_tratamento;
			String sub_titulo_informacion_g, info_informacion_g;
			String sub_titulo_resultado, info_resultado;
			String sub_titulo_categoria, info_categoria;
		//	String pie_de_pagina;
			
			fecha = "fecha: "+estudio.fecha_resultado;
			sub_titulo_pasiente ="PACIENTE:";
			info_pasiente ="Cedula: "+pasiente_.cedula+"         Nombre: "+pasiente_.nombres+" "+pasiente_.Apellidos+"\n"
							+ "Edad:"+pasiente_.f_nacimiento+"        Telefono: "+pasiente_.telefono+"        Procedencia: "+pasiente_.procedencia+"\n"
							+ "Direccion: "+pasiente_.direccion+"\n"
							+ "Fecha de la muestra: "+estudio.fecha_muestra+"\n"
							+ "Motivo consulta: "+estudio.motivo_consulta+"         Diagnostico clinico: "+estudio.diagnostico;
			sub_titulo_tratamiento ="TRATAMIENTO PREVIO:";
			info_tratamento ="";
			int contTrantamientoPrevio=0;
			if(estudio.irradiacion==1){
				contTrantamientoPrevio++;
				info_tratamento+="IRRADIACION: "+estudio.f_irradiacion+" \t";
				
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
			}else{
				//info_tratamento+="No";	
			}
			
			
			if(estudio.quimio==1){
				contTrantamientoPrevio++;
				info_tratamento+="QUIMIOTERAPIA: "+estudio.f_quimio+" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.hormonas!=null&&!estudio.hormonas.isEmpty()){
				contTrantamientoPrevio++;
				info_tratamento+="HORMONAS: "+estudio.hormonas+" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.quirurgico!=null&&!estudio.quirurgico.isEmpty()){
				contTrantamientoPrevio++;
				info_tratamento+="QUIRURGICO: "+estudio.quirurgico +" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.diu==1){
				contTrantamientoPrevio++;
				info_tratamento+="D.I.U.: "+"Si"+"\t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.anticonceptivo==1){
				contTrantamientoPrevio++;
				info_tratamento+="ANTICONCEPTIVOS ORALES: "+estudio.d_anticonceptivo+" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			sub_titulo_informacion_g ="INFORMACION GINECOLOGICA:";
			info_informacion_g ="Medico Solicitante: "+medico_.nombres+" "+medico_.Apellidos+"\n"
					+ "Embarazos: "+estudio.embarazos+" "+"   Partos: "+estudio.partos+"   Cesareas: "+estudio.cesareas+"   Abortos: "+estudio.abortos+"\n"
					+ "Fecha ultimo: "+estudio.f_ultimo_embarazo+"";
			
			if(estudio.FUR==1){
				info_informacion_g+="  FUR: "+estudio.f_FUR+"\n";
			}else{
				info_informacion_g+="  FUR: No\n";
			}
			
			if(estudio.citologia == 1){
				info_informacion_g+= "Citologia anterior: "+estudio.f_citologia +"\n";
			}
			if(estudio.biopsia == 1){
				info_informacion_g+= "Biopsia anterior: "+estudio.f_biopsia +"\n";
			}
			
			info_informacion_g+= "Muestra de: "+estudio.muestra_de+"      Sitio de lesion: "+estudio.sitio_lesion;
			
			sub_titulo_resultado="RESULTADO:";
			if(estudio.info_muestra1 == 1){
				
			}
			info_resultado=""+estudio.resultado;
			sub_titulo_categoria="CATEGORIZACION GENERAL:";
			info_categoria="";
			
			if(estudio.info_muestra1 == 0){ // satisfactoria
				if(estudio.clasificacion1 == 0){
					info_categoria+="NEGATIVO PARA LESIÓN INTRAEPITELIAL O MALIGNIDAD ";
					if(estudio.clasificacion2 == 0){
						info_categoria+="MICROORGANISMOS ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="Trichomonas vaginalis ";
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="Elementos micóticos de características morfológicas compatibles con Candida ";
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA ";
						}else if(estudio.clasificacion3 == 3){
							info_categoria+="Bacterias de características morfológicas compatibles con Actinomyces ";
						}else if(estudio.clasificacion3 == 4){
							info_categoria+="Cambios celulares compatibles con HERPES SIMPLE ";
						}
					}else if(estudio.clasificacion2 == 1){
						info_categoria+="OTROS HALLAZGOS NO NEOPLÁSICOS ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="Cambios celulares reactivos asosiados a: ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Inflamación ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Radiación ";
							}else if(estudio.clasificacion4 == 2){
								info_categoria+="Dispositivo intrauterino (DIU) ";
							}
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="Células glandulares poshisterectomía ";
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="Atrofia ";
						}
					}
				}else if(estudio.clasificacion1 == 1){
					info_categoria+="OTROS HALLAZGOS ";
					 if(estudio.clasificacion2 == 0){
							info_categoria+="CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años)  ";
							if(estudio.clasificacion3 == 0){
								info_categoria+="NEGATIVO PARA LESIÓN ESCAMOSA INTRAEPITELIAL ";
						 }
					 }
				}else if(estudio.clasificacion1 == 2){
					info_categoria+="ANOMALÍAS DE LAS CÉLULAS EPITELIALES ";
					
				}else if(estudio.clasificacion1 == 3){
					info_categoria+="OTRAS NEOPLASIAS MALIGNAS  ";
					if(estudio.clasificacion2 == 0){
						info_categoria+="CÉLULAS ESCAMOSAS ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="CÉLULAS ESCAMOSAS ATÍPICAS ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="de significado indeterminado (ASC-US) ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="no se puede descartar lesion escamosa intraepitelial de alto grado (ASC-H) ";
							}
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="LESIÓN ESCAMOSA INTRAEPITELIAL DE BAJO GRADO (LSIL)  ";
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="LESIÓN ESCAMOSA INTRAEPITELIAL DE ALTO GRADO (HSIL) ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="con hallazgos sospechosos de invación ";
							}
						}else if(estudio.clasificacion3 == 3){
							info_categoria+="CARCINOMA ESCAMOSO ";
						} 
				 }
					if(estudio.clasificacion2 == 1){
						info_categoria+="CÉLULAS GLANDULARES ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="ATÍPICAS ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Células endocervicales ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Células endometriales ";
							}else if(estudio.clasificacion4 == 2){
								info_categoria+="Células glandulares ";
							}
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="ATÍPICAS SUGESTIVAS A NEOPLASIA ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Células endocervicales ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Células glandulares ";
							}
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="ADENOCARCINOMA ENDOCERVICAL (in situ) ";
						}else if(estudio.clasificacion3 == 3){
							info_categoria+="ADENOCARCINOMA ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Endocervical ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Endometrial ";
							}else if(estudio.clasificacion4 == 2){
								info_categoria+="Extrauterino ";
							}else if(estudio.clasificacion4 == 3){
								info_categoria+="Sin Especificar ";
							}
						} 
				 }
				}
			}else{
				sub_titulo_categoria="CALIDAD DE LA MUESTRA:";
				
				info_categoria+= "Insatisfactoria para evaluación ";
				if(estudio.info_muestra2 == 0){
					info_categoria+= "Muestra rechazada y no procesada ";
					if(estudio.info_muestra3 == 0){
						info_categoria+= "por falta de datos para el procesamiento ";
					}else if(estudio.info_muestra3 == 1){
						info_categoria+= "lamina invalidada por defecto fisico ";
					}	
				}else if(estudio.info_muestra2 == 1){
					info_categoria+= "Muestra procesada y examinada pero insatisfactoria para la evaluación de anomalía epiteliales  ";
					if(estudio.info_muestra3 == 0){
						info_categoria+= "muy sanguinolenta ";
					}else if(estudio.info_muestra3 == 1){
						info_categoria+= "muy inflamatoria ";
					}else if(estudio.info_muestra3 == 2){
						info_categoria+= "escaso material celular ";
					}
				}
			}
			
			//pie_de_pagina="pie_de_pagina";
			
			
			
			Rectangle r = new Rectangle(100, 550, 16, 10);
			r.setBorderWidth(10);
			r.setBorderColor(BaseColor.RED);
			
			Paragraph p_fecha = new Paragraph(fecha,font_info);
			p_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
			
			Paragraph p_sub_titulo_pasiente = new Paragraph(sub_titulo_pasiente,font_sub_titulo);
			p_sub_titulo_pasiente.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_pasiente = new Paragraph(info_pasiente,font_info_pequena);
			p_info_pasiente.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_tratamiento = new Paragraph(sub_titulo_tratamiento,font_sub_titulo);
			p_sub_titulo_tratamiento.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_tratamento = new Paragraph(info_tratamento,font_info_pequena);
			p_info_tratamento.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_informacion_g = new Paragraph(sub_titulo_informacion_g,font_sub_titulo);
			p_sub_titulo_informacion_g.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_informacion_g = new Paragraph(info_informacion_g,font_info_pequena);
			p_info_informacion_g.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_resultado = new Paragraph(sub_titulo_resultado,font_sub_titulo);
			p_sub_titulo_resultado.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_resultado = new Paragraph(info_resultado,font_info);
			p_info_resultado.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_categoria = new Paragraph(sub_titulo_categoria,font_sub_titulo);
			p_sub_titulo_categoria.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_categoria = new Paragraph(info_categoria,font_info);
			p_info_categoria.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			
			
			//documento.add(p_cabecera);
			//documento.add(r);
			documento.add(foto);
			//documento.add(new Paragraph(info_cabecera));
			documento.add(new Paragraph(p_fecha));
			documento.add(new Paragraph(p_sub_titulo_pasiente));
			documento.add(new Paragraph(p_info_pasiente));
			documento.add(new Paragraph(p_sub_titulo_tratamiento));
			documento.add(new Paragraph(p_info_tratamento));
			documento.add(new Paragraph(p_sub_titulo_informacion_g));
			documento.add(new Paragraph(p_info_informacion_g));
			documento.add(new Paragraph(p_sub_titulo_resultado));
			documento.add(new Paragraph(p_info_resultado));
			documento.add(new Paragraph(p_sub_titulo_categoria));
			documento.add(new Paragraph(p_info_categoria));
			documento.add(new Paragraph("\n"));
			documento.add(pie);
			
			//documento.add(new Paragraph("Esto es el primer párrafo, normalito"));
			/*documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
							FontFactory.getFont("arial",   // fuente
							22,                            // tamaño
							Font.ITALIC,                   // estilo
							BaseColor.CYAN)));       
			*/
			documento.newPage();
			//----------------------------------------------------------------------------------------
			}
			documento.close();
			ficheroPdf.close();
			
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (estudio_citologico estudio : estudio_v) {
			db.actualizarImpresionesDeEstudio(estudio);
		}
		
		JOptionPane.showMessageDialog(null, "Se imprimio "+estudio_v.size()+" estudios con exito");
		return 0;
	}
	
	
	
	public int imprimirEstudioSeleccionado( estudio_citologico estudio, pasiente pasiente_,medico medico_, conexion db){
		
		Document documento = new Document(PageSize.LETTER, 50, 50, 0, 50);
		
		/*Font font_titulo = FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.BOLD,                   // estilo
				BaseColor.BLACK);*/
		
		Font font_sub_titulo= FontFactory.getFont("arial",   // fuente
				14,                            // tamaño
				Font.BOLD,                   // estilo
				BaseColor.BLACK);
		
		Font font_info = FontFactory.getFont("arial",   // fuente
				12,                            // tamaño
				Font.NORMAL,                   // estilo
				BaseColor.BLACK);
		
		Font font_info_pequena =  FontFactory.getFont("arial",   // fuente
				10,                            // tamaño
				Font.NORMAL,                   // estilo
				BaseColor.BLACK); 
		
		
		try {
			
			Image foto = Image.getInstance("cabecera.png");
			foto.scaleToFit(400, 100);
			foto.setAlignment(Chunk.ALIGN_CENTER);
			
			Image pie = Image.getInstance("pie.png");
			pie.scaleToFit(500, 100);
			pie.setAlignment(Chunk.ALIGN_CENTER);
			
			FileOutputStream ficheroPdf = new FileOutputStream("estudio_citologico_"+estudio.cedula_pasiente+".pdf");
			
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			//-----------------------------------------------------------------------------------------
			
			documento.addTitle("Estudio Citologico");
			documento.addAuthor("Lisbeth Jaimes");
			documento.addSubject("Resultado de laboratorio");
			documento.addCreationDate();
			
			//documento.add(new pa)
			String fecha;
			String sub_titulo_pasiente, info_pasiente;
			String sub_titulo_tratamiento, info_tratamento;
			String sub_titulo_informacion_g, info_informacion_g;
			String sub_titulo_resultado, info_resultado;
			String sub_titulo_categoria, info_categoria;
			//String pie_de_pagina;
			
			String fecha_resultado[] = estudio.fecha_resultado.split(" ");
			
			fecha = "N°"+estudio.rowid+"         Fecha: "+fecha_resultado[0];
			sub_titulo_pasiente ="PACIENTE:";
			info_pasiente =      "Cedula: "+pasiente_.cedula+"         Nombre: "+pasiente_.nombres+" "+pasiente_.Apellidos+"\n"
							+ "Edad:"+pasiente_.f_nacimiento+"         Telefono: "+pasiente_.telefono+"        Procedencia: "+pasiente_.procedencia+"\n"
							+ "Direccion: "+pasiente_.direccion+"\n"
							+ "Fecha de la muestra: "+estudio.fecha_muestra+"\n"
							+ "Motivo consulta: "+estudio.motivo_consulta+"         Diagnostico clinico: "+estudio.diagnostico;
			sub_titulo_tratamiento ="TRATAMIENTO PREVIO:";
			info_tratamento ="";
			int contTrantamientoPrevio=0;
			if(estudio.irradiacion==1){
				contTrantamientoPrevio++;
				info_tratamento+="IRRADIACION: "+estudio.f_irradiacion+" \t";
				
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
			}else{
				//info_tratamento+="No";	
			}
			
			
			if(estudio.quimio==1){
				contTrantamientoPrevio++;
				info_tratamento+="QUIMIOTERAPIA: "+estudio.f_quimio+" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.hormonas!=null&&!estudio.hormonas.isEmpty()){
				contTrantamientoPrevio++;
				info_tratamento+="HORMONAS: "+estudio.hormonas+" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.quirurgico!=null&&!estudio.quirurgico.isEmpty()){
				contTrantamientoPrevio++;
				info_tratamento+="QUIRURGICO: "+estudio.quirurgico +" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.diu==1){
				contTrantamientoPrevio++;
				info_tratamento+="D.I.U.: "+"Si"+"\t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			if(estudio.anticonceptivo==1){
				contTrantamientoPrevio++;
				info_tratamento+="ANTICONCEPTIVOS ORALES: "+estudio.d_anticonceptivo+" \t";
				if(contTrantamientoPrevio%1==0){
					info_tratamento+="\n";
				}
				
			}else{
				//info_tratamento+="No";	
			}
			
			sub_titulo_informacion_g ="INFORMACION GINECOLOGICA:";
			info_informacion_g ="Medico Solicitante: "+medico_.nombres+" "+medico_.Apellidos+"\n"
					+ "Embarazos: "+estudio.embarazos+" "+"   Partos: "+estudio.partos+"   Cesareas: "+estudio.cesareas+"   Abortos: "+estudio.abortos+"\n"
					+ "Fecha ultimo: "+estudio.f_ultimo_embarazo+"";
			
			if(estudio.FUR==1){
				info_informacion_g+="  FUR: "+estudio.f_FUR+"\n";
			}else{
				info_informacion_g+="  FUR: No\n";
			}
			
			if(estudio.citologia == 1){
				info_informacion_g+= "Citologia anterior: "+estudio.f_citologia +"\n";
			}
			if(estudio.biopsia == 1){
				info_informacion_g+= "Biopsia anterior: "+estudio.f_biopsia +"\n";
			}
			
			info_informacion_g+= "Muestra de: "+estudio.muestra_de+"      Sitio de lesion: "+estudio.sitio_lesion;
			
			sub_titulo_resultado="RESULTADO:";
			if(estudio.info_muestra1 == 1){
				
			}
			info_resultado=""+estudio.resultado;
			sub_titulo_categoria="CATEGORIZACION GENERAL:";
			info_categoria="";
			
			if(estudio.info_muestra1 == 0){ // satisfactoria
				if(estudio.clasificacion1 == 0){
					info_categoria+="NEGATIVO PARA LESIÓN INTRAEPITELIAL O MALIGNIDAD ";
					if(estudio.clasificacion2 == 0){
						info_categoria+="MICROORGANISMOS ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="Trichomonas vaginalis ";
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="Elementos micóticos de características morfológicas compatibles con Candida ";
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA ";
						}else if(estudio.clasificacion3 == 3){
							info_categoria+="Bacterias de características morfológicas compatibles con Actinomyces ";
						}else if(estudio.clasificacion3 == 4){
							info_categoria+="Cambios celulares compatibles con HERPES SIMPLE ";
						}
					}else if(estudio.clasificacion2 == 1){
						info_categoria+="OTROS HALLAZGOS NO NEOPLÁSICOS ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="Cambios celulares reactivos asosiados a: ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Inflamación ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Radiación ";
							}else if(estudio.clasificacion4 == 2){
								info_categoria+="Dispositivo intrauterino (DIU) ";
							}
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="Células glandulares poshisterectomía ";
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="Atrofia ";
						}
					}
				}else if(estudio.clasificacion1 == 1){
					info_categoria+="OTROS HALLAZGOS ";
					 if(estudio.clasificacion2 == 0){
							info_categoria+="CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años)  ";
							if(estudio.clasificacion3 == 0){
								info_categoria+="NEGATIVO PARA LESIÓN ESCAMOSA INTRAEPITELIAL ";
						 }
					 }
				}else if(estudio.clasificacion1 == 2){
					info_categoria+="ANOMALÍAS DE LAS CÉLULAS EPITELIALES ";
					
				}else if(estudio.clasificacion1 == 3){
					info_categoria+="OTRAS NEOPLASIAS MALIGNAS  ";
					if(estudio.clasificacion2 == 0){
						info_categoria+="CÉLULAS ESCAMOSAS ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="CÉLULAS ESCAMOSAS ATÍPICAS ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="de significado indeterminado (ASC-US) ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="no se puede descartar lesion escamosa intraepitelial de alto grado (ASC-H) ";
							}
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="LESIÓN ESCAMOSA INTRAEPITELIAL DE BAJO GRADO (LSIL) ";
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="LESIÓN ESCAMOSA INTRAEPITELIAL DE ALTO GRADO (HSIL) ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="con hallazgos sospechosos de invación ";
							}
						}else if(estudio.clasificacion3 == 3){
							info_categoria+="CARCINOMA ESCAMOSO ";
						} 
				 }
					if(estudio.clasificacion2 == 1){
						info_categoria+="CÉLULAS GLANDULARES ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="ATÍPICAS ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Células endocervicales ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Células endometriales ";
							}else if(estudio.clasificacion4 == 2){
								info_categoria+="Células glandulares ";
							}
						}else if(estudio.clasificacion3 == 1){
							info_categoria+="ATÍPICAS SUGESTIVAS A NEOPLASIA ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Células endocervicales ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Células glandulares ";
							}
						}else if(estudio.clasificacion3 == 2){
							info_categoria+="ADENOCARCINOMA ENDOCERVICAL (in situ) ";
						}else if(estudio.clasificacion3 == 3){
							info_categoria+="ADENOCARCINOMA ";
							if(estudio.clasificacion4 == 0){
								info_categoria+="Endocervical ";
							}else if(estudio.clasificacion4 == 1){
								info_categoria+="Endometrial ";
							}else if(estudio.clasificacion4 == 2){
								info_categoria+="Extrauterino ";
							}else if(estudio.clasificacion4 == 3){
								info_categoria+="Sin Especificar ";
							}
						} 
				 }
				}
			}else{
				sub_titulo_categoria="CALIDAD DE LA MUESTRA:";
				
				info_categoria+= "Insatisfactoria para evaluación ";
				if(estudio.info_muestra2 == 0){
					info_categoria+= "Muestra rechazada y no procesada ";
					if(estudio.info_muestra3 == 0){
						info_categoria+= "por falta de datos para el procesamiento ";
					}else if(estudio.info_muestra3 == 1){
						info_categoria+= "lamina invalidada por defecto fisico ";
					}	
				}else if(estudio.info_muestra2 == 1){
					info_categoria+= "Muestra procesada y examinada pero insatisfactoria para la evaluación de anomalía epiteliales  ";
					if(estudio.info_muestra3 == 0){
						info_categoria+= "muy sanguinolenta ";
					}else if(estudio.info_muestra3 == 1){
						info_categoria+= "muy inflamatoria ";
					}else if(estudio.info_muestra3 == 2){
						info_categoria+= "escaso material celular ";
					}
				}
			}
			
			//pie_de_pagina="pie_de_pagina";
			
			
			
			Rectangle r = new Rectangle(100, 550, 16, 10);
			r.setBorderWidth(10);
			r.setBorderColor(BaseColor.RED);
			
			Paragraph p_fecha = new Paragraph(fecha,font_info);
			p_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
			
			Paragraph p_sub_titulo_pasiente = new Paragraph(sub_titulo_pasiente,font_sub_titulo);
			p_sub_titulo_pasiente.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_pasiente = new Paragraph(info_pasiente,font_info_pequena);
			p_info_pasiente.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_tratamiento = new Paragraph(sub_titulo_tratamiento,font_sub_titulo);
			p_sub_titulo_tratamiento.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_tratamento = new Paragraph(info_tratamento,font_info_pequena);
			p_info_tratamento.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_informacion_g = new Paragraph(sub_titulo_informacion_g,font_sub_titulo);
			p_sub_titulo_informacion_g.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_informacion_g = new Paragraph(info_informacion_g,font_info_pequena);
			p_info_informacion_g.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_resultado = new Paragraph(sub_titulo_resultado,font_sub_titulo);
			p_sub_titulo_resultado.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_resultado = new Paragraph(info_resultado,font_info);
			p_info_resultado.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			Paragraph p_sub_titulo_categoria = new Paragraph(sub_titulo_categoria,font_sub_titulo);
			p_sub_titulo_categoria.setAlignment(Paragraph.ALIGN_LEFT);
			
			Paragraph p_info_categoria = new Paragraph(info_categoria,font_info);
			p_info_categoria.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			
			
			//documento.add(p_cabecera);
			//documento.add(r);
			documento.add(foto);
			//documento.add(new Paragraph(info_cabecera));
			documento.add(new Paragraph(p_fecha));
			documento.add(new Paragraph(p_sub_titulo_pasiente));
			documento.add(new Paragraph(p_info_pasiente));
			documento.add(new Paragraph(p_sub_titulo_tratamiento));
			documento.add(new Paragraph(p_info_tratamento));
			documento.add(new Paragraph(p_sub_titulo_informacion_g));
			documento.add(new Paragraph(p_info_informacion_g));
			documento.add(new Paragraph(p_sub_titulo_resultado));
			documento.add(new Paragraph(p_info_resultado));
			documento.add(new Paragraph(p_sub_titulo_categoria));
			documento.add(new Paragraph(p_info_categoria));
			documento.add(new Paragraph("\n"));
			documento.add(pie);
			
			//documento.add(new Paragraph("Esto es el primer párrafo, normalito"));
			/*documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
							FontFactory.getFont("arial",   // fuente
							22,                            // tamaño
							Font.ITALIC,                   // estilo
							BaseColor.CYAN)));       
			*/
			//----------------------------------------------------------------------------------------
			documento.close();
			ficheroPdf.close();
			
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.actualizarImpresionesDeEstudio(estudio);
		
		
		JOptionPane.showMessageDialog(null, "Se imprimio estudio "+estudio.rowid);
		
		return 0;
	}

}
