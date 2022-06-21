import com.spire.xls.*;

public class setExcelCalculationMode {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/createTable.xlsx");

        //Set excel calculation mode as Manual
        workbook.setCalculationMode(ExcelCalculationMode.Manual);

        //String for output file 
        String outputFile = "output/setExcelCalculationMode_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
