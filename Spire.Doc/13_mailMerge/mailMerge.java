import com.spire.doc.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mailMerge {
    public static void main(String[] args) throws Exception {
        // Path to the input Word document
        String input = "data/mailMerge.doc";
        // Path to the output Word document
        String output = "output/mailMerge.doc";

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

        // Execute the mail merge with the specified field names and values
        document.getMailMerge().execute(fieldNames, fieldValues);

        // Save the resulting document to the output path
        document.saveToFile(output, FileFormat.Doc);

        // Dispose of the document
        document.dispose();
    }
}
