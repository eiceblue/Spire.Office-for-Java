import com.spire.doc.*;

public class setEditableRange {
    public static void main(String[] args) {
        String inputFile = "data/setEditableRange.docx";
        String outputFile = "output/setEditableRange_output.docx";
        String password = "E-iceblue";
        String permissionId = "myId";
   
		// Create a new document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(inputFile);

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Create a PermissionStart object with the specified permission ID
		PermissionStart start = new PermissionStart(document, permissionId);

		// Create a PermissionEnd object with the specified permission ID
		PermissionEnd end = new PermissionEnd(document, permissionId);

		// Insert the PermissionStart object at the beginning of the child objects of the first paragraph in the section
		section.getParagraphs().get(0).getChildObjects().insert(0, start);

		// Add the PermissionEnd object at the end of the child objects of the first paragraph in the section
		section.getParagraphs().get(0).getChildObjects().add(end);

		// Protect the document by allowing only reading and using the specified password
		document.protect(ProtectionType.Allow_Only_Reading, password);

		// Save the modified document to the specified output file in DOCX format
		document.saveToFile(outputFile, FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}
