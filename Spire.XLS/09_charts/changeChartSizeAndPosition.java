import com.spire.xls.*;

public class changeChartSizeAndPosition {
    public static void main(String[] args)throws Exception {
        String input = "data/SampeB_4.xlsx";
        String output = "output/changeChartSizeAndPosition.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //change chart size
        chart.setWidth( 600);
        chart.setHeight( 500);

        //change chart position
        chart.setLeftColumn(3);
        chart.setTopRow(7);

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2010);
    }
}
