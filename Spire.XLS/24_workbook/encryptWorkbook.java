import com.spire.xls.*;

public class encryptWorkbook {
    public static void main(String[] args) {
        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/encryptWorkbook.xlsx");

        //Protect Workbook with the password you want
        workbook.protect("eiceblue");

        //Save the document and launch it
        String output = "output/encryptWorkbook_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
