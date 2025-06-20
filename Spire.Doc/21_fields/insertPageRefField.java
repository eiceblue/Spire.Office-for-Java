import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertPageRefField {
    public static void main(String[] args) {
   
		// Create a new empty document
		Document document = new Document();

		// Load an existing document from the specified file path
		document.loadFromFile("data/pageRef.docx");

		// Get the last section of the document
		Section section = document.getLastSection();

		// Add a new paragraph to the section
		Paragraph par = section.addParagraph();

		// Append a page reference field to the paragraph with the specified field name
		Field field = par.appendField("pageRef", FieldType.Field_Page_Ref);

		// Set the code for the page reference field with specified parameters
		field.setCode("PAGEREF bookmark1 \\# \"0\" \\* Arabic \\* MERGEFORMAT");

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/insertPageRefField.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
