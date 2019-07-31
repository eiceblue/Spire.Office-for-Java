import com.spire.pdf.*;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.graphics.*;
import com.spire.pdf.widget.*;

import java.util.EnumSet;

public class fillFormField {
    public static void main(String[] args) {
        //Load a PDF file
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/fillFormField.pdf");

        //Get the form fields
        PdfFormFieldWidgetCollection formWidgetCollection = null;
        PdfFormWidget form = (PdfFormWidget) doc.getForm();
        formWidgetCollection = form.getFieldsWidget();
        PdfFont font = new PdfFont(PdfFontFamily.Courier, 10f, EnumSet.of(PdfFontStyle.Italic));
        int countIndex = 0;

        //Loop the fields and manipulate them
        for (int i = 0; i < formWidgetCollection.getCount(); i++) {
            PdfField field = formWidgetCollection.get(i);
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
        //Save the file
        doc.saveToFile("output/fillFormField.pdf");
    }
}