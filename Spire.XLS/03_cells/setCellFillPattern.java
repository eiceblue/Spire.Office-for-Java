import com.spire.xls.*;

import java.awt.*;

public class setCellFillPattern {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/CommonTemplate.xlsx");

        Worksheet worksheet= workbook.getWorksheets().get(0);
        //Set cell color
        worksheet.getRange().get("B7:F7").getStyle().setColor(Color.yellow);
        //Set cell fill pattern
        worksheet.getRange().get("B8:F8").getStyle().setFillPattern(ExcelPatternType.Percent125Gray);

        //Save the document
        String output = "output/setCellFillPattern_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
