import com.spire.doc.Document;

public class checkProtectionPassword {
    public static void main(String[] args) {
        String input = "data/checkProtectionPassword.docx";
        String password = "e-iceblue";

        // Create a new document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(input);

        // Check if the specified password matches the protection password of the document
        boolean checkResult = document.checkProtectionPassWord(password);

        System.out.println(checkResult);

        // Dispose the document resources
        document.dispose();
    }
}
