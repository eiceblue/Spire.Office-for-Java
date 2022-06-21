import com.spire.xls.*;

public class selectedRangeToPDF {
    public static void main(String[] args) {
        String inputFile = "data/ConversionSample1.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        //Add a new sheet to workbook
        workbook.getWorksheets().add("newsheet");
        //Copy your area to new sheet
        workbook.getWorksheets().get(0).getCellRange("A9:E15").copy(workbook.getWorksheets().get(1).getCellRange("A9:E15"), true );
        //Auto fit column width
        workbook.getWorksheets().get(1).getCellRange("A9:E15").autoFitColumns();

        //Save the document
        String output = "SelectedRangeToPDF.pdf";
        Worksheet worksheet = workbook.getWorksheets().get(1);
        String result = "output/selectedRangeToPDF.pdf";
        worksheet.saveToPdf(result);
    }
}
