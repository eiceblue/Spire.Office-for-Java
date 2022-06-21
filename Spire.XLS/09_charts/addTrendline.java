import com.spire.xls.*;

public class addTrendline {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ChartSample2.xlsx");

        Worksheet sheet = workbook.getWorksheets().get(0);
        //select chart and set logarithmic trendline
        Chart chart = sheet.getCharts().get(0);
        chart.setChartTitle("Logarithmic Trendline");
        chart.getSeries().get(0).getTrendLines().add(TrendLineType.Logarithmic);
        //select chart and set moving_average trendline
        Chart chart1 = sheet.getCharts().get(1);
        chart1.setChartTitle("Moving Average Trendline");
        chart1.getSeries().get(0).getTrendLines().add(TrendLineType.Moving_Average);
        //select chart and set linear trendline
        Chart chart2 = sheet.getCharts().get(2);
        chart2.setChartTitle("Linear Trendline");
        chart2.getSeries().get(0).getTrendLines().add(TrendLineType.Linear);
        //select chart and set exponential trendline
        Chart chart3 = sheet.getCharts().get(3);
        chart3.setChartTitle("Exponential Trendline");
        chart3.getSeries().get(0).getTrendLines().add(TrendLineType.Exponential);

        //Save the document
        String output = "output/AddTrendline_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
