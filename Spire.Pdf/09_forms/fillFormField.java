import com.spire.pdf.*;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.graphics.*;
import com.spire.pdf.widget.*;

import java.util.EnumSet;

public class fillFormField {
    public static void main(String[] args) {
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/fillFormField.pdf");

        // Get the collection of form field widgets
        PdfFormFieldWidgetCollection formWidgetCollection;
        PdfFormWidget form = (PdfFormWidget) doc.getForm();
        formWidgetCollection = form.getFieldsWidget();

        // Specify the font for form fields
        PdfFont font = new PdfFont(PdfFontFamily.Courier, 10f, EnumSet.of(PdfFontStyle.Italic));

        // Iterate through each field in the form
        for (int i = 0; i < formWidgetCollection.getCount(); i++) {
            PdfField field = formWidgetCollection.get(i);

            // Check the type of the field and perform corresponding actions
            if (field instanceof PdfListBoxWidgetFieldWidget) {
                PdfListBoxWidgetFieldWidget listBox = (PdfListBoxWidgetFieldWidget) field;
                listBox.setSelectedIndex(1);
                listBox.setFont(font);
            }
            if (field instanceof PdfCheckBoxWidgetFieldWidget) {
                PdfCheckBoxWidgetFieldWidget checkBoxField = (PdfCheckBoxWidgetFieldWidget) field;
                checkBoxField.setChecked(true);
            }
            if (field instanceof PdfRadioButtonListFieldWidget) {
                PdfRadioButtonListFieldWidget radioButtonListField = (PdfRadioButtonListFieldWidget) field;
                radioButtonListField.setSelectedIndex(1);
            }
            if (field instanceof PdfComboBoxWidgetFieldWidget) {
                PdfComboBoxWidgetFieldWidget comboBoxField = (PdfComboBoxWidgetFieldWidget) field;
                comboBoxField.setSelectedIndex(1);
                comboBoxField.setFont(font);
            }
            if (field instanceof PdfTextBoxFieldWidget) {
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;
                textBoxField.setText("Spire.PDF.Java");
                textBoxField.setFont(font);
            }
            if (field instanceof PdfButtonWidgetFieldWidget) {
                PdfButtonWidgetFieldWidget btnField = (PdfButtonWidgetFieldWidget) field;
                btnField.setText("Go!");
                btnField.setFont(font);
            }
        }

        // Save the updated PDF document
        doc.saveToFile("output/fillFormField.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}