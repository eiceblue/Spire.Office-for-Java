import java.io.*;

import com.spire.ms.System.*;
import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class getPivotTableRefreshedInfo {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/pivotTable.xlsx");

        //Get first worksheet of the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Get the first pivot table
        XlsPivotTable pivotTable = (XlsPivotTable) worksheet.getPivotTables().get(0);

        //Get the refreshed information
        DateTime dateTime = pivotTable.getCache().getRefreshDate();
        String refreshedBy = pivotTable.getCache().getRefreshedBy();

        //Create StringBuilder to save 
        StringBuilder content = new StringBuilder();

        //Set string format for displaying
        String result = new String("Pivot table refreshed by:  " + refreshedBy + "\r\nPivot table refreshed date: " + dateTime.toString());

        //Add result string to StringBuilder
        content.append(result + "\r\n");

        //String for output file 
        String outputFile = "output/getPivotTableRefreshedInfo_result.txt";
        FileWriter fw = new FileWriter(outputFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(content);
        bw.close();
        fw.close();

    }
}
