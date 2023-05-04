package com;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;

//@org.springframework.stereotype.Service

@Service
public class PdfServiceAuthForm {

	public void createPdf(PdfCreater pdfCreater,HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font20 = FontFactory.getFont("Verdana", 11, Color.RED);

		Font font12Red = FontFactory.getFont("Verdana", 9, Color.RED);
		Font font12 = FontFactory.getFont("Verdana", 9, Color.BLACK);
		Font fontBold = FontFactory.getFont("Verdana", 15, Font.BOLD,Color.BLACK);
		
		Paragraph newLine = new Paragraph("\n");
		
		Image image1 = Image.getInstance("https://resource.fintainium.com/images/footer-logo-fintainium.jpg");
		image1.setAlignment(Element.ALIGN_CENTER);
		document.add(image1);
		
//		document.add(newLine);
		document.add(newLine);
		
		
		Paragraph paragraph1 = new Paragraph(pdfCreater.getFintainiumClientName(), font20);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph1);
        System.out.println(paragraph1);
        
        Paragraph paragraph2 = new Paragraph(pdfCreater.getStreetAddress(), font12Red);
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph2);
        System.out.println(paragraph2);
        
        Paragraph paragraph3 = new Paragraph(pdfCreater.getCityStateZip(), font12Red);
        paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph3);
        
        Paragraph paragraph4 = new Paragraph(pdfCreater.getPhoneNumber(), font12Red);
        paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph4);
        
        Paragraph paragraph5 = new Paragraph("Recurring Payment Authorization Form", fontBold);
        paragraph5.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph5.setSpacingBefore(4);
        paragraph5.setSpacingAfter(7);
//        document.add(Chunk.NEWLINE);
        document.add(paragraph5);
        
        Paragraph paragraph6 = new Paragraph("Schedule your payment to be automatically"
        		+ " deducted from your bank account, or charged to your Visa, MasterCard,"
        		+ " American Express or Discover Card.", font12);
//        document.add(Chunk.NEWLINE);

        paragraph6.setSpacingAfter(10);
        document.add(paragraph6);
        document.add(Chunk.NEWLINE);
        
        
        document.add(new LineSeparator()); 
        document.add(Chunk.NEWLINE);
        
        Paragraph paragraph7_1 = new Paragraph("I ", font12);
        Paragraph paragraph7_2 = new Paragraph(pdfCreater.getArCustomerName(), font12Red);
        Paragraph paragraph7_3 = new Paragraph(" authorize ", font12);
        Paragraph paragraph7_4 = new Paragraph(pdfCreater.getInsertFintainiumClientName(), font12Red);
        Paragraph paragraph7_5 = new Paragraph(" (“Merchant”) to charge my credit card or Bank Account indicated"
        		+ " below for regular recurring payments and/or one-time payment(s) from time to time, "
        		+ "for any amount invoiced and due to Merchant arising under my account.", font12);
        
      	paragraph7_4.add(paragraph7_5);
      	paragraph7_3.add(paragraph7_4);
      	paragraph7_2.add(paragraph7_3);
        paragraph7_1.add(paragraph7_2);

//        paragraph7_1.setLeading(15);
        document.add(paragraph7_1);
        
//        document.add(new LineSeparator());
        
//        createTable(document, pdfCreater);
 

        
        Paragraph paragraph = new Paragraph("   Checking/ Savings Account	                            Credit Card",fontBold);
        
        paragraph.setAlignment(Paragraph.ALIGN_MIDDLE);
        paragraph.setSpacingAfter(3);
        paragraph.setSpacingBefore(7);
        document.add(paragraph);
//        document.add(newLine);
//        createTableData(document, pdfCreater);
        
//        document.add(newLine);
//        document.add(createBottom(document,pdfCreater.getAmmount()));
        
        document.close();
	}
	
}
