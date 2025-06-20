import com.spire.xls.*;
import java.io.*;

public class findTextInCellRange{
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file
        workbook.loadFromFile("data/FindTextFromRangeWithFindOptions.xlsx");

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a StringBuilder to store the result
        StringBuilder builder = new StringBuilder();

        // Get the cell range from A16 to B20
        CellRange range = sheet.getRange().get("A16:B20");

        // Find all occurrences of "e-iceblue1" in the specified range and type
        CellRange[] resultRange = range.findAll("e-iceblue1", FindType.Text, ExcelFindOptions.None);

        // Check if any occurrences were found
        if (resultRange.length != 0)
        {
            // Iterate through each found occurrence
            for(CellRange r:resultRange)
            {
                // Get the address of the found cell
                String address = r.getRangeAddress();

                // Append the address to the result string
                builder.append("In the range 'A16:B20', the address of the cell containing 'e-iceblue1' is: " + address+"\n");
            }
        }

        // Set the output file path
        String result = "output/Result_out.txt";

        // Create a File object for the output file
        File resultFile = new File(result);

        // Create a FileWriter to write to the output file
        FileWriter fw = new FileWriter(resultFile);

        // Write the result string to the output file
        fw.write(builder.toString());

        // Close the FileWriter
        fw.close();

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
