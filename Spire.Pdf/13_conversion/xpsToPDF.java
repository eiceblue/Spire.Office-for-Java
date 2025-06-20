import com.spire.pdf.*;

public class xpsToPDF {
    public static void main(String[] args) {
        String inputFile = "data/XPStoPDF.xps";
        String outputFile = "output/xpsToPDF_out.pdf";

        // Load the xps file
        PdfDocument doc = new PdfDocument();
        doc.loadFromXPS(inputFile);

        // Convert xps to pdf file
        doc.saveToFile(outputFile);

        // Close the document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
}
