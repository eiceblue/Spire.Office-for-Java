import com.spire.xls.*;

public class protectWorkbook {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        //Protect Workbook
        workbook.protect("e-iceblue");

        //Save the document
        String output = "output/protectWorkbook_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
