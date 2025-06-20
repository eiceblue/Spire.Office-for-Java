import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;

public class convertImageToPDF {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Add a page to the document
        PdfPageBase page = pdf.getPages().add();

        // Load a TIFF image from the system
        PdfImage image = PdfImage.fromFile("data/bg.png");

        // Calculate the fit rate for the image based on its width and height relative to the canvas size
        double widthFitRate = image.getPhysicalDimension().getWidth() / page.getCanvas().getClientSize().getWidth();
        double heightFitRate = image.getPhysicalDimension().getHeight() / page.getCanvas().getClientSize().getHeight();

        // Determine the maximum fit rate between width and height
        float fitRate = Math.max((float)widthFitRate, (float)heightFitRate);

        // Calculate the size of the image
        double fitWidth = image.getPhysicalDimension().getWidth() / fitRate;
        double fitHeight = image.getPhysicalDimension().getHeight() / fitRate;

        // Draw the image on the page's canvas
        page.getCanvas().drawImage(image, 0, 30, fitWidth, fitHeight);

        // Specify the output file path
        String output = "output/convertImageToPDF.pdf";

        // Save the PDF document
        pdf.saveToFile(output);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
