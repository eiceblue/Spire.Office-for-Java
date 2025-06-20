import com.spire.pdf.*;

public class toOFD {
    public static void main(String[] args) {
        // Create a new PdfDocument
        PdfDocument pdfDocument =new PdfDocument();

        // Load the file
        pdfDocument.loadFromFile("data/Sample.pdf");

        // Save the file as OFD format
        pdfDocument.saveToFile("output/toOFD.ofd",FileFormat.OFD);

        // Close the document
        pdfDocument.close();

        // Dispose of the resources used by the document
        pdfDocument.dispose();
    }
}
