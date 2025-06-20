import com.spire.pdf.*;
import java.io.FileWriter;

public class getNumberOfPages {
    public static void main(String[] args) throws Exception {
        // Specify the input and output file paths
        String inputFile = "data/getNumberOfPages.pdf";
        String outputFile = "output/getNumberOfPages_out.txt";

        // Load the PDF document
        PdfDocument pdf = new PdfDocument(inputFile);

        // Get the count of pages in the PDF
        int count = pdf.getPages().getCount();

        // Create a FileWriter to write the page count to the output file
        FileWriter writer = new FileWriter(outputFile);
        writer.write("PagesCount: " + String.valueOf(count));
        writer.flush();
        writer.close();

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();

    }
}
