import com.spire.pdf.*;

public class rotateExistingPDF {
    public static void main(String[] args) {
        // Specify the input file path
        String input = "data/Sample.pdf";

        // Specify the output file path
        String output = "output/rotateExistingPDF_out.pdf";

        // Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified input file
        doc.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Get the current rotation value of the page
        int rotation = page.getRotation().getValue();

        // Increment the rotation value by 270 degrees (counterclockwise rotation)
        rotation += PdfPageRotateAngle.Rotate_Angle_270.getValue();

        // Set the new rotation value for the page
        page.setRotation(PdfPageRotateAngle.fromValue(rotation));

        // Save the modified PDF document to the specified output file location
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
