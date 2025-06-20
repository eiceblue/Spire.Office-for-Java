import com.spire.doc.*;
import com.spire.doc.reporting.*;
import java.awt.*;

public class alternateRows {
    public static void main(String[] args) throws Exception {
        // Path to the XML data file
        String data = "data/dataSample.xml";
        // Path to the input Word document
        String input = "data/ExecuteMailMergeSample.doc";
        // Path to the output Word document
        String output = "output/alternateRows.doc";

        // Create a new Document object
        Document doc = new Document();

        // Load the input Word document
        doc.loadFromFile(input);

        // Set up a merge field event handler
        doc.getMailMerge().MergeField = new MergeFieldEventHandler() {

            public void invoke(Object sender, MergeFieldEventArgs args) {
                mailMerge_MergeField(sender, args);
            }
        };

        // Execute mail merge with region using the specified data
        doc.getMailMerge().executeWidthRegion(data);

        // Save the resulting document to the output path
        doc.saveToFile(output, FileFormat.Doc);

        // Dispose of the document
        doc.dispose();
    }

    // Global variable to keep track of the row index
    static int rowIndex = 0;

    // Event handler for the merge field event
    private static void mailMerge_MergeField(Object sender, MergeFieldEventArgs args) {
        // Check if the current merge field name is "Name"
        if (args.getCurrentMergeField().getFieldName().equals("Name")) {
            Color rowColor;
            // Alternate the row color based on the row index
            if (rowIndex % 2 == 0) {
                rowColor = Color.gray;
            }
            else {
                rowColor = Color.lightGray;
            }

            // Get the cell and row containing the current merge field
            TableCell cell = (TableCell) args.getCurrentMergeField().getOwnerParagraph().getOwner();
            TableRow row = cell.getOwnerRow();

            // Set the background color of the row
            row.getRowFormat().setBackColor(rowColor);

            // Increment the row index
            rowIndex++;
        }
    }
}
