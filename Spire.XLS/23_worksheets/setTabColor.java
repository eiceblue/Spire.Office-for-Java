import java.awt.*;

import com.spire.xls.*;

public class setTabColor {
    public static void main(String[] args) {
        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/setTabColor.xlsx");

        //Set the tab color of first sheet to be red 
        Worksheet worksheet = workbook.getWorksheets().get(0);
        worksheet.setTabColor(Color.red);

        //Set the tab color of first sheet to be green 
        worksheet = workbook.getWorksheets().get(1);
        worksheet.setTabColor(Color.green);

        //Set the tab color of first sheet to be blue 
        worksheet = workbook.getWorksheets().get(2);
        worksheet.setTabColor(Color.CYAN);

        //Save the document
        String output = "output/setTabColor_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
