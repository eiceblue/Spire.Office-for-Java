import com.spire.xls.*;
import java.util.EnumSet;

public class csvToExcel {
    public static void main(String[] args) {
        String inputFile = "data/CSVToExcel.csv";
        String outputFile = "output/CSVToExcel_out.xlsx";

        //Create a workbook and load a csv file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile, ",", 1, 1);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.getCellRange("D2:E19").setIgnoreErrorOptions(EnumSet.of(IgnoreErrorType.NumberAsText));
        sheet.getAllocatedRange().autoFitColumns();

        //Save the Excel file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
