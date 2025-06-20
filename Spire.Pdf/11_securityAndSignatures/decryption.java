import com.spire.pdf.*;

public class decryption {
    public static void main(String[] args) throws java.lang.Exception{
        // Specify the input and output file paths
        String input = "data/decryption.pdf";
        String output = "output/decryption_result.pdf";

        //load the pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input, "test");

        //decrypt the document
        doc.decrypt();

        //save the file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
