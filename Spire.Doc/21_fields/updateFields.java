import com.spire.doc.*;

public class updateFields {
    public static void main(String[] args) {
     
		// Load an existing document from the specified file path
		Document document = new Document("data/ifFieldSample.docx");

        	// Setting the culture source when updating fields
        	document.getFieldOptions().setCultureSource(FieldCultureSource.CurrentThread);

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/updateFields.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
