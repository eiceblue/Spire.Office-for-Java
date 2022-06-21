import com.spire.xls.*;

public class applySoftEdgesEffect {
    public static void main(String[] args)throws Exception {
        String input = "data/ChartSample3.xlsx";
        String output = "output/applySoftEdgesEffect.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //specify the size of the soft edge. Value can be set from 0 to 100
        chart.getChartArea().getShadow().setSoftEdge(25);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
