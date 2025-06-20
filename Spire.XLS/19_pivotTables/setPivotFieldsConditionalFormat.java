import java.awt.Color;
import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class setPivotFieldsConditionalFormat {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file named "PivotTableExample.xlsx" from the specified path
        workbook.loadFromFile(("data/PivotTableExample.xlsx"));

        // Get the Worksheet named "PivotTable" from the workbook
        Worksheet worksheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable from the Worksheet
        PivotTable table = (PivotTable)worksheet.getPivotTables().get(0);

        // Get the collection of PivotConditionalFormats from the PivotTable
        PivotConditionalFormatCollection pcfs = table.getPivotConditionalFormats();

        // Add a new PivotConditionalFormat for the first data field in the PivotTable
        PivotConditionalFormat pc = pcfs.addPivotConditionalFormat(table.getDataFields().get(0));

        // Add a new condition to the PivotConditionalFormat
        IConditionalFormat cf= pc.addCondition();

        // Set the format type of the condition to NotContainsBlanks
        cf.setFormatType(ConditionalFormatType.NotContainsBlanks);

        // Set the fill pattern of the condition to Solid
        cf.setFillPattern(ExcelPatternType.Solid);

        // Set the background color of the condition to blue
        cf.setBackColor(Color.blue);

        // Save the workbook to the specified file path in Excel 2016 format
        workbook.saveToFile("output/result.xlsx",FileFormat.Version2016);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
