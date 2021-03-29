package tn.esprit.pi.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.repository.OrderLineRepository;

public class PDFExporter {
	@Autowired
	OrderLineRepository OrderLineRepo;

	private List<OrderLine> orders;
	public PDFExporter(List<OrderLine> orders) {
		super();
		this.orders = orders;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(4);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("product name", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Quantity", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Total Price", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		
		for (OrderLine o : orders) {
			table.addCell(o.getProduct().getName());
			System.out.println(o.getProduct().getName());
			table.addCell(String.valueOf(o.getProduct().getPriceV()));
			table.addCell(String.valueOf(o.getQuantity()));
			table.addCell(String.valueOf(o.getPrice()));

		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Facture", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 4f, 1.5f, 1.5f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}

}
