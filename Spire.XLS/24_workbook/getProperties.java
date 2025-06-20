import com.spire.xls.*;
import com.spire.xls.collections.*;
import com.spire.xls.core.*;
import java.io.*;

public class getProperties {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified path
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Get the built-in document properties of the workbook
        BuiltInDocumentProperties properties1 = workbook.getDocumentProperties();

        // Create a StringBuilder to store the property information
        StringBuilder stringBuilder = new StringBuilder();

        // Append a header for the Excel properties section
        stringBuilder.append("Excel Properties:\r\n");

        // Iterate through each built-in property
        for (int i = 0; i < properties1.getCount(); i++) {
            // Get the name and value of the property
            String name = properties1.get(i).getName();
            String value = properties1.get(i).getValue().toString();

            // Append the property name and value to the StringBuilder
            stringBuilder.append(name + ": " + value + "\r\n");
        }

        // Add a blank line
        stringBuilder.append("\r\n");

        // Get the custom document properties of the workbook
        ICustomDocumentProperties properties2 = workbook.getCustomDocumentProperties();

        // Append a header for the custom properties section
        stringBuilder.append("Custom Properties:\r\n");

        // Iterate through each custom property
        for (int i = 0; i < properties2.getCount(); i++) {
            // Get the name and value of the property
            String name = properties2.get(i).getName();
            String value = properties2.get(i).getValue().toString();

            // Append the property name and value to the StringBuilder
            stringBuilder.append(name + ": " + value + "\r\n");
        }

        // Specify the output path for the result file
        String output = "output/getProperties_result.txt";

        // Create a FileWriter to write to the result file (append mode)
        FileWriter fw = new FileWriter(output, true);

        // Create a BufferedWriter for efficient writing
        BufferedWriter bw = new BufferedWriter(fw);

        // Write the content of the StringBuilder to the result file
        bw.append(stringBuilder);

        // Close the BufferedWriter and FileWriter
        bw.close();
        fw.close();

        // Clean up and release any resources used by the workbook
        workbook.dispose();
    }
}
