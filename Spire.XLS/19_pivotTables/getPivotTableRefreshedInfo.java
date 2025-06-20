import java.io.*;
import com.spire.ms.System.*;
import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class getPivotTableRefreshedInfo {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified Excel file
        workbook.loadFromFile("data/pivotTable.xlsx");
        // Get the first worksheet from the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Get the first pivot table from the worksheet
        XlsPivotTable pivotTable = (XlsPivotTable) worksheet.getPivotTables().get(0);

        // Get the refresh date and refreshed by information from the pivot table's cache
        DateTime dateTime = pivotTable.getCache().getRefreshDate();
        String refreshedBy = pivotTable.getCache().getRefreshedBy();

        // Create a StringBuilder object to store the content
        StringBuilder content = new StringBuilder();

        // Create a result string with refreshed by and refreshed date information
        String result = "Pivot table refreshed by:  " + refreshedBy + "\r\nPivot table refreshed date: " + dateTime.toString();
        // Append the result to the content StringBuilder
        content.append(result + "\r\n");

        // Specify the output file path for the result
        String outputFile = "output/getPivotTableRefreshedInfo_result.txt";
        // Create a FileWriter object to write to the output file (append mode)
        FileWriter fw = new FileWriter(outputFile, true);
        // Create a BufferedWriter object to write to the FileWriter
        BufferedWriter bw = new BufferedWriter(fw);
        // Append the content to the BufferedWriter
        bw.append(content);
        // Close the BufferedWriter
        bw.close();
        // Close the FileWriter
        fw.close();

        // Clean up resources and release memory
        workbook.dispose();
    }
}
