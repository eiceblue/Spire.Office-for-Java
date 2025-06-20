import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.Field;

public class insertAdvanceField {
    public static void main(String[] args) {

        String input="data/BlankTemplate.docx";
		// Create a new document object and load the file
		Document document = new Document(input);

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Add a new paragraph to the section
		Paragraph par = section.addParagraph();

		// Append an advance field to the paragraph
		Field field = par.appendField("Field", FieldType.Field_Advance);

		// Set the code for the advance field with specified parameters
		field.setCode("ADVANCE \\d 10 \\l 10 \\r 10 \\u 0 \\x 100 \\y 100");

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String result = "output/insertAdvanceField.docx";

		// Save the document to the specified file path in Docx format
		document.saveToFile(result, FileFormat.Docx);

		// Dispose of the document resources
		document.dispose();
    }
}
