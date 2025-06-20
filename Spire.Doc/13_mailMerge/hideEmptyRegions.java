import com.spire.doc.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hideEmptyRegions {
    public static void main(String[] args) throws Exception {
        // Path to the input Word document
        String input = "data/hideEmptyRegions.doc";

        // Path to the output Word document
        String output = "output/hideEmptyRegions.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the input Word document
        document.loadFromFile(input);

        // Get the current date and format it as a string
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        // Define field names and values for mail merge
        String[] fieldNames = new String[] {"Contact Name", "Fax", "Date"};
        String[] fieldValues = new String[] {"John Smith", "+1 (69) 123456", dateString};

        // Set the hide empty group option to true
        document.getMailMerge().setHideEmptyGroup(true);

        // Set the hide empty paragraphs option to true
        document.getMailMerge().setHideEmptyParagraphs(true);

        // Execute the mail merge with the specified field names and values
        document.getMailMerge().execute(fieldNames, fieldValues);

        // Save the document to the output path
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document
        document.dispose();
    }
}
