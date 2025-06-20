import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class setLocaleForField {
    public static void main(String[] args) {

		// Load an existing document from the specified file path
		Document document = new Document("data/sampleB_2.docx");

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Add a new paragraph to the section
		Paragraph par = section.addParagraph();

		// Append a date field with the specified field name to the paragraph
		Field field = par.appendField("DocDate", FieldType.Field_Date);

		// Get the text range of the field and set its ASCII locale ID to Russian (1049)
		TextRange range = (TextRange) field.getOwnerParagraph().getChildObjects().get(0);
		range.getCharacterFormat().setLocaleIdASCII((short) 1049);

		// Set the field text to "2019-10-10"
		field.setFieldText("2019-10-10");

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/setLocaleForField.docx";

		// Save the document to the specified file path in Docx format
		document.saveToFile(output, FileFormat.Docx);

		// Dispose of the document resources
		document.dispose();
    }
}
