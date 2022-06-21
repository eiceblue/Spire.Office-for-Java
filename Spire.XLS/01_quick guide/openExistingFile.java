import com.spire.xls.*;

public class openExistingFile {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        workbook.loadFromFile("data/templateAz2.xlsx");

        //Add a new sheet, named MySheet
        Worksheet sheet = workbook.getWorksheets().add("MySheet");

        //Get the reference of "A1" cell from the cells collection of a worksheet
        sheet.get("A1").setText("Hello World");


        String result = "output/openExistingFile_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);

    }
}
