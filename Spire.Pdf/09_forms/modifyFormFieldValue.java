
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.*;
import com.spire.pdf.widget.*;

public class modifyFormFieldValue {
    public static void main(String[] args) throws Exception{
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Iterate through each field in the form widget
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is a text box
            if (field instanceof PdfTextBoxFieldWidget) {
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;

                // Check if the text box field has a specific name ("Text1" in this case)
                if (textBoxField.getName().equals("Text1")) {
                    // Set the new value for the text box field
                    textBoxField.setText("New value");
                }
            }
        }

        String output = "output/modifyFormFieldValue-result.pdf";

        // Save the modified document to a file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
