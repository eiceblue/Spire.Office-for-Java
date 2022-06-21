import com.spire.xls.*;
import java.awt.*;

public class setChartBackgroundColor {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample1.xlsx";
        String output = "output/setChartBackgroundColor.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet from workbook and then get the first chart from the worksheet
        Worksheet ws = workbook.getWorksheets().get(0);
        Chart chart = ws.getCharts().get(0);

        //set background color
        chart.getChartArea().setForeGroundColor(Color.YELLOW);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
