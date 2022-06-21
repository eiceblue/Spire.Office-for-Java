import com.spire.xls.*;
import java.awt.*;

public class changeMajorGridlines {
    public static void main(String[] args) throws Exception {
        String input = "data/SampeB_4.xlsx";
        String output = "output/changeMajorGridlines.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //change the color of major gridlines
        chart.getPrimaryValueAxis().getMajorGridLines().getLineProperties().setColor(Color.RED);

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
