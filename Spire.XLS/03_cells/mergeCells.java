import com.spire.xls.*;

public class mergeCells {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_1.xlsx");

        //Merge the seventh column in Excel file.
        workbook.getWorksheets().get(0).getColumns()[6].merge();

        //Merge the particular range in Excel file.
        workbook.getWorksheets().get(0).getRange().get("A14:D14").merge();

        String result = "output/mergeCells_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
