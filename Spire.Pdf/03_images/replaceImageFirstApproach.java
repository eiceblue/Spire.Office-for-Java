import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;
import com.spire.pdf.graphics.PdfImage;

public class replaceImageFirstApproach {
    public static void main(String[] args) {
        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from a file on disk
        doc.loadFromFile("data/ReplaceImage.pdf");

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Get information about the images present on the page
        PdfImageInfo[] imageInfo = page.getImagesInfo();

        // Replace the first image on the page with a new image loaded from file
        page.replaceImage(imageInfo[0].getImage().getMinTileX(), PdfImage.fromFile("data/E-iceblueLogo.png"));

        // Specify the output file path for the modified PDF document
        String result = "output/replaceImageFirstApproach.pdf";

        // Save the modified PDF document to the specified file path
        doc.saveToFile(result, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
