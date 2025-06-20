
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

public class selectRadioButtonItem {
    public static void main(String[] args) throws Exception{
		// Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/RadioButtonSample.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Iterate through each field in the form widget
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is a radio button list
            if (field instanceof PdfRadioButtonListFieldWidget) {
                PdfRadioButtonListFieldWidget radioButton = (PdfRadioButtonListFieldWidget) field;

                // Check if the radio button list field has a specific name ("RadioButton" in this case)
                if (radioButton.getName().equals("RadioButton")) {
                    // Set the selected index to choose a specific item (e.g., index 1)
                    radioButton.setSelectedIndex(1);
                }
            }
        }

        String output = "output/selectRadioButtonItem-result.pdf";

        // Save the modified document to a file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
