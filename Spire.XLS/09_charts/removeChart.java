import com.spire.xls.*;
import com.spire.xls.core.*;

public class removeChart {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample1.xlsx";
        String output = "output/removeChart.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first chart from the first worksheet
        IChartShape chart = sheet.getCharts().get(0);

        //remove the chart
        chart.remove();

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
