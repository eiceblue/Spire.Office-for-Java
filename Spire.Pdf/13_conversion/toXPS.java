import com.spire.pdf.*;

public class toXPS {
    public static void main(String[] args) {
        String inputFile = "data/JavaPDFSample_2.pdf";
        String outputFile = "output/toXPS_out.xps";

        // Load the file from input path 
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        // Convert Pdf to xps file.
        pdf.saveToFile(outputFile, FileFormat.XPS);

        // Close the original document
        pdf.close();

        // Dispose of the resources used by the document
        pdf.dispose();
    }
}
