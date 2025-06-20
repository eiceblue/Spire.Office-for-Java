
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;
import java.io.*;

public class getValuesFromAllFields {
    public static void main(String[] args) throws Exception{
    // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/AllFields.pdf");

        // Create a StringBuilder to store the extracted values
        StringBuilder sb = new StringBuilder();

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Iterate through each field in the form widget
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is a text box
            if (field instanceof PdfTextBoxFieldWidget) {
                // Cast the field to a TextBoxFieldWidget
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;

                // Retrieve the text from the text box field
                String text = textBoxField.getText();

                // Append the retrieved text to the StringBuilder
                sb.append("The text in the textbox is " + text + "\r\n");
            }

            // Check if the field is a list box
            if (field instanceof PdfListBoxWidgetFieldWidget) {
                PdfListBoxWidgetFieldWidget listBoxField = (PdfListBoxWidgetFieldWidget) field;
                sb.append("Listbox items are:\r\n");
                // Retrieve the values from the listBoxField
                PdfListWidgetItemCollection items = listBoxField.getValues();

                // Iterate through each item in the list box
                for (int j = 0; j < items.getCount(); j++) {
                    sb.append(items.get(j).getValue() + "\r\n");
                }

                // Retrieve the value from the field
                String selectedValue = listBoxField.getSelectedValue();
                sb.append("The selected value in the listbox is " + selectedValue + "\r\n");
            }

            // Check if the field is a combo box
            if (field instanceof PdfComboBoxWidgetFieldWidget) {
                PdfComboBoxWidgetFieldWidget comBoxField = (PdfComboBoxWidgetFieldWidget) field;
                sb.append("ComBoxField items are:\r\n");
                PdfListWidgetItemCollection items = comBoxField.getValues();

                // Iterate through each item in the combo box
                for (int j = 0; j < items.getCount(); j++) {
                    sb.append(items.get(j).getValue() + "\r\n");
                }

                String selectedValue = comBoxField.getSelectedValue();
                sb.append("The selected value in the comBoxfield is " + selectedValue + "\r\n");
            }

            // Check if the field is a radio button list
            if (field instanceof PdfRadioButtonListFieldWidget) {
                PdfRadioButtonListFieldWidget radioBtnField = (PdfRadioButtonListFieldWidget) field;
                String value = radioBtnField.getValue();
                sb.append("The text in radioButtonfield is " + value + "\r\n");
            }

            // Check if the field is a check box
            if (field instanceof PdfCheckBoxWidgetFieldWidget) {
                PdfCheckBoxWidgetFieldWidget checkBoxField = (PdfCheckBoxWidgetFieldWidget) field;

                boolean state = checkBoxField.getChecked();
                sb.append("If the checkBox is checked: " + state + "\r\n");
            }
        }

        // Write the extracted values to a text file
        writeStringToTxt(sb.toString(), "output/getValuesFromAllFields.txt");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    // Writes a string to a text file.
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            // Write the content to the file
            fWriter.write(content);
        } catch (IOException ex) {
            // An error occurred while writing to the file
            ex.printStackTrace();
        } finally {
            try {
                // Flush and close the FileWriter
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                // An error occurred while flushing or closing the FileWriter
                ex.printStackTrace();
            }
        }
    }

}
