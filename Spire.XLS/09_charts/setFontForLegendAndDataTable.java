import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class setFontForLegendAndDataTable {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample1.xlsx";
        String output = "output/setFontForLegendAndDataTable.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet from workbook
        Worksheet ws = workbook.getWorksheets().get(0);
        Chart chart = ws.getCharts().get(0);

        //create a font with specified size and color
        ExcelFont font = workbook.createFont();
        font.setSize(14);
        font.setColor(Color.RED);

        //apply the font to chart Legend
        chart.getLegend().getTextArea().setFont(font);

        //apply the font to chart DataLabel
        for (ChartSerie cs : (Iterable<ChartSerie>)chart.getSeries())
        {
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().getTextArea().setFont(font);
        }
        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
