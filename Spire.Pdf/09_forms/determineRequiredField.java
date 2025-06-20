import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

public class determineRequiredField {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFile = "data/determineRequiredField.pdf";
        String outputFile = "output/determineRequiredField.pdf";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

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

                // Check if the text box field has the name "username"
                if (textbox.getName().equals("username")) {
                    // Set the text box field as required
                    textbox.setRequired(true);
                }

                // Check if the text box field has the name "password2"
                if (textbox.getName().equals("password2")) {
                    // Set the text box field as not required
                    textbox.setRequired(false);
                }
            }
        }

        // Save the modified PDF document to the output file
        doc.saveToFile(outputFile);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();     
    }
}
