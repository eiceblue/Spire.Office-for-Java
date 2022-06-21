import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;
import java.util.Iterator;

public class formatAxis {
    public static void main(String[] args) throws Exception {
        String output = "output/formatAxis.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();

        //get the first sheet and set its name
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("FormatAxis");

        //set chart data
        createChartData(sheet);

        //add a chart
        Chart chart = sheet.getCharts().add(ExcelChartType.ColumnClustered);
        chart.setDataRange(sheet.getCellRange("B1:B9"));
        chart.setSeriesDataFromRange(false);
        chart.getPlotArea().setVisible(false);
        chart.setTopRow(10);
        chart.setBottomRow(28);
        chart.setLeftColumn(2);
        chart.setRightColumn(10);
        chart.setChartTitle("Chart with Customized Axis");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(12);
        ChartSerie cs1 = chart.getSeries().get(0);
        cs1.setCategoryLabels(sheet.getCellRange("A2:A9"));

        //format axis
        chart.getPrimaryValueAxis().setMajorUnit(8);
        chart.getPrimaryValueAxis().setMinorUnit(2);
        chart.getPrimaryValueAxis().setMaxValue(50);
        chart.getPrimaryValueAxis().setMinValue(0);
        chart.getPrimaryValueAxis().isReverseOrder(false);
        chart.getPrimaryValueAxis().setMajorTickMark(TickMarkType.TickMarkOutside);
        chart.getPrimaryValueAxis().setMinorTickMark(TickMarkType.TickMarkInside);
        chart.getPrimaryValueAxis().setTickLabelPosition(TickLabelPositionType.TickLabelPositionNextToAxis);
        chart.getPrimaryValueAxis().setCrossesAt(0);

        //set number format
        chart.getPrimaryValueAxis().setNumberFormat("$#,##0");
        chart.getPrimaryValueAxis().isSourceLinked(false);
        ChartSerie serie = chart.getSeries().get(0);
        ChartDataPointsCollection dataPoints = serie.getDataPoints();
        for(ChartDataPoint afffads : (Iterable<ChartDataPoint>)dataPoints){
        }
        Iterator<ChartDataPoint> it = dataPoints.iterator();
        while (it.hasNext()) {
            ChartDataPoint dataPoint = it.next();
            //format series
            dataPoint.getDataFormat().getFill().setFillType(ShapeFillType.SolidColor);
            dataPoint.getDataFormat().getFill().setForeColor(Color.lightGray);

            //set transparency
            dataPoint.getDataFormat().getFill().setTransparency(.3);
        }
        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }

    private static void createChartData(Worksheet sheet) {
        //set value of specified cell
        sheet.getCellRange("A1").setValue("Month");
        sheet.getCellRange("A2").setValue("Jan");
        sheet.getCellRange("A3").setValue("Feb");
        sheet.getCellRange("A4").setValue("Mar");
        sheet.getCellRange("A5").setValue("Apr");
        sheet.getCellRange("A6").setValue("May");
        sheet.getCellRange("A7").setValue("Jun");
        sheet.getCellRange("A8").setValue("Jul");
        sheet.getCellRange("A9").setValue("Aug");

        sheet.getCellRange("B1").setValue("Planned");
        sheet.getCellRange("B2").setNumberValue(38);
        sheet.getCellRange("B3").setNumberValue(47);
        sheet.getCellRange("B4").setNumberValue(39);
        sheet.getCellRange("B5").setNumberValue(36);
        sheet.getCellRange("B6").setNumberValue(27);
        sheet.getCellRange("B7").setNumberValue(25);
        sheet.getCellRange("B8").setNumberValue(36);
        sheet.getCellRange("B9").setNumberValue(48);
    }
}
