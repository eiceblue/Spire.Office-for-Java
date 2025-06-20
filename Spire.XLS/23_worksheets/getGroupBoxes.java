import com.spire.xls.*;
import com.spire.xls.core.IGroupBoxes;

public class getGroupBoxes {
    public static void main(String[] args) {
        String inputFile = "data/groupBox.xlsx";
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified file path
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Get the collection of group boxes in the worksheet
        IGroupBoxes groupBoxes = worksheet.getGroupBoxes();

        // Iterate through each group box in the collection
        for (int i = 0; i < groupBoxes.getCount(); i++) {
            // Get the name of the current group box
            String name = groupBoxes.get(i).getName();
        }

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
