import com.spire.xls.*;
import com.spire.xls.charts.*;

public class createDoughnutChart {
    public static void main(String[] args) throws Exception {
        String input = "data/SampeB_5.xlsx";
        String output = "output/createDoughnutChart.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);

        //insert data
        sheet.getCellRange("A1").setValue( "Country");
        sheet.getCellRange("A1").getStyle().getFont().isBold(true) ;
        sheet.getCellRange("A2").setValue ("Cuba");
        sheet.getCellRange("A3").setValue("Mexico");
        sheet.getCellRange("A4").setValue("France");
        sheet.getCellRange("A5").setValue("German");
        sheet.getCellRange("B1").setValue("Sales");
        sheet.getCellRange("B1").getStyle().getFont().isBold(true) ;
        sheet.getCellRange("B2").setNumberValue(6000);
        sheet.getCellRange("B3").setNumberValue(8000);
        sheet.getCellRange("B4").setNumberValue(9000);
        sheet.getCellRange("B5").setNumberValue(8500);

        //add a new chart, set chart type as doughnut
        Chart chart = sheet.getCharts().add();
        chart.setChartType( ExcelChartType.Doughnut);
        chart.setDataRange(sheet.getCellRange("A1:B5"));
        chart.setSeriesDataFromRange(false);

        //set position of chart
        chart.setLeftColumn(4);
        chart.setTopRow(2);
        chart.setRightColumn(12);
        chart.setBottomRow(22);

        //chart title
        chart.setChartTitle("Market share by country");
        chart.getChartTitleArea().isBold(true );
        chart.getChartTitleArea().setSize(12);

        for( int i =0; i<chart.getSeries().getCount();i++)
        {
            ChartSerie cs = chart.getSeries().get(i);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasPercentage(true);
        }
        chart.getLegend().setPosition( LegendPositionType.Top);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}

