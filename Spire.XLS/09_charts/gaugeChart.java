import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class gaugeChart {
    public static void main(String[] args) {
        //Create a Workbook
        Workbook workbook = new Workbook();

        //Get the first sheet and set its name
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("Gauge Chart");

        //Set chart data
        CreateChartData(sheet);

        //Add a Doughnut chart
        Chart chart = sheet.getCharts().add(ExcelChartType.Doughnut);
        chart.setDataRange(sheet.getCellRange("A1:A5"));
        chart.setSeriesDataFromRange(false);
        chart.hasLegend(true);

        //Set the position of chart
        chart.setLeftColumn(2);
        chart.setTopRow(7);
        chart.setRightColumn(9);
        chart.setBottomRow(25);

        //Get the series 1
        ChartSerie cs1 = (ChartSerie)chart.getSeries().get("Value");
        cs1.getFormat().getOptions().setDoughnutHoleSize(60);
        cs1.getDataFormat().getOptions().setFirstSliceAngle(270);

        //Set the fill color
        cs1.getDataPoints().get(0).getDataFormat().getFill().setForeColor(Color.yellow);
        cs1.getDataPoints().get(1).getDataFormat().getFill().setForeColor(Color.pink);
        cs1.getDataPoints().get(2).getDataFormat().getFill().setForeColor(Color.orange);
        cs1.getDataPoints().get(3).getDataFormat().getFill().setVisible(false);

        //Add a series with pie chart
        ChartSerie cs2 = (ChartSerie)chart.getSeries().add("Pointer", ExcelChartType.Pie);

        //Set the value
        cs2.setValues(sheet.getCellRange("D2:D4"));
        cs2.setUsePrimaryAxis(false);
        cs2.getDataPoints().get(0).getDataLabels().hasValue(true);
        cs2.getDataFormat().getOptions().setFirstSliceAngle(270);
        cs2.getDataPoints().get(0).getDataFormat().getFill().setVisible(false);
        cs2.getDataPoints().get(1).getDataLabels().hasValue(true);
        cs2.getDataPoints().get(1).getDataFormat().getFill().setFillType(ShapeFillType.SolidColor);
        cs2.getDataPoints().get(1).getDataFormat().getFill().setForeColor(Color.black);
        cs2.getDataPoints().get(2).getDataFormat().getFill().setVisible(false);

        //Save and Launch
        workbook.saveToFile("output/GaugeChart_out.xlsx", FileFormat.Version2010);
    }
    private static void CreateChartData(Worksheet sheet)
    {
        //Set value of specified cell
        sheet.getCellRange("A1").setValue("Value");
        sheet.getCellRange("A2").setValue("30");
        sheet.getCellRange("A3").setValue("60");
        sheet.getCellRange("A4").setValue("90");
        sheet.getCellRange("A5").setValue("180");
        sheet.getCellRange("C2").setValue("Value");
        sheet.getCellRange("C3").setValue("pointer");
        sheet.getCellRange("C4").setValue("End");
        sheet.getCellRange("D2").setValue("10");
        sheet.getCellRange("D3").setValue("1");
        sheet.getCellRange("D4").setValue("189");
    }
}
