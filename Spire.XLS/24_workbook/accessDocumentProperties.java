import java.io.*;
import com.spire.xls.*;
import com.spire.xls.core.*;

public class accessDocumentProperties {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load workbook data from the specified file
        workbook.loadFromFile("data/accessDocumentProperties.xlsx");

        // Create a StringBuilder object to store the results
        StringBuilder builder = new StringBuilder();

        // Get the custom document properties of the workbook
        ICustomDocumentProperties properties = workbook.getCustomDocumentProperties();

        // Retrieve the "Editor" document property and append its name and value to the StringBuilder
        DocumentProperty property1 = (DocumentProperty) properties.get("Editor");
        builder.append(property1.getName() + " " + property1.getValue() + "\r\n");

        // Retrieve the document property at index 0 and append its name and value to the StringBuilder
        DocumentProperty property2 = (DocumentProperty) properties.get(0);
        builder.append(property2.getName() + " " + property2.getValue() + "\r\n");

        // Specify the output file path
        String output = "output/accessDocumentProperties_result.xlsx";

        // Create a FileWriter object to write to the output file in append mode
        FileWriter fw = new FileWriter(output, true);

        // Create a BufferedWriter object to optimize writing performance
        BufferedWriter bw = new BufferedWriter(fw);

        // Append the content of the StringBuilder to the BufferedWriter
        bw.append(builder);

        // Close the BufferedWriter
        bw.close();

        // Close the FileWriter
        fw.close();

        // Release resources associated with the workbook
        workbook.dispose();
    }
}
