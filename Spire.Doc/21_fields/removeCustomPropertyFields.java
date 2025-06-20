import com.spire.doc.*;

public class removeCustomPropertyFields {
    public static void main(String[] args) {
     
		// Create a new empty document
		Document document = new Document();

		// Load an existing document from the specified file path
		document.loadFromFile("data/removeCustomPropertyFields.docx");

		// Get the custom document properties of the document
		CustomDocumentProperties cdp = document.getCustomDocumentProperties();

		// Get the count of custom document properties
		int i1 = cdp.getCount();

		// Loop through the custom document properties and remove them
		for (int i = 0; i < cdp.getCount(); ) {
			cdp.remove(cdp.get(i).getName());
		}

		// Enable updating fields in the document
		document.isUpdateFields(true);

		// Specify the file path for the resulting document
		String output = "output/removeCustomPropertyFields.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
