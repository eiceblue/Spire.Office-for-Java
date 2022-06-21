import com.spire.xls.*;

public class setMarginsOfExcelSheet {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setMarginsOfExcelSheet_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the PageSetup object of the first worksheet.
        PageSetup pageSetup = sheet.getPageSetup();

        //Set bottom,left,right and top page margins.
        pageSetup.setBottomMargin(2);
        pageSetup.setLeftMargin(1);
        pageSetup.setRightMargin(1);
        pageSetup.setTopMargin(3);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
