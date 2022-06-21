import com.spire.xls.*;

public class timeDataValidation {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getCellRange("C12").setText("Please enter time between 09:00 and 18:00:");
        sheet.getCellRange("C12").autoFitColumns();

        //Set Time data validation for cell "D12"
        CellRange range = sheet.getCellRange("D12");
        range.getDataValidation().setAllowType(CellDataType.Time);
        range.getDataValidation().setCompareOperator(ValidationComparisonOperator.Between);

        range.getDataValidation().setFormula1("09:00");
        range.getDataValidation().setFormula2("18:00");

        range.getDataValidation().setAlertStyle(AlertStyleType.Info);
        range.getDataValidation().setShowError(true);
        range.getDataValidation().setErrorTitle("Time Error");
        range.getDataValidation().setErrorMessage("Please enter a valid time");
        range.getDataValidation().setInputMessage("Time Validation Type");
        range.getDataValidation().setIgnoreBlank(true);
        range.getDataValidation().setShowInput(true);

        //Save the document
        String output = "output/TimeDataValidation_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
