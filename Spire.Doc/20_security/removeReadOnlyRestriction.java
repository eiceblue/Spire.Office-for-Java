import com.spire.doc.*;

public class removeReadOnlyRestriction {
    public static void main(String[] args) {
		// Create a new document object
		Document document = new Document();

		// Load the document from the specified input file "data/RemoveReadOnlyRestriction.docx"
		document.loadFromFile("data/RemoveReadOnlyRestriction.docx");

		// Remove any read-only restrictions from the document by setting No_Protection as the protection type
		document.protect(ProtectionType.No_Protection);

		// Specify the output file path
		String result = "output/RemoveReadOnlyRestriction_out.docx";

		// Save the modified document to the specified output file in DOCX format (compatible with Word 2013)
		document.saveToFile(result, FileFormat.Docx_2013);

		// Dispose the document resources
		document.dispose();
    }
}
