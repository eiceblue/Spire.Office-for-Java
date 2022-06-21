import com.spire.xls.*;

public class unlockSimpleSheet {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Unlock the worksheet in a unlocked Excel file with null string
        sheet.unprotect();

        //Save to file
        String result = "output/unlockSimpleSheet_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
