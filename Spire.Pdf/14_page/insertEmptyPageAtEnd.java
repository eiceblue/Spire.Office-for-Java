import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfMargins;

public class insertEmptyPageAtEnd {
    public static void main(String[] args) {
        // Path to the input PDF file
        String input = "data/Sample.pdf";

        // Path to save the output PDF file with an empty page at the end
        String output = "output/insertEmptyPageAtEnd_out.pdf";

        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified input file
        doc.loadFromFile(input);

        // Add an empty page at the end of the document using A4 size and zero margins
        doc.getPages().add(PdfPageSize.A4, new PdfMargins(0, 0));

        // Save the modified PDF document to the specified output file in PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document and release associated resources
        doc.close();
        doc.dispose();
    }
}
