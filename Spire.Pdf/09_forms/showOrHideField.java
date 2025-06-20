import com.spire.pdf.*;
import com.spire.pdf.actions.PdfHideAction;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

public class showOrHideField {
    public static void main(String[] args) {
		// Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/FormField.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();

        // Iterate through each field in the form widget
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is a text box
            if (field instanceof PdfTextBoxFieldWidget) {
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget)field;

                // Create a hide action and set it as the mouse down action for the text box field
                PdfHideAction hideAction = new PdfHideAction(textBoxField.getName(), true);
                textBoxField.setMouseDown(hideAction);
            }
        }

        String output = "result.pdf";

        // Save the modified document to a file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
