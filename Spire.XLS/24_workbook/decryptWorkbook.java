import com.spire.xls.*;

public class decryptWorkbook {
    public static void main(String[] args) {
        String fileName = "data/decryptWorkbook.xlsx";

        //Detect if the Excel workbook is password protected.
        boolean value = Workbook.bookIsPasswordProtected(fileName);

        if (value) {
            //Load a file with the password specified
            Workbook workbook = new Workbook();
            workbook.setOpenPassword("eiceblue");
            workbook.loadFromFile(fileName);

            //Decrypt workbook
            workbook.unProtect();

            //Save the document
            String output = "output/decryptWorkbook_result.xlsx";
            workbook.saveToFile(output, ExcelVersion.Version2013);
        }
    }
}
