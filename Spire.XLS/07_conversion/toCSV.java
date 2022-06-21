import com.spire.xls.*;
import java.nio.charset.Charset;

public class toCSV {
    public static void main(String[] args) {
        String inputFile = "data/ExcelSampleN.xlsx";
        String outputFile = "output/ToCSV_out.csv";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel file
        workbook.loadFromFile(inputFile);

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Convert to CSV file
        sheet.saveToFile(outputFile, ",", Charset.forName("UTF-8"));
    }
}
