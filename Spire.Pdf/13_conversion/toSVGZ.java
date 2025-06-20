import com.spire.pdf.*;

public class toSVGZ {
    public static void main(String[] args) {
        // Create a new PdfDocument object to work with PDF files
        PdfDocument pdfDocument = new PdfDocument();

        // Load a PDF file from the specified path
        pdfDocument.loadFromFile("data\\toSVGZ.pdf");

        // Save the loaded PDF document as an SVGZ file with the name "result.svgz"
        pdfDocument.saveToFile("result.svgz", FileFormat.SVGZ);

        // Dispose of system resources associated with the PdfDocument object
        pdfDocument.dispose();
    }
}
