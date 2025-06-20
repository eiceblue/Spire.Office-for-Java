import com.spire.pdf.*;
import com.spire.pdf.utilities.PdfImageHelper;
import com.spire.pdf.utilities.PdfImageInfo;

public class deleteImageFromPDFPage {
    public static void main(String[] args) {
        // Path to the PDF file
        String file = "data/DeleteImage.pdf";

        // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the file
        pdf.loadFromFile(file);

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Get the image information from PDF page
        PdfImageHelper imageHelper = new PdfImageHelper();
        PdfImageInfo[] imageInfos = imageHelper.getImagesInfo(page);

        //Delete the first image
        imageHelper.deleteImage(imageInfos[0]);

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
