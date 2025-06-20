import com.spire.doc.*;

public class specifiedProtectionType {
    public static void main(String[] args) {
		// Create a new document object
		Document document = new Document();

		// Load the document from the specified input file "data/JAVATemplate_N.docx"
		document.loadFromFile("data/JAVATemplate_N.docx");

		// Protect the document by allowing only reading and using the password "123456"
		document.protect(ProtectionType.Allow_Only_Reading, "123456");

		// Specify the output file path
		String result = "output/SpecifiedProtectionType.docx";

		// Save the modified document to the specified output file in DOCX format (compatible with Word 2013)
		document.saveToFile(result, FileFormat.Docx_2013);

		// Dispose the document resources
		document.dispose();
    }
}
