import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

public class removeJavaScrpit {

    public static void main(String args[]){
        // Specify the input and output file paths for the PDF document
        String inputFile = "data/RemoveJavaScrpit.pdf";
        String outputFile = "output/RemoveJavaScrpit_out.pdf";

        // Create a PdfDocument object to load the original document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the input file
        pdf.loadFromFile(inputFile);

        // Remove any JavaScript present in the document
        pdf.removeDocumentJavaScript();

        // Save the modified document to the output file
        pdf.saveToFile(outputFile, FileFormat.PDF);

        // Close and dispose of system resources associated with the document
        pdf.close();
        pdf.dispose();
    }
}
