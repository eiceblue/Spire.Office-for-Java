import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class removeField {
    public static void main(String[] args) {

		// Create a new empty document
		Document document = new Document();

		// Load an existing document from the specified file path
		document.loadFromFile("data/ifFieldSample.docx");

		// Get the first field in the document
		Field field = document.getFields().get(0);

		// Get the owner paragraph of the field
		Paragraph par = field.getOwnerParagraph();

		// Get the index of the field within its parent paragraph
		int index = par.getChildObjects().indexOf(field);

		// Remove the field from its parent paragraph
		par.getChildObjects().removeAt(index);

		// Specify the file path for the resulting document
		String output = "output/removeField.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
