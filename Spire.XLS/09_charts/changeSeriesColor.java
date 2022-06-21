import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class changeSeriesColor {
    public static void main(String[] args) throws Exception {
        String input = "data/ChangeSeriesColor.xlsx";
        String output = "output/changeSeriesColor_output.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first chart
        Chart chart = sheet.getCharts().get(0);

        //get the second series
        ChartSerie cs = chart.getSeries().get(1);

        //set the fill type
        cs.getFormat().getFill().setFillType(ShapeFillType.SolidColor);

        //change the fill color
        cs.getFormat().getFill().setForeColor(Color.orange);

        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
