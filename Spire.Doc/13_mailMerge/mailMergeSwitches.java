import com.spire.doc.*;

public class mailMergeSwitches {
    public static void main(String[] args) throws Exception {
        // Path to the input Word document
        String input = "data/MailMergeSwitches.docx";
        // Path to the output Word document
        String output = "output/mailMergeSwitches_result.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the input Word document
        document.loadFromFile(input);

        // Define field names and values for mail merge
        String[] fieldName = new String[] {"XX_Name"};
        String[] fieldValue = new String[] {"Jason Tang"};

        // Execute the mail merge with the specified field names and values
        document.getMailMerge().execute(fieldName, fieldValue);

        // Save the resulting document to the output path
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document
        document.dispose();
    }
}
