import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;

public class deleteImageFirstApproach {
    public static void main(String[] args) {
        // Path to the PDF file
        String file = "data/DeleteImage.pdf";

        // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the file
        pdf.loadFromFile(file);

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Retrieve information about images on the page
        PdfImageInfo[] imageInfo = page.getImagesInfo();

        // Delete the first image on the page
        page.deleteImage(imageInfo[0].getImage().getMinTileX());

        // Specify the output file path for the modified PDF
        String result = "output/deleteImageFirstApproach.pdf";

        // Save the modified PDF document to the output file
        pdf.saveToFile(result, FileFormat.PDF);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
