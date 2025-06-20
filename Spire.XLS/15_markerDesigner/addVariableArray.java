import com.spire.xls.*;

public class addVariableArray {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the value of cell range A1 to "&=Array"
        sheet.getCellRange("A1").setValue("&=Array");

        // Add a parameter named "Array" with an array of strings as its value
        workbook.getMarkerDesigner().addParameter("Array", new String[] { "Spire.Xls", "Spire.Doc", "Spire.PDF", "Spire.Presentation", "Spire.Email" });

        // Apply the marker design to the workbook
        workbook.getMarkerDesigner().apply();

        // Calculate all the values in the workbook
        workbook.calculateAllValue();

        // Auto-fit the rows and columns in the allocated range of the worksheet
        sheet.getAllocatedRange().autoFitRows();
        sheet.getAllocatedRange().autoFitColumns();

        // Specify the output file path for saving the workbook
        String output = "output/addVariableArray_result.xlsx";

        // Save the workbook to the specified file path using Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Clean up and release resources used by the workbook
        workbook.dispose();
    }
}
