import java.io.*;
import com.spire.xls.*;

public class getWorksheetNames {
    public static void main(String[] args) throws IOException {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified file path
        workbook.loadFromFile("data/worksheetSample3.xlsx");

        // Create a StringBuilder to store the worksheet names
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate through each worksheet in the workbook
        for (Object worksheet : workbook.getWorksheets()) {
            // Get the current worksheet
            Worksheet sheet = (Worksheet) worksheet;

            // Append the worksheet name to the StringBuilder
            stringBuilder.append(sheet.getName() + "\r\n");
        }

        // Specify the file path for the resulting text file
        String output = "output/getWorksheetNames_result.txt";

        // Create a FileWriter to write to the text file, with append mode set to true
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);

        // Write the contents of the StringBuilder to the text file
        bw.append(stringBuilder);

        // Close the BufferedWriter and FileWriter
        bw.close();
        fw.close();

        // Release resources associated with the workbook
        workbook.dispose();
    }
}
