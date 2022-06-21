import com.spire.xls.*;

public class copyColumns {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/Copying.xls");

        Worksheet sheet1 = workbook.getWorksheets().get(0);
        Worksheet sheet2 = workbook.getWorksheets().get(1);

        //Copy the first column to the third column in the same sheet
        sheet1.copy(sheet1.getColumns()[0],sheet1.getColumns()[2],true,true,true);

        //Copy the first column to the second column in the different sheet
        sheet1.copy(sheet1.getColumns()[0],sheet2.getColumns()[1],true,true,true);

        String result = "output/copyColumns_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
