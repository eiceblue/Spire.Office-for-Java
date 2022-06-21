import com.spire.xls.*;

import java.awt.*;

public class findAndReplaceData {
    public static void main(String[] args) {
       //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/CreateTable.xlsx");

        //Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Find the "Brazil" string
        CellRange[] ranges = worksheet.findAllString("Area", false, false);

        //Traverse the found ranges
        for (CellRange range :ranges) {
            //Replace it with "China"
            range.setText("Area Code");
            //Highlight the color
            range.getStyle().setColor(Color.yellow);
        }
        //String for output file
        String outputFile = "output/findAndReplaceData_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
