package com;

import java.awt.Color;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

@Service
public class PdfServiceAgreement {	

	public void createPdfNew(PdfCreater pdfCreater) throws IOException, DocumentException {
		Document document = new Document();
		document.open();
		
		Paragraph newLine = new Paragraph("\n");
		int center = Element.ALIGN_CENTER;
		
		Image image1 = Image.getInstance("https://resource.fintainium.com/images/footer-logo-fintainium.jpg");
		image1.setAlignment(center);
		document.add(image1);
		
		document.add(newLine);
        Font font15 = FontFactory.getFont("Verdana", 15f, new BaseColor(Color.BLACK));
        Paragraph paragraph1 = new Paragraph("Payment authorization agreement", font15);
        paragraph1.setAlignment(center);
        paragraph1.setSpacingBefore(10);
        paragraph1.setSpacingAfter(30);
        document.add(paragraph1);
        
        Font font12R = FontFactory.getFont("Verdana", 12, new BaseColor(Color.RED));
        Font font12P = FontFactory.getFont("Calibri", 11, new BaseColor(Color.BLACK));
        font12P.setStyle("Bold");
        Paragraph fintainiumClientName = new Paragraph(pdfCreater.getFintainiumClientName(),font12R);
        Paragraph paragraph2 = new Paragraph(" (“Merchant”) certify that I am an authorized representative of the company, ", font12P);
        
        Paragraph ARCustomerName = new Paragraph(pdfCreater.getArCustomerName(),font12R);
        
        Paragraph paragraph3 = new Paragraph(" (“Payor”) and that I have the authority "
        		+ "to authorize payments on the Company’s behalf.  Company understands"
        		+ " that this authorization will remain in effect until it is canceled "
        		+ "in writing, and agrees to notify Fintainium in writing of any changes"
        		+ " in its account information or termination of this authorization at"
        		+ " least 15 days prior to the next billing date.  If a payment date falls"
        		+ " on a weekend or holiday, Company understands that the payments may be"
        		+ " executed on the next business day.  Because these are electronic"
        		+ " transactions, Company understands that these funds may be charged to"
        		+ " its account as soon as the applicable transaction date, and that it"
        		+ " will have limited time to report and dispute errors.  Company hereby"
        		+ " certifies that the identified payment methods are active, enabled and"
        		+ " sufficiently funded, and agrees to reimburse Fintainium for all"
        		+ " penalties and fees incurred as a result of ACH returns or credit/debit"
        		+ " card chargebacks. Company agrees to be bound by applicable NACHA and"
        		+ " card network operating rules. Company acknowledges that it must comply"
        		+ " with applicable state and U.S. laws.  Company agrees not to dispute"
        		+ " scheduled transactions with its bank, provided the transactions"
        		+ " correspond to the terms indicated on this authorization form.", font12P);
        
        ARCustomerName.add(paragraph3);
        paragraph2.add(ARCustomerName);
        fintainiumClientName.add(paragraph2);
        fintainiumClientName.setAlignment(Element.ALIGN_JUSTIFIED);

        document.add(fintainiumClientName);
        
        
        document.close();
	}
}
