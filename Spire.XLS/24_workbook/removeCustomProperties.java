import com.spire.xls.*;
import com.spire.xls.core.*;

public class removeCustomProperties {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file path
        workbook.loadFromFile("data/templateAz.xlsx");

        // Get the custom document properties of the workbook
        ICustomDocumentProperties customDocumentProperties = workbook.getCustomDocumentProperties();

        // Remove the custom document property with the name "Editor"
        customDocumentProperties.remove("Editor");

        // Specify the result file path for saving the modified workbook
        String result = "output/removeCustomProperties_result.xlsx";

        // Save the workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Clean up resources
        workbook.dispose();
    }
}
