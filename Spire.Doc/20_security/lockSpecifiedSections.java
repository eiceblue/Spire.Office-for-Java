import com.spire.doc.*;

public class lockSpecifiedSections {
    public static void main(String[] args) {
        // Create a new document object
        Document document = new Document();

        // Add two sections to the document
        Section s1 = document.addSection();
        Section s2 = document.addSection();

        // Add a paragraph with text to section 1
        s1.addParagraph().appendText("Spire.Doc demo, section 1");

        // Add a paragraph with text to section 2
        s2.addParagraph().appendText("Spire.Doc demo, section 2");

        // Protect the document by allowing only form fields and using the password "123"
        document.protect(ProtectionType.Allow_Only_Form_Fields, "123");

        // Disable form protection for section 2
        s2.setProtectForm(false);

        // Specify the output file path
        String result = "output/LockSpecifiedSections.docx";

        // Save the modified document to the specified output file in DOCX format (compatible with Word 2013)
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose the document resources
        document.dispose();
    }
}
