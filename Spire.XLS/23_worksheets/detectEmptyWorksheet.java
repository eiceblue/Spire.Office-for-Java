import java.io.*;
import com.spire.xls.*;

public class detectEmptyWorksheet {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/readImages.xlsx");

        // Get the first worksheet from the workbook
        Worksheet worksheet1 = workbook.getWorksheets().get(0);

        // Check if the first worksheet is empty
        boolean detect1 = worksheet1.isEmpty();

        // Get the second worksheet from the workbook
        Worksheet worksheet2 = workbook.getWorksheets().get(1);

        // Check if the second worksheet is empty
        boolean detect2 = worksheet2.isEmpty();

        // Create a StringBuilder to store the result
        StringBuilder content = new StringBuilder();

        // Format the result string with the empty status of both worksheets
        String result = String.format("The first worksheet is empty or not: " + detect1 + "\r\nThe second worksheet is empty or not: " + detect2);

        // Append the result to the content StringBuilder
        content.append(result + "\r\n");

        // Specify the output file path
        String output = "output/detectEmptyWorksheet_result.txt";

        // Create a FileWriter object to write to the output file (append mode)
        FileWriter fw = new FileWriter(output, true);

        // Create a BufferedWriter object to improve writing performance
        BufferedWriter bw = new BufferedWriter(fw);

        // Append the content to the output file
        bw.append(content);

        // Close the BufferedWriter and FileWriter objects
        bw.close();
        fw.close();

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
