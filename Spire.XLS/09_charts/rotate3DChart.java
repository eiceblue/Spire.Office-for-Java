import com.spire.xls.*;

public class rotate3DChart {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample3.xlsx";
        String output = "output/rotate3DChart.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the chart from the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        Chart chart = sheet.getCharts().get(0);

        //X rotation:
        chart.setRotation(30);
        //Y rotation:
        chart.setElevation(20);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
