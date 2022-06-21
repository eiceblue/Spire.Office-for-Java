import com.spire.xls.*;

public class listDataValidation {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DataValidation.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set text for cells
        sheet.getCellRange("A7").setText("Beijing");
        sheet.getCellRange("A8").setText("New York");
        sheet.getCellRange("A9").setText("Denver");
        sheet.getCellRange("A10").setText("Paris");

        //Set data validation for cell
        CellRange range = sheet.getCellRange("D10");
        range.getDataValidation().setShowError(true);
        range.getDataValidation().setAlertStyle(AlertStyleType.Stop);
        range.getDataValidation().setErrorTitle("Error");
        range.getDataValidation().setErrorMessage("Please select a city from the list");
        range.getDataValidation().setDataRange(sheet.getCellRange("A7:A10"));

        //Save the document
        String output = "output/ListDataValidation_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
