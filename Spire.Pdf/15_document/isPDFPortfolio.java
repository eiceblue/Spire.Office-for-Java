import com.spire.pdf.*;

public class isPDFPortfolio {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified file "data/pdfTemplate_N.pdf"
        doc.loadFromFile("data/pdfTemplate_N.pdf");

        // Check if the loaded document is a portfolio
        boolean value = doc.isPortfolio();
        if (value) {
            // Print a message indicating that the document is a portfolio
            System.out.println("The document is a portfolio.");
        } else {
            // Print a message indicating that the document is not a portfolio
            System.out.println("The document is not a portfolio.");
        }

        // Close the document
        doc.close();

        // Dispose of system resources associated with the document
        doc.dispose();
    }
}
