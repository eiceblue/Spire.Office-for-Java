import com.spire.pdf.*;

public class deleteImageSecondApproach {
    public static void main(String[] args) {
        // Specify the file path of the PDF document to be modified
        String file = "data/DeleteImage.pdf";

        // Load the PDF document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(file);

        // Get the first page of the PDF document
        PdfPageBase page = pdf.getPages().get(0);

        // Delete the image at index 0 on the page
        page.deleteImage(0);

        // Specify the file path for the resulting modified PDF document
        String result = "output/deleteImageSecondApproach.pdf";

        // Save the modified PDF document to the specified file path
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
