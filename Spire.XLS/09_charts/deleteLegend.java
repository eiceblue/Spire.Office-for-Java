import com.spire.xls.*;

public class deleteLegend {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample1.xlsx";
        String output = "output/deleteLegend.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //delete all legend from the chart
        //chart.Legend.Delete();

        //delete the first and the second legend entries from the chart
        chart.getLegend().getLegendEntries().get(0).delete();
        chart.getLegend().getLegendEntries().get(1).delete();

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
