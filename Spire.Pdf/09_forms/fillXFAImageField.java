import com.spire.pdf.*;
import com.spire.pdf.widget.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class fillXFAImageField {
    public static void main(String[] args) throws IOException {
        // Specify the input PDF file path, image file path, and output PDF file path
        String input = "data/XFAImageField.pdf";
        String image = "data/E-logo.png";
        String output = "output/fillXFAImageField_output.xlsx";

        // Load the PDF document
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile(input);

        // Get the form widget from the document
        PdfFormWidget form = (PdfFormWidget) pdfDocument.getForm();

        // Check if the form contains XFA content
        if (form.getXFAForm() != null) {
            java.util.List<XfaField> xFields = form.getXFAForm().getXfaFields();
            for (int i = 0; i < xFields.size(); i++) {
                // Check if the XFA field is an image field
                if (xFields.get(i) instanceof XfaImageField) {
                    XfaImageField xImageField = (XfaImageField) xFields.get(i);

                    // Load the image from the specified image file
                    BufferedImage insertImage = ImageIO.read(new FileInputStream(image));

                    // Set the image for the XFA image field
                    xImageField.setImage(insertImage);
                }
            }
        }

        // Save the modified PDF document
        pdfDocument.saveToFile(output);

        // Close the PDF document to release resources
        pdfDocument.close();

        // Dispose of the PDF document to free up system resources
        pdfDocument.dispose();
    }
}
