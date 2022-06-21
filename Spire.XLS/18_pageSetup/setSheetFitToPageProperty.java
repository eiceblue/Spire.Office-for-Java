import com.spire.xls.*;

public class setSheetFitToPageProperty {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setSheetFitToPageProperty_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the FitToPagesTall property.
        sheet.getPageSetup().setFitToPagesTall(1);

        //Set the FitToPagesWide property.
        sheet.getPageSetup().setFitToPagesWide(1);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
