import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.charts.*;
import java.awt.*;

public class setLegendBackgroundColor {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample1.xlsx";
        String output = "output/setLegendBackgroundColor.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        Worksheet ws = workbook.getWorksheets().get(0);
        Chart chart = ws.getCharts().get(0);

        XlsChartFrameFormat x = (XlsChartFrameFormat)chart.getLegend().getFrameFormat();
        x.getFill().setFillType(ShapeFillType.SolidColor);
        x.setForeGroundColor( Color.LIGHT_GRAY);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
