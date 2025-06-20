import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.Field;

public class insertAddressBlockField {
    public static void main(String[] args) {

        String input="data/BlankTemplate.docx";
		// Create a new document object and load the file
		Document document = new Document(input);

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Add a new paragraph to the section
		Paragraph par = section.addParagraph();

		// Append an address block field to the paragraph
		Field field = par.appendField("ADDRESSBLOCK", FieldType.Field_Address_Block);

		// Set the code for the address block field
		field.setCode("ADDRESSBLOCK \\c 1 \\d \\e Test2 \\f Test3 \\l \"Test 4\"");

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String result = "output/insertAddressBlockField.docx";

		// Save the document to the specified file path in Docx format
		document.saveToFile(result, FileFormat.Docx);

		// Dispose of the document resources
		document.dispose();
    }
}
