import com.spire.xls.*;
public class setArrayOfValuesIntoRange {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Create an empty worksheet.
        workbook.createEmptySheets(1);

        //Get the worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the value of max row and column.
        int maxRow = 10000;
        //int maxRow = 5;
        int maxCol = 200;
        //int maxCol = 5;

        //Output an array of data to a range of worksheet.
        Object[][] myarray = new Object[maxRow + 1][maxCol + 1];
        Boolean[][] isred = new Boolean[maxRow + 1][maxCol + 1];
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxCol; j++) {
                myarray[i][j] =i + j;
                if ((int) myarray[i][j] >8)
                isred[i][j] =true;
            }
        }
        sheet.insertArray(myarray, 1, 1);

        String result = "output/setArrayOfValuesIntoRange_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }

}
