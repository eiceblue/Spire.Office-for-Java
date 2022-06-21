import com.spire.xls.*;

public class wholeNumberDataValidation {
    public static void main(String[] args)throws Exception {
        String input = "data/SetDataValidationOnSeparateSheet.xlsx";
        String output = "output/wholeNumberDataValidation.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get cellRange
        sheet.getCellRange("C12").setText( "Please enter number between 10 and 100:");
        sheet.getCellRange("C12").autoFitColumns();

        //set Whole Number data validation for cell "D12"
        CellRange range = sheet.getCellRange("D12");
        range.getDataValidation().setAllowType(CellDataType.Integer);
        range.getDataValidation().setCompareOperator( ValidationComparisonOperator.Between);
        range.getDataValidation().setFormula1( "10");
        range.getDataValidation().setFormula1("100");
        range.getDataValidation().setAlertStyle( AlertStyleType.Info);
        range.getDataValidation().setShowError(true);
        range.getDataValidation().setErrorTitle("Error");
        range.getDataValidation().setErrorMessage( "Please enter a valid number");
        range.getDataValidation().setInputMessage("Whole Number Validation Type");
        range.getDataValidation().setIgnoreBlank(true);
        range.getDataValidation().setShowInput( true);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
