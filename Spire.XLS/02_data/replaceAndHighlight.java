import com.spire.xls.*;

import java.awt.*;

public class replaceAndHighlight {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/ReplaceAndHighlight.xlsx");

        Worksheet sheet = workbook.getWorksheets().get(0);

        CellRange[] ranges = sheet.findAllString("Total", true, true);

        for (CellRange range : ranges)
        {
            //reset the text, in other words, replace the text
            range.setText("Sum");

            //set the color
            range.getStyle().setColor(Color.yellow);
        }

        String result="output/replaceAndHighlight_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
