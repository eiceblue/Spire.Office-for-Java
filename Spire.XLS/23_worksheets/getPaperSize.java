import java.io.*;
import com.spire.xls.*;

public class getPaperSize {
    public static void main(String[] args) throws IOException {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified file path
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Create a StringBuilder to store the paper size information
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate through each worksheet in the workbook
        for (Object worksheet : workbook.getWorksheets()) {
            // Get the current worksheet
            Worksheet sheet = (Worksheet) worksheet;

            // Get the page width and height of the worksheet's page setup
            double width = sheet.getPageSetup().getPageWidth();
            double height = sheet.getPageSetup().getPageHeight();

            // Append the worksheet name, width, and height to the StringBuilder
            stringBuilder.append(sheet.getName() + "\r\n");
            stringBuilder.append("Width: " + width + "\tHeight: " + height + "\r\n\r\n");
        }

        // Specify the file path for the resulting text file
        String output = "output/getPaperSize_result.txt";

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
