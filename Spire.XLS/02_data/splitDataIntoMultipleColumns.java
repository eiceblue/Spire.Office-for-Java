import com.spire.xls.*;

public class splitDataIntoMultipleColumns {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/SplitExcelDataIntoMultipleCols.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Split data into separate columns by the delimited characters of space.
        String[] splitText = null;
        String text = null;
        for (int i = 1; i < sheet.getLastRow(); i++)
        {
            text = sheet.getRange().get(i + 1, 1).getText();
            splitText = text.split(" ");
            for (int j = 0; j < splitText.length; j++)
            {
                sheet.getRange().get(i + 1, 1 + j + 1).setText(splitText[j]);
            }
        }

        String result = "output/splitExcelDataIntoMultipleCols_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
