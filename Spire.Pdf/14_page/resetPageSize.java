import com.spire.pdf.*;
import java.awt.*;
import java.awt.geom.*;
import com.spire.pdf.graphics.*;

public class resetPageSize {
    public static void main(String[] args) {
        // Specify the input file path
        String inputFile = "data/resetPageSize.pdf";

        // Specify the output file path
        String outputFile = "output/resetPageSize_out.pdf";

        // Create a new instance of PdfDocument using the input file
        PdfDocument originalDoc = new PdfDocument(inputFile);

        // Set the margins for the new document to 0
        PdfMargins margins = new PdfMargins(0);

        // Create a new instance of PdfDocument to store the scaled-down pages
        PdfDocument newDoc = new PdfDocument();

        // Set the scale factor for resizing the pages
        float scale = 0.8f;

        // Iterate through each page of the original document
        for (int i = 0; i < originalDoc.getPages().getCount(); i++) {
            // Get the current page from the original document
            PdfPageBase page = originalDoc.getPages().get(i);

            // Calculate the new width and height of the page based on the scale factor
            float width = (float) page.getSize().getWidth() * scale;
            float height = (float) page.getSize().getHeight() * scale;

            // Create a new dimension object with the calculated width and height
            Dimension2D dimension2D = new Dimension();
            dimension2D.setSize(width, height);

            // Add a new page to the new document with the specified dimensions and margins
            PdfPageBase newPage = newDoc.getPages().add(dimension2D, margins);

            // Scale the canvas of the new page to match the scale factor
            newPage.getCanvas().scaleTransform(scale, scale);

            // Draw the content of the original page onto the canvas of the new page
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float());
        }

        // Save the new PDF document to the specified output file location
        newDoc.saveToFile(outputFile);

        // Close the original and new PDF documents to release resources
        originalDoc.close();
        newDoc.close();

        // Dispose of the PDF documents to free up system resources
        originalDoc.dispose();
        newDoc.dispose();
    }
}
