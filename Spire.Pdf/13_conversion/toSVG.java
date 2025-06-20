import com.spire.pdf.*;

public class toSVG {
    public static void main(String[] args) {
        String inputFile = "data/JavaPDFSample_2.pdf";
        String outputFile = "output/toSVG_result.svg";

        // Load pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        // Convert Pdf to svg file
        doc.saveToFile(outputFile, FileFormat.SVG);

        // Close the original document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
}
