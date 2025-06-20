import com.spire.compression.TiffCompressionTypes;
import com.spire.pdf.PdfDocument;

public class PdfToTiff {
    public static void main(String[] args) {
        // Path to the input PDF document
        String input = "data/Sample.pdf";

        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument(); 

        // Load the PDF document from the specified file path
        pdf.loadFromFile(input);

        // Save the document as a TIFF image
        pdf.saveToTiff("output/page1toTiff.tiff");

        // Save pages as a TIFF image with dpi settings
        pdf.saveToTiff("output/page2toTiff.tiff", 1, 2, 300, 300);

        // Close the document
        pdf.close();

        // Dispose of the resources used by the document
        pdf.dispose();
    }
}
