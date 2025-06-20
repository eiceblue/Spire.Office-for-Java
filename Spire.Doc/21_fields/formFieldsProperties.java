import com.spire.doc.*;
import com.spire.doc.fields.FormField;

import java.awt.*;

public class formFieldsProperties {
    public static void main(String[] args) {

		// Create a new document object using the specified input file path
		Document document = new Document("data/FillFormField.doc");

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Get the second form field from the body of the section
		FormField formField = section.getBody().getFormFields().get(1);

		// Check if the form field type is Field_Form_Text_Input
		if (formField.getType().equals(FieldType.Field_Form_Text_Input)) {
			// Set the text of the form field to a specific value
			formField.setText("My name is " + formField.getName());
			
			// Modify the character format properties of the form field
			formField.getCharacterFormat().setTextColor(Color.red);
			formField.getCharacterFormat().setItalic(true);
		}

		// Save the modified document to the specified output file in DOCX format
		document.saveToFile("output/formFieldsProperties.docx", FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}
