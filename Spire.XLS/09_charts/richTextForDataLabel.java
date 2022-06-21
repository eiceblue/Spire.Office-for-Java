import com.spire.xls.*;
import com.spire.xls.charts.*;

import java.awt.*;

public class richTextForDataLabel {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/ChartToImage.xlsx");

        //Get first worksheet of the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first chart inside this worksheet
        Chart chart = sheet.getCharts().get(0);

        //Get the first datalabel of the first series
        ChartDataLabels datalabel = chart.getSeries().get(0).getDataPoints().get(0).getDataLabels();

        //Set the text
        datalabel.setText("Rich Text Label");

        //Show the value
        chart.getSeries().get(0).getDataPoints().get(0).getDataLabels().hasValue(true);

        //Set styles for the text
        chart.getSeries().get(0).getDataPoints().get(0).getDataLabels().setColor(Color.RED);
        chart.getSeries().get(0).getDataPoints().get(0).getDataLabels().isBold(true);

        //String for output file
        String outputFile = "output/RichTextForDataLabel_out.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

    }
}
