import com.spire.xls.*;

public class copyVisibleSheets {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();

        //Load a csv file
        workbook.loadFromFile("data/copyVisibleSheets.xlsx");

        //Create a new workbook
        Workbook workbookNew = new Workbook();
        workbookNew.setVersion(ExcelVersion.Version2013);
        workbookNew.getWorksheets().clear();

        //Loop through the worksheets
        for (Object worksheet : workbook.getWorksheets()) {
            Worksheet sheet = (Worksheet) worksheet;
            //Judge if the worksheet is visible
            if (sheet.getVisibility() == WorksheetVisibility.Visible) {
                //Copy the sheet to new workbook
                workbookNew.getWorksheets().addCopy(sheet);
            }
        }

        //Save the Excel file
        String result = "output/copyVisibleSheets_result.xlsx";
        workbookNew.saveToFile(result, ExcelVersion.Version2013);
    }
}
