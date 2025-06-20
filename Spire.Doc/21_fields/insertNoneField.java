import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertNoneField {
    public static void main(String[] args) {
		// Create a new empty document
		Document document = new Document();

		// Load an existing document from the specified file path
		document.loadFromFile("data/sampleB_2.docx");

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Add a new paragraph to the section
		Paragraph par = section.addParagraph();

		// Append a none field to the paragraph with an empty field code
		Field field = par.appendField("", FieldType.Field_None);

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/insertNoneField.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
