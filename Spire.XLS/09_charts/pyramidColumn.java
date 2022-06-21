import com.spire.xls.*;
import com.spire.xls.charts.ChartSerie;
import java.awt.*;

public class pyramidColumn {
    public static void main(String[] args) throws Exception {
        //add pyramid column chart
        pyramidColumn();

        //add pyramid column 3D chart
        pyramidColumn3D();
    }

    public static void pyramidColumn(){
        executePyramidColumn(false,"output/pyramidColumn.xlsx");
    }

    public static void pyramidColumn3D(){
        executePyramidColumn(true,"output/pyramidColumn3D.xlsx");
    }

    private static void executePyramidColumn(boolean is3D,String output) {
        //create a Workbook
        Workbook workbook = new Workbook();

        //get the first sheet and set its name
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("Chart");

        //set chart data
        createChartData(sheet);

        //add a chart
        Chart chart = sheet.getCharts().add();

        //set region of chart data
        chart.setDataRange(sheet.getCellRange("B2:B5"));
        chart.setSeriesDataFromRange(false);

        //set position of chart
        chart.setLeftColumn(1);
        chart.setTopRow(6);
        chart.setRightColumn(11);
        chart.setBottomRow(29);

        if (is3D)
        {
            chart.setChartType(ExcelChartType.Pyramid3DClustered);
        }
        else
        {
            chart.setChartType(ExcelChartType.PyramidClustered);
        }

        //chart title
        chart.setChartTitle("Sales by year");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(12);

        chart.getPrimaryCategoryAxis().setTitle("Year");
        chart.getPrimaryCategoryAxis().getFont().isBold(true);
        chart.getPrimaryCategoryAxis().getTitleArea().isBold(true);

        chart.getPrimaryValueAxis().setTitle("Sales(in Dollars)");
        chart.getPrimaryValueAxis().hasMajorGridLines(false);
        chart.getPrimaryValueAxis().setMinValue(1000);
        chart.getPrimaryValueAxis().getTitleArea().isBold(true);
        chart.getPrimaryValueAxis().getTitleArea().setTextRotationAngle(90);

        ChartSerie cs = chart.getSeries().get(0);
        cs.setCategoryLabels(sheet.getCellRange("A2:A5"));
        cs.getFormat().getOptions().isVaryColor(true);

        chart.getLegend().setPosition(LegendPositionType.Top);

        //save the Excel file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }

    private static void createChartData(Worksheet sheet)
    {
        //set value of specified cell
        sheet.getCellRange("A1").setValue("Year");
        sheet.getCellRange("A2").setValue("2002");
        sheet.getCellRange("A3").setValue("2003");
        sheet.getCellRange("A4").setValue("2004");
        sheet.getCellRange("A5").setValue("2005");

        sheet.getCellRange("B1").setValue("Sales");
        sheet.getCellRange("B2").setNumberValue(4000);
        sheet.getCellRange("B3").setNumberValue(6000);
        sheet.getCellRange("B4").setNumberValue(7000);
        sheet.getCellRange("B5").setNumberValue(8500);

        //set style of cells
        sheet.getCellRange("A1:B1").setRowHeight(15);
        sheet.getCellRange("A1:B1").getCellStyle().setColor(Color.darkGray);
        sheet.getCellRange("A1:B1").getCellStyle().getExcelFont().setColor(Color.white);
        sheet.getCellRange("A1:B1").getCellStyle().setVerticalAlignment(VerticalAlignType.Center);
        sheet.getCellRange("A1:B1").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Center);

        //set number format of cells
        sheet.getCellRange("B2:C5").getCellStyle().setNumberFormat("\"$\"#,##0");
    }
}
