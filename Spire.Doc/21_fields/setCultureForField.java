import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class setCultureForField {
    public static void main(String[] args) {
    
		// Create a new empty document
		Document document = new Document();

		// Add a new section to the document
		Section section = document.addSection();

		// Add a new paragraph to the section
		Paragraph paragraph = section.addParagraph();

		// Append text to the paragraph
		paragraph.appendText("Add Date Field: ");

		// Append a date field with the specified field name and code to the paragraph
		Field field1 = paragraph.appendField("Date1", FieldType.Field_Date);
		field1.setCode("DATE \\@" + "\"yyyy\\MM\\dd\"");

		// Add a new paragraph to the section
		Paragraph newParagraph = section.addParagraph();

		// Append text to the new paragraph
		newParagraph.appendText("Add Date Field with setting French Culture: ");

		// Append a date field with the specified format and field type to the new paragraph
		Field field2 = newParagraph.appendField("\"\\@\"dd MMMM yyyy", FieldType.Field_Date);

		// Set the ASCII locale ID of the character format in the field to French (1036)
		field2.getCharacterFormat().setLocaleIdASCII((short) 1036);

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/setCultureForField.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
