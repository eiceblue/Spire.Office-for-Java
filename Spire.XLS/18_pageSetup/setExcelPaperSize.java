import com.spire.xls.*;

public class setExcelPaperSize {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the paper size of the worksheet as A4 paper.
        sheet.getPageSetup().setPaperSize(PaperSizeType.PaperA4);

        String result = "output/setExcelPaperSize_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
