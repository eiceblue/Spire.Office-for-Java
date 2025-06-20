import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;
import java.awt.geom.Point2D;

public class changeFormFieldLocation {
    public static void main(String[] args) throws Exception{
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Iterate through each field in the form
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            // Get the current field
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is a text box field
            if (field instanceof PdfTextBoxFieldWidget) {
                // Cast the field to a text box field
                PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) field;

                // Check if the text box field has the name "Text1"
                if (textbox.getName().equals("Text1")) {
                    // Update the location of the text box field
                    textbox.setLocation(new Point2D.Float(200, 400));
                }
            }
        }

        // Specify the output file path
        String output = "output/changeFormFieldLocation-result.pdf";

        // Save the modified PDF document to the output file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
