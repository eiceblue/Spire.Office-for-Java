import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class setFont {
    public static void main(String[] args) throws Exception {
        String input = "data/SetFont.xlsx";
        String output = "output/setFont_output.xlsx";

        Workbook workbook = new Workbook();
        //load file from disk
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first sheet
        Chart chart = sheet.getCharts().get(0);

        //create a font
        ExcelFont font = workbook.createFont();
        font.setSize(15.0);
        font.setColor(Color.lightGray);
        for (ChartSerie cs : (Iterable<ChartSerie>)chart.getSeries())
        {
            //set font
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().getTextArea().setFont(font);
        }
        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
