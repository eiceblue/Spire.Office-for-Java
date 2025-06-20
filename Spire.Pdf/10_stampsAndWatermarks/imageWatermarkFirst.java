import com.spire.pdf.*;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;

public class imageWatermarkFirst {
    public static void main(String[] args) {
        // Define the input file paths
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/Background.png";

        // Define the output file path
        String output = "output/imageWatermarkFirst.pdf";

        // Load the PDF document from the first input file
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Set the image as the background of the page
        page.setBackgroundImage(input2);

        // Save the modified PDF document to the specified output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
