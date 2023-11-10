package fr.esir.omd.ci;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

public class tests {

    Document document = new Document();
    private static String FILE = "Test.pdf";
    @Test
    public void testCreation() {
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        document.open();
        try {
            FirstPdf.addTitlePage(document); // doit créer une nouvelle page
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        assertEquals(new PdfName("Document"),document.getRole());
        document.close();
    }
}
