package danielpernia.citologias.principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class manejador_PDF {
	
	public manejador_PDF() {
		// TODO Auto-generated constructor stub
	}
	
	public int imprimirEstudioSeleccionado( estudio_citologico estudio){
		
		Document documento = new Document(PageSize.A4, 50, 50, 100, 72);
		      // color
		
		try {
			

			
			
			FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");
			
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			//-----------------------------------------------------------------------------------------
			
			
			documento.add(new Paragraph("Esto es el primer párrafo, normalito"));
			documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
							FontFactory.getFont("arial",   // fuente
							22,                            // tamaño
							Font.ITALIC,                   // estilo
							BaseColor.CYAN)));       
			
			//----------------------------------------------------------------------------------------
			documento.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
