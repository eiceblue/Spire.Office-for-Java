import com.spire.pdf.*;

public class booklet {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Calculate the width and height for the booklet pages (twice the width of A4 page)
        float width = (float) PdfPageSize.A4.getWidth() * 2;
        float height = (float) PdfPageSize.A4.getHeight();

        // Create a booklet from the input PDF document using the specified width and height
        doc.createBooklet("data/booklet.pdf", width, height, true);

        // Specify the output file path for the resulting booklet
        String output = "output/booklet.pdf";

        // Save the booklet to the specified output file in PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the input document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
