import java.util.*;
import com.spire.xls.*;

public class addCustomProperties {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/addCustomProperties.xlsx");

        // Add a custom document property named "_MarkAsFinal" with a boolean value of true
        workbook.getCustomDocumentProperties().add("_MarkAsFinal", true);

        // Add a custom document property named "The Editor" with a string value of "E-iceblue"
        workbook.getCustomDocumentProperties().add("The Editor", "E-iceblue");

        // Add a custom document property named "Phone number" with an integer value of 81705109
        workbook.getCustomDocumentProperties().add("Phone number", 81705109);

        // Add a custom document property named "Revision number" with a double value of 7.12
        workbook.getCustomDocumentProperties().add("Revision number", 7.12);

        // Add a custom document property named "Revision date" with the current date and time
        workbook.getCustomDocumentProperties().add("Revision date", new Date());

        // Specify the output path for the modified workbook
        String output = "output/addCustomProperties_result.xlsx";

        // Save the modified workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Clean up and release any resources used by the workbook
        workbook.dispose();
    }
}
