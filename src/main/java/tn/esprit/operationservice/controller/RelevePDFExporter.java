package tn.esprit.operationservice.controller;

import java.awt.Color;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import tn.esprit.operationservice.model.Operation;
import tn.esprit.operationservice.model.RemiseCheque;
import tn.esprit.operationservice.model.Retrait;
import tn.esprit.operationservice.model.Versement;
import tn.esprit.operationservice.model.Virement;

public class RelevePDFExporter {
	private List<Operation> operations;
	private int month ;
	private long compte ;

	public RelevePDFExporter(ArrayList<Operation> operations, int month, long compte) {
	 this.operations = operations;
	 this.month = month;
	 this.compte=compte;
}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Numéro Operation", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Date Opération", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Date valeur", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Type Opération ", font));
		table.addCell(cell);

		
		cell.setPhrase(new Phrase("Montant", font));
		table.addCell(cell);

		
	}

	private void writeTableData(PdfPTable table) {
		for (Operation operation : operations) {
		if ((operation.getDate_operation().getMonth()+1)== month &&  (operation.getCompte().getNumeroCompte()==compte) ) {
		table.addCell(String.valueOf(operation.getId_operation()));
		
		table.addCell(String.valueOf(operation.getDate_operation()));
		table.addCell(String.valueOf(operation.getDate_valeur()));
		if( operation instanceof Versement) {
			table.addCell("Versement");
			table.addCell(String.valueOf(((Versement)operation).getMontant()));

		}
		if( operation instanceof Virement) {
			table.addCell("Virement");
			table.addCell(String.valueOf(((Virement)operation).getMontant()));

		}
		if( operation instanceof Retrait) {
			table.addCell("Retrait");
			table.addCell(String.valueOf(((Retrait)operation).getMontant()));


		}
		if( operation instanceof RemiseCheque) {
			table.addCell("RemiseCheque");
			table.addCell(String.valueOf(((RemiseCheque)operation).getMontant()));


		}
	}
 }
}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Relevé de moin de "+ new DateFormatSymbols().getMonths()[month-1], font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
//		String soldedebutdemoin = calculatesoldedebutmoin();
//		String soldefindemoin;
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}

	private String calculatesoldedebutmoin() {
		
	
		BigDecimal solde =null;
		for (Operation operation : operations) {
			if (operation.getDate_operation().getMonth()== month) {
				if( operations instanceof Versement) {
					
                solde.add(new BigDecimal(((Versement) operation).getMontant()));
			}
				
			}
		
	}
		return String.valueOf(solde);
	}
	private String calculatesoldefinmoin() {
		
		
		BigDecimal solde =null;
		for (Operation operation : operations) {
			if (operation.getDate_operation().getMonth()== month) {
				if( operations instanceof Versement) {
					
                solde.add(new BigDecimal(((Versement) operation).getMontant()));
			}
				
			}
		
	}
		return String.valueOf(solde);
	}
}