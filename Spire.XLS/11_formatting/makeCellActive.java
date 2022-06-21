import com.spire.xls.*;

public class makeCellActive {
    public static void main(String[] args) {
        String inputFile="data/templateAz.xlsx";
        String outputFile = "output/makeCellActive_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();
        //Read an Excel file
        workbook.loadFromFile(inputFile);

        //Get the 2nd sheet
        Worksheet sheet =  workbook.getWorksheets().get(1);

        //Set the 2nd sheet as an active sheet.
        sheet.activate();

        //Set B2 cell as an active cell in the worksheet.
        sheet.setActiveCell(sheet.getCellRange("B2"));

        //Set the B column as the first visible column in the worksheet.
        sheet.setFirstVisibleColumn(1);

        //Set the 2nd row as the first visible row in the worksheet.
        sheet.setFirstVisibleRow(1);

        //Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
