package com;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

@RestController
public class PdfControllerAuthForm {

	@Autowired
	PdfServiceAuthForm pdfServiceAuthForm;
	
	@PostMapping("/authorization")
	public ResponseEntity<Object> createPdfController(@RequestBody PdfCreater pdfCreater,HttpServletResponse response) throws IOException, DocumentException {

		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";

		String headerValue = "attachment; filename=pdf_" + "los" + "_" + currentDateTime + ".pdf";
		System.out.println(headerValue);

		response.setHeader(headerKey, headerValue);
		
		pdfServiceAuthForm.createPdf(pdfCreater,response);
		return new ResponseEntity<>("Successfully", HttpStatus.OK);
	}
}
