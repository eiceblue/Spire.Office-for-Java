import com.spire.xls.*;
import java.awt.*;

public class setBorderColorAndStyle {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartSample3.xlsx";
        String output = "output/setBorderColorAndStyle.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet from workbook and then get the first chart from the worksheet
        Worksheet ws = workbook.getWorksheets().get(0);
        Chart chart = ws.getCharts().get(0);

        //set CustomLineWeight property for Series line
        (chart.getSeries().get(0).getDataPoints().get(0).getDataFormat().getLineProperties()).setCustomLineWeight(2.5f);

        //set color property for Series line
        (chart.getSeries().get(0).getDataPoints().get(0).getDataFormat().getLineProperties()).setColor(Color.RED);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
