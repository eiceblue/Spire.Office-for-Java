import com.spire.doc.*;

public class lockHeader {
    public static void main(String[] args){
        String input = "data/headerSample.docx";
        String output = "output/lockHeader.docx";

		// Load the document
		Document doc = new Document();
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Protect the document and set the ProtectionType as AllowOnlyFormFields with password "123"
		doc.protect(ProtectionType.Allow_Only_Form_Fields, "123");

		// Set the ProtectForm property of the section as false to unprotect it
		section.setProtectForm(false);

		// Save the document
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose of the document object to release resources
		doc.dispose();
    }
}
