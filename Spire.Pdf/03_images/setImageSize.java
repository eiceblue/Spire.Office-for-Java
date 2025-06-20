import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;

public class setImageSize {
    public static void main(String[] args) {
    // Create a pdf document.
        PdfDocument doc = new PdfDocument();

        // Create one page
        PdfPageBase page = doc.getPages().add();

        // Load an image
        PdfImage image = PdfImage.fromFile("data/ChartImage.png");

        // Set the width and height of image
        float width = image.getWidth() * 0.75f;
        float height = image.getHeight() * 0.75f;

        // Define a position to draw image
        double x = (page.getCanvas().getClientSize().getWidth() - width) / 2;
        float y = 60f;

        // Draw image on page canvas
        page.getCanvas().drawImage(image, x, y, width, height);

        // Specify the output path
        String result = "output/setImageSize.pdf";

        // Save the document
        doc.saveToFile(result, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
