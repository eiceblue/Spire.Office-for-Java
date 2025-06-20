import com.spire.pdf.*;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfButtonIconScaleMode;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.widget.*;

public class fillImageInButtonField {
    public static void main(String[] args) throws Exception {
        // Specify the input PDF file paths and the output PDF file path
        String input1 = "data/ButtonField.pdf";
        String input2 = "data/E-logo.png";
        String output = "output/fillImageInButtonField.pdf";

        // Load the PDF document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input1);

        // Get the form widget from the document
        PdfFormWidget form = (PdfFormWidget) pdf.getForm();

        // Iterate through each field in the form
        for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
            // Check if the field is a button form field
            if (form.getFieldsWidget().get(i) instanceof PdfButtonWidgetFieldWidget) {
                PdfButtonWidgetFieldWidget field = (PdfButtonWidgetFieldWidget) form.getFieldsWidget().get(i);
                // Check if the button field has the specified name
                if (field.getName().equals("Button1")) {
                    // Configure the button field's icon layout
                    field.getIconLayout().isFitBounds(true);
                    field.getIconLayout().setScaleMode(PdfButtonIconScaleMode.Anamorphic);

                    // Set the image for the button field using the specified image file
                    field.setButtonImage(PdfImage.fromImage(input2));
                }
            }
        }

        // Save the modified PDF document to the output file
        pdf.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
