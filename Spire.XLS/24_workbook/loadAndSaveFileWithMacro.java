import com.spire.xls.*;

public class loadAndSaveFileWithMacro {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/macroSample.xls");

        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getRange().get("A5").setText("This is a simple test!");

        //Save the document
        String output = "output/loadAndSaveFileWithMacro_result.xls";
        workbook.saveToFile(output, ExcelVersion.Version97to2003);
    }
}
