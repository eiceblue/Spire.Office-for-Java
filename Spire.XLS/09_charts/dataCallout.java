import com.spire.xls.*;
import com.spire.xls.charts.*;

public class dataCallout {
    public static void main(String[] args) throws Exception {
        String input = "data/DataCallout.xlsx";
        String output = "output/dataCallout_output.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first chart
        Chart chart = sheet.getCharts().get(0);
        ChartSeries series = chart.getSeries();
        for (int i = 0; i < series.size(); i++) {
            ChartSerie cs = series.get(i);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasValue(true);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasWedgeCallout(true);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasCategoryName(true);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasSeriesName(true);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasLegendKey(true);
        }
        //save the result file
        workbook.saveToFile(output, FileFormat.Version2013);
    }
}
