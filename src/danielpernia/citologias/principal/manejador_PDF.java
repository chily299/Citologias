package danielpernia.citologias.principal;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class manejador_PDF {
	Image pie,cabeza;
	Font font_sub_titulo,font_info,font_info_pequena;
	//conexion db = new conexion();
	
	public manejador_PDF() {

		try {
			cabeza = Image.getInstance("Assets\\cabecera.png");
			cabeza.scaleToFit(400, 100);
			cabeza.setAlignment(Chunk.ALIGN_CENTER);
			
			pie = Image.getInstance("Assets\\pie.png");
			pie.scaleToFit(500, 100);
			pie.setAlignment(Chunk.ALIGN_CENTER);
			
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Font font_titulo = FontFactory.getFont("arial",   // fuente
		22,                            // tamaño
		Font.BOLD,                   // estilo
		BaseColor.BLACK);*/

		 font_sub_titulo= FontFactory.getFont("arial",   // fuente
		14,                            // tamaño
		Font.BOLD,                   // estilo
		BaseColor.BLACK);

		 font_info = FontFactory.getFont("arial",   // fuente
		12,                            // tamaño
		Font.NORMAL,                   // estilo
		BaseColor.BLACK);

		 font_info_pequena =  FontFactory.getFont("arial",   // fuente
		10,                            // tamaño
		Font.NORMAL,                   // estilo
		BaseColor.BLACK); 
		
		
	}
	
	
	public int imprimirListaDeEstudios(Vector<estudio_citologico> estudio_v,conexion db ){
		Document documento = new Document(PageSize.LETTER, 50, 50, 0, 50);
		
		
		
		try {
			
			
			
			String date[] =estudio_v.elementAt(estudio_v.size()-1).fecha_resultado.split(" ");
			String fechar = date[0];
			
			FileOutputStream ficheroPdf = new FileOutputStream("pdf\\EC-multiple-"+fechar+"-"+estudio_v.size()+".pdf");
			
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			//-----------------------------------------------------------------------------------------
			
			documento.addTitle("Estudio Citologico");
			documento.addAuthor("Lisbeth Jaimes ");
			documento.addSubject("Resultado de laboratorio");
			documento.addCreationDate();
			
			for (estudio_citologico estudio : estudio_v) {
				
				paciente  paciente_= new paciente();
				paciente_.cedula = estudio.cedula_paciente;
				
				medico medico_ = new medico();
				medico_.id_medico = estudio.id_medico;
				
				db.buscarPasientePorCedula(paciente_);
				db.buscarMedicoPorId(medico_);
			
				crearPaginaPDF(documento, estudio, paciente_, medico_);
			
				documento.newPage();
			}
			documento.close();
			ficheroPdf.close();
			
		} catch (DocumentException | IOException e) {
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
		}
		
		for (estudio_citologico estudio : estudio_v) {
			db.actualizarImpresionesDeEstudio(estudio);
		}
		
		JOptionPane.showMessageDialog(null, "Se imprimio "+estudio_v.size()+" estudios con exito");
		return 0;
	}
	
	
	
	public int imprimirEstudioSeleccionado( estudio_citologico estudio, conexion db){
		
		Document documento = new Document(PageSize.LETTER, 50, 50, 0, 50);
		
		try {
			
			String date[] = estudio.fecha_resultado.split(" ");
			String fechar = date[0];
			
			FileOutputStream ficheroPdf = new FileOutputStream("pdf\\EC-"+fechar+"-"+estudio.cedula_paciente+".pdf");
			
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			//-----------------------------------------------------------------------------------------
			
			documento.addTitle("Estudio Citologico");
			documento.addAuthor("Lisbeth Jaimes ");
			documento.addSubject("Resultado de laboratorio");
			documento.addCreationDate();
			
			paciente  paciente_= new paciente();
			paciente_.cedula = estudio.cedula_paciente;
			
			medico medico_ = new medico();
			medico_.id_medico = estudio.id_medico;
			
			db.buscarPasientePorCedula(paciente_);
			db.buscarMedicoPorId(medico_);
			      
			crearPaginaPDF(documento, estudio, paciente_, medico_);
			//----------------------------------------------------------------------------------------
			documento.close();
			ficheroPdf.close();
			
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
			e.printStackTrace();
		}
		
		db.actualizarImpresionesDeEstudio(estudio);
		
		JOptionPane.showMessageDialog(null, "Se imprimio estudio "+estudio.rowid);
		
		return 0;
	}
	
	public void crearPaginaPDF(Document documento,estudio_citologico estudio,paciente paciente_,medico medico_){
		
		int contarLineas =0;
		
		String fecha;
		String sub_titulo_paciente, info_paciente;
		String sub_titulo_tratamiento, info_tratamento;
		String sub_titulo_informacion_g, info_informacion_g;
		String sub_titulo_resultado, info_resultado;
		String sub_titulo_categoria, info_categoria;
		//String pie_de_pagina;
		
		String fecha_resultado[] = estudio.fecha_resultado.split(" ");
		
		//---------PACIENTE-----------------
		fecha = "N°"+estudio.rowid+"         Fecha: "+fecha_resultado[0];
		sub_titulo_paciente ="PACIENTE:";
		info_paciente =      "Cédula: "+estudio.cedula_paciente+"         Nombre: "+paciente_.nombres+" "+paciente_.Apellidos+"\n"
						+ "Edad:"+paciente_.edad+"         Telefono: "+paciente_.telefono+"        Procedencia: "+paciente_.procedencia+"\n"
						+ "Dirección: "+paciente_.direccion+"\n"
						+ "Fecha de toma de muestra: "+estudio.fecha_muestra+"\n"
						+ "Motivo consulta: "+estudio.motivo_consulta+"\n"
						+ "Diagnostico clínico: "+estudio.diagnostico;
		//-----TRATAMIENTO PREVIO:
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
		
		if(contTrantamientoPrevio ==0){
			info_tratamento+="Sin tratamiento previo\n";
			contarLineas = 1;
		}else{
			contarLineas = contTrantamientoPrevio;
		}
		
		sub_titulo_informacion_g ="INFORMACIÓN GINECOLÓGICA:";
		info_informacion_g ="Medico Solicitante: "+medico_.nombres+" "+medico_.Apellidos+"\n"
				+ "Embarazos: "+estudio.embarazos+" "+"   Partos: "+estudio.partos+"   Cesareas: "+estudio.cesareas+"   Abortos: "+estudio.abortos+"\n";
		if(!estudio.f_ultimo_embarazo.isEmpty())		{
			info_informacion_g+= "Fecha ultimo embarazo: "+estudio.f_ultimo_embarazo+"      ";
			contarLineas++;
		}
		
		if(estudio.FUR==1){
			info_informacion_g+="FUR: "+estudio.f_FUR+"\n";
		}else{
			info_informacion_g+="FUR: No\n";
		}
		
		if(estudio.citologia == 1){
			info_informacion_g+= "Citologia anterior: "+estudio.f_citologia +"\n";
			contarLineas++;
		}
		if(estudio.biopsia == 1){
			info_informacion_g+= "Biopsia anterior: "+estudio.f_biopsia +"\n";
			contarLineas++;
		}
		
		info_informacion_g+= "Muestra de: "+estudio.muestra_de+"      Sitio de lesion: "+estudio.sitio_lesion;
		
		sub_titulo_resultado="RESULTADO:";
		info_resultado="";
		if(estudio.info_muestra1 == 1){
			
		}else{
			info_resultado+=estudio.resultado;
			
			//System.out.println("Total caracteres "+estudio.resultado.toCharArray().length);
			if(estudio.resultado.toCharArray().length/50 < 1){
				contarLineas++;
			}else{
				contarLineas+=estudio.resultado.toCharArray().length/50;
			}
		}
		sub_titulo_categoria="CATEGORIZACIÓN GENERAL:";
		info_categoria="";
		
		if(estudio.info_muestra1 == 0){ // satisfactoria
			if(estudio.clasificacion1 == 0){
				info_categoria+="NEGATIVO PARA LESIÓN INTRAEPITELIAL O MALIGNIDAD\n";
				if(estudio.clasificacion2 == 0){
					info_categoria+="MICROORGANISMOS: ";
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
					info_categoria+="OTROS HALLAZGOS NO NEOPLÁSICOS: ";
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
				info_categoria+="OTROS HALLAZGOS\n";
				 if(estudio.clasificacion2 == 0){
						info_categoria+="CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años)  ";
						if(estudio.clasificacion3 == 0){
							info_categoria+="NEGATIVO PARA LESIÓN ESCAMOSA INTRAEPITELIAL ";
					 }
				 }
			}else if(estudio.clasificacion1 == 2){
				info_categoria+="ANOMALÍAS DE LAS CÉLULAS EPITELIALES\n";
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
			}else if(estudio.clasificacion1 == 3){
				info_categoria+="OTRAS NEOPLASIAS MALIGNAS\n";
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
		
		if(estudio.clasificacion_detalle!=null && !estudio.clasificacion_detalle.isEmpty()){
			info_categoria+="\nObservación: "+estudio.clasificacion_detalle;
		}
		for(int i = contarLineas; i < 15; i++){
			info_categoria+="\n";
		}
		//System.out.println("Total lineas: "+contarLineas);

		Paragraph p_fecha = new Paragraph(fecha,font_info);
		p_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
		
		Paragraph p_sub_titulo_paciente = new Paragraph(sub_titulo_paciente,font_sub_titulo);
		p_sub_titulo_paciente.setAlignment(Paragraph.ALIGN_LEFT);
		
		Paragraph p_info_paciente = new Paragraph(info_paciente,font_info_pequena);
		p_info_paciente.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
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
		
		try {
			
			documento.add(cabeza);
			documento.add(new Paragraph(p_fecha));
			documento.add(new Paragraph(p_sub_titulo_paciente));
			documento.add(new Paragraph(p_info_paciente));
			documento.add(new Paragraph(p_sub_titulo_tratamiento));
			documento.add(new Paragraph(p_info_tratamento));
			documento.add(new Paragraph(p_sub_titulo_informacion_g));
			documento.add(new Paragraph(p_info_informacion_g));
			documento.add(new Paragraph(p_sub_titulo_resultado));
			documento.add(new Paragraph(p_info_resultado));
			documento.add(new Paragraph(p_sub_titulo_categoria));
			documento.add(new Paragraph(p_info_categoria));
			documento.add(new Paragraph("\n"));
			//System.out.println("botton "+documento.bottom());
			//System.out.println("top "+documento.top());
			//System.out.println("page number "+documento.getPageNumber());
			//System.out.println("toString: "+documento.toString());
			
			documento.add(pie);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
