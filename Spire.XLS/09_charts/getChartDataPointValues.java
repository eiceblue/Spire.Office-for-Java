import com.spire.xls.*;
import com.spire.xls.charts.*;

public class getChartDataPointValues {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartToImage.xlsx";

        //load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //get the first series of the chart
        ChartSerie cs = chart.getSeries().get(0);

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<cs.getValues().getCount();i++)
        {
            CellRange cell = cs.getValues().getCellList().get(i);
            sb.append(cell.getRangeAddress() + "\r\n");

            //get the data point value
            sb.append("The value of the data point is " + cell.getValue() + "\r\n");
        }
        //print out result
        System.out.println(sb.toString());
    }
}
