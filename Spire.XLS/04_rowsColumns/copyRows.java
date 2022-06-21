import com.spire.xls.*;
public class copyRows {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/Copying.xls");

        Worksheet sheet1 = workbook.getWorksheets().get(0);
        Worksheet sheet2 = workbook.getWorksheets().get(1);

        //Copy the first row to the third row in the same sheet
        sheet1.copy(sheet1.getRows()[0], sheet1.getRows()[2], true, true, true);

        //Copy the first row to the second row in the different sheet
        sheet1.copy(sheet1.getRows()[0], sheet2.getRows()[1], true, true, true);

        String result = "output/CopyRows_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
