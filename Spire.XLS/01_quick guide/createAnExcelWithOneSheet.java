import com.spire.xls.*;

public class createAnExcelWithOneSheet {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //Create a workbook
        Workbook workbook = new Workbook();
        workbook.createEmptySheets(1);
        Worksheet sheet = workbook.getWorksheets().get(0);

        for (int row = 1; row <= 10000; row++)
        {
            for (int col = 1; col <= 30; col++)
            {
                sheet.get(row, col).setText(row + "," + col);
            }
        }
        String result = "output/createAnExcelWithOneSheet_result.xlsx";

        workbook.saveToFile(result, ExcelVersion.Version2010);

        long endTime = System.currentTimeMillis();
        System.out.println("File has been created successfully!");
        System.out.println("Time consumed (Seconds): "+ (endTime-startTime)+"ms");
    }
}
