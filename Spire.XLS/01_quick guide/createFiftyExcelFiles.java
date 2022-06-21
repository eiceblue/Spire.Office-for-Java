import com.spire.xls.*;

public class createFiftyExcelFiles {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int n = 0; n < 50; n++)
        {
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
                        sheet.get(row, col).setText("row" + row + " col" + col);
                    }
                }
            }

            workbook.saveToFile("output/workbook"+n+".xlsx", ExcelVersion.Version2010);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("50 File(s) have been created successfully!");
        System.out.println("Time consumed (Seconds): "+ (endTime-startTime)+"ms");
    }
}
