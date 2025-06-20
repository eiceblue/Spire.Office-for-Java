import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class replaceTextWithMergeField {
    public static void main(String[] args) {

		// Create a new empty document
		Document document = new Document();

		// Load an existing document from the specified file path
		document.loadFromFile("data/sampleB_2.docx");

		// Find the text "Test" in the document and select it
		TextSelection ts = document.findString("Test", true, true);

		// Get the selected text range as a single range
		TextRange tr = ts.getAsOneRange();

		// Get the owner paragraph of the text range
		Paragraph par = tr.getOwnerParagraph();

		// Get the index of the text range within its parent paragraph
		int index = par.getChildObjects().indexOf(tr);

		// Create a new merge field
		MergeField field = new MergeField(document);
		field.setFieldName("MergeField");

		// Insert the merge field at the position of the text range within the paragraph
		par.getChildObjects().insert(index, field);

		// Remove the text range from its parent paragraph
		par.getChildObjects().remove(tr);

		// Specify the file path for the resulting document
		String output = "output/replaceTextWithMergeField.docx";

		// Save the document to the specified file path in Docx 2013 format
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		document.dispose();
    }
}
