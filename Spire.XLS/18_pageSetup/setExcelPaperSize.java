import com.spire.xls.*;

public class setExcelPaperSize {
    public static void main(String[] args) {

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the paper size of the worksheet's page setup to PaperA4
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperA4);

        // Specify the result file path
        String result = "output/setExcelPaperSize_result.xlsx";

        // Save the modified workbook to the specified result file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release any resources used by the workbook
        workbook.dispose();
    }
}
