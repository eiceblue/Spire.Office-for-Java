import com.spire.xls.*;
import com.spire.xls.charts.*;

public class createMultiLevelChart {
    public static void main(String[] args) throws Exception {
        String output = "output/createMultiLevelChart.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);

        //write data to cells
        sheet.getCellRange("A1").setText( "Main Category");
        sheet.getCellRange("A2").setText("Fruit");
        sheet.getCellRange("A6").setText("Vegies");
        sheet.getCellRange("B1").setText("Sub Category");
        sheet.getCellRange("B2").setText( "Bananas");
        sheet.getCellRange("B3").setText( "Oranges");
        sheet.getCellRange("B4").setText( "Pears");
        sheet.getCellRange("B5").setText("Grapes");
        sheet.getCellRange("B6").setText( "Carrots");
        sheet.getCellRange("B7").setText( "Potatoes");
        sheet.getCellRange("B8").setText( "Celery");
        sheet.getCellRange("B9").setText( "Onions");
        sheet.getCellRange("C1").setText("Value");
        sheet.getCellRange("C2").setValue("52");
        sheet.getCellRange("C3").setValue( "65");
        sheet.getCellRange("C4").setValue( "50");
        sheet.getCellRange("C5").setValue( "45");
        sheet.getCellRange("C6").setValue( "64");
        sheet.getCellRange("C7").setValue( "62");
        sheet.getCellRange("C8").setValue( "89");
        sheet.getCellRange("C9").setValue( "57");

        //vertically merge cells from A2 to A5, A6 to A9
        sheet.getCellRange("A2:A5").merge();
        sheet.getCellRange("A6:A9").merge();
        sheet.autoFitColumn(1);
        sheet.autoFitColumn(2);

        //add a clustered bar chart to worksheet
        Chart chart = sheet.getCharts().add(ExcelChartType.BarClustered);
        chart.setChartTitle( "Value");
        chart.getPlotArea().getFill().setFillType( ShapeFillType.NoFill);
        chart.getLegend().delete();
        chart.setLeftColumn(5);
        chart.setTopRow(1);
        chart.setRightColumn(14);

        //set the data source of series data
        chart.setDataRange(sheet.getCellRange("C2:C9"));
        chart.setSeriesDataFromRange(false);

        //set the data source of category labels
        ChartSerie serie = chart.getSeries().get(0);
        serie.setCategoryLabels( sheet.getCellRange("A2:B9"));

        //show multi-level category labels
        chart.getPrimaryCategoryAxis().setMultiLevelLable( true);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
