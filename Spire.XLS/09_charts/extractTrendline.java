import com.spire.xls.*;
import com.spire.xls.core.*;

public class extractTrendline {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample4.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the chart from the first worksheet
        Chart chart = workbook.getWorksheets().get(0).getCharts().get(0);

        //get the trendline of the chart and then extract the equation of the trendline
        IChartTrendLine trendLine = chart.getSeries().get(1).getTrendLines().get(0);
        String formula = trendLine.getFormula();

        //print out
        System.out.println("The equation is: " + formula);
    }
}
