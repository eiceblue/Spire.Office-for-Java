import com.spire.xls.*;

public class unlockProtectSheet {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/UnprotectProtectSheet.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Unprotect the worksheet with password.
        sheet.unprotect("e-iceblue");

        String result = "output/UnprotectProtectSheet_out.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }

}
