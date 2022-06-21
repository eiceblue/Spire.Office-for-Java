import com.spire.xls.*;
import com.spire.xls.charts.*;

public class adjustBarSpace {
    public static void main(String[] args)throws Exception {
        String input = "data/ChartSample1.xlsx";
        String output = "output/adjustBarSpace.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet from workbook and then get the first chart from the worksheet
        Worksheet ws = workbook.getWorksheets().get(0);
        Chart chart = ws.getCharts().get(0);

        //adjust the space between bars
        for(int i = 0;i<chart.getSeries().getCount(); i++)
        {
            ChartSerie cs=  chart.getSeries().get(i);
            cs.getFormat().getOptions().setGapWidth(200);
            cs.getFormat().getOptions().setOverlap(0);
        }
        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
