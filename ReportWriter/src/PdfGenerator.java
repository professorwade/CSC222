import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;

public class PdfGenerator {

    /**
     * Very Simple Method to generate a PDF file of the string passed in with a file name passed in
     * @param fileName - what to name the pdf document
     * @param data - data to be put in the pdf document
     * @throws FileNotFoundException - if file is unable to be created
     */
    public void createPdf(String fileName, String data) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(fileName);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph(data));
        document.close();
    }
}
