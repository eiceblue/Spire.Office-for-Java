import com.spire.xls.*;

public class createAnExcelWithFiveSheets {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        //Create a workbook
        Workbook workbook = new Workbook();
        workbook.createEmptySheets(5);
        for (int i = 0; i < 5; i++)
        {
            Worksheet sheet = workbook.getWorksheets().get(i);
            sheet.setName("Sheet" + i);
            for (int row = 1; row <= 150; row++)
            {
                for (int col = 1; col <= 50; col++)
                {
                    sheet.getCellRange(row, col).setText("row" + row + " col" + col);
                }
            }
        }

        String result = "output/createAnExcelWithFiveSheets_result.xlsx";

        workbook.saveToFile(result, ExcelVersion.Version2010);

        long endTime = System.currentTimeMillis();

        System.out.println("File has been created successfully!");
        System.out.println("Time consumed (Seconds): "+ (endTime-startTime)+"ms");
    }
}
