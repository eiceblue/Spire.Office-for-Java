import com.spire.pdf.PdfDocument;
import com.spire.pdf.print.PdfSinglePageScalingMode;

public class customPrintScaling {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument document = new PdfDocument();

        // Load the PDF document from the specified file path
        document.loadFromFile("data/print.pdf");

        // Set the print settings to select a single page layout with custom scaling at 75% size
        document.getPrintSettings().selectSinglePageLayout(PdfSinglePageScalingMode.Custom_Sacle, true, 75);

        // Print the document
        document.print();

        // Close the document (optional, depending on the library used)
        document.close();
        // Dispose of the document (optional, depending on the library used)
        document.dispose();
    }
}
