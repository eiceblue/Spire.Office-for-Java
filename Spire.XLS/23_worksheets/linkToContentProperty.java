import com.spire.xls.*;
import com.spire.xls.core.*;

public class linkToContentProperty {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/accessDocumentProperties.xlsx");

        // Get the collection of custom document properties and add a new property with name "Test" and value "MyNamedRange"
        workbook.getCustomDocumentProperties().add("Test", "MyNamedRange");

        // Retrieve the collection of custom document properties
        ICustomDocumentProperties properties = workbook.getCustomDocumentProperties();

        // Get the specific document property named "Test"
        DocumentProperty property = (DocumentProperty) properties.get("Test");

        // Set the linkToContent property of the document property to true
        property.setLinkToContent(true);

        // Specify the output file path for saving the modified workbook
        String result = "output/linkToContentProperty_result.xlsx";

        // Save the modified workbook to the specified file path, using Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Clean up resources and release memory associated with the workbook
        workbook.dispose();
    }
}
