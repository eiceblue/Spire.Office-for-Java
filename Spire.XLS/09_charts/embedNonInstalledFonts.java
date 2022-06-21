import com.spire.xls.*;
import com.spire.xls.charts.ChartSerie;
import java.util.*;

public class embedNonInstalledFonts {
    public static void main(String[] args) {
        String inputFile = "data/embedNonInstalledFonts.xlsx";
        String outputFile = "output/embedNonInstalledFonts_out.pdf";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);
        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first chart
        Chart chart = sheet.getCharts().get(0);

        //Load the font file from disk
        workbook.setCustomFontFilePaths(new String[]{ "data/PT_Serif-Caption-Web-Regular.ttf"});
        Hashtable result  = workbook.getCustomFontParsedResult();
        ArrayList valueList = new ArrayList(result.values());

        //Apply the font for PrimaryValueAxis of chart
        chart.getPrimaryValueAxis().getFont().setFontName(valueList.get(0).toString());

        //Apply the font for PrimaryCategoryAxis of chart
        chart.getPrimaryCategoryAxis().getFont().setFontName(valueList.get(0).toString());

        //Apply the font for the first chartSerie of chart
        ChartSerie chartSerie1 = chart.getSeries().get(0);
        chartSerie1.getDataPoints().getDefaultDataPoint().getDataLabels().setFontName(valueList.get(0).toString());

        //Save to Pdf file
        workbook.saveToFile(outputFile, FileFormat.PDF);
    }
}
