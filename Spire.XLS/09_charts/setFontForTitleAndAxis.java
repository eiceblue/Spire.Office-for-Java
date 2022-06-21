import com.spire.xls.*;
import java.awt.*;

public class setFontForTitleAndAxis {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ChartSample1.xlsx");

        //Set font for chart title and chart axis
        Worksheet worksheet = workbook.getWorksheets().get(0);
        Chart chart = worksheet.getCharts().get(0);

        //Format the font for the chart title
        chart.getChartTitleArea().setColor(Color.blue);
        chart.getChartTitleArea().setSize(20.0);
        chart.getChartTitleArea().setFontName("Arial");

        //Format the font for the chart Axis
        chart.getPrimaryValueAxis().getFont().setColor(Color.orange);
        chart.getPrimaryValueAxis().getFont().setSize(10.0);

        chart.getPrimaryCategoryAxis().getFont().setFontName("Arial");
        chart.getPrimaryCategoryAxis().getFont().setColor(Color.red);
        chart.getPrimaryCategoryAxis().getFont().setSize(20.0);


        //Save the document
        String output = "output/setFontForTitleAndAxis_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
