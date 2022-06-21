import com.spire.xls.*;

public class retrieveAndExtractData {
    public static void main(String[] args) {
        //Create a new workbook instance and get the first worksheet.
        Workbook newBook = new Workbook();
        Worksheet newSheet = newBook.getWorksheets().get(0);

        //Create a new workbook instance and load the sample Excel file.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/Template_Xls_3.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Retrieve data and extract it to the first worksheet of the new excel workbook.
        int i = 1;
        int columnCount =  sheet.getColumns().length;
        for(CellRange range :sheet.getColumns()[0].getCellList()){
            if (range.getText().equals("teacher")) {
                CellRange sourceRange = sheet.getRange().get(range.getRow(), 1, range.getRow(), columnCount);
                CellRange destRange = newSheet.getRange().get(i, 1, i, columnCount);
                sheet.copy(sourceRange, destRange,true);
                i++;
            }
        }

        String result = "output/retrieveAndExtractDataToNewExcelFile_result.xlsx";

        //Save to file.
        newBook.saveToFile(result, ExcelVersion.Version2013);
    }
}
