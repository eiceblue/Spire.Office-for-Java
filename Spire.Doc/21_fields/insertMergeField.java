import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertMergeField {
    public static void main(String[] args) {
		// Create a new empty document
		Document document = new Document();

		// Load an existing document from the specified file path
		document.loadFromFile("data/sampleB_2.docx");

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Add a new paragraph to the section
		Paragraph par = section.addParagraph();

		// Append a merge field to the paragraph with the specified field name
		MergeField field = (MergeField) par.appendField("MyFieldName", FieldType.Field_Merge_Field);

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/insertMergeField.docx";

		// Save the document to the specified file path in Docx format
		document.saveToFile(output, FileFormat.Docx);

		// Dispose of the document resources
		document.dispose();
    }
}
