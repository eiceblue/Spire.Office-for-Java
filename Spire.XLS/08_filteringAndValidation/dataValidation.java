import com.spire.xls.*;

public class dataValidation {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DataValidation.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Decimal DataValidation
        sheet.getCellRange("B11").setText("Input Number(3-6):");
        CellRange rangeNumber = sheet.getCellRange("B12");
        //Set the operator for the data validation.
        rangeNumber.getDataValidation().setCompareOperator(ValidationComparisonOperator.Between);
        //Set the value or expression associated with the data validation.
        rangeNumber.getDataValidation().setFormula1("3");
        //The value or expression associated with the second part of the data validation.
        rangeNumber.getDataValidation().setFormula2("6");
        //Set the data validation type.
        rangeNumber.getDataValidation().setAllowType(CellDataType.Decimal);
        //Set the data validation error message.
        rangeNumber.getDataValidation().setErrorMessage("Please input correct number!");
        //Enable the error.
        rangeNumber.getDataValidation().setShowError(true);
        rangeNumber.getCellStyle().setKnownColor(ExcelColors.Gray25Percent);

        //Date DataValidation
        sheet.getCellRange("B14").setText("Input Date:");
        CellRange rangeDate = sheet.getCellRange("B15");
        rangeDate.getDataValidation().setAllowType(CellDataType.Date);
        rangeDate.getDataValidation().setCompareOperator(ValidationComparisonOperator.Between);
        rangeDate.getDataValidation().setFormula1("1/1/1970");
        rangeDate.getDataValidation().setFormula2("12/31/1970");
        rangeDate.getDataValidation().setErrorMessage("Please input correct date!");
        rangeDate.getDataValidation().setShowError(true);
        rangeDate.getDataValidation().setAlertStyle(AlertStyleType.Warning);
        rangeDate.getCellStyle().setKnownColor(ExcelColors.Gray25Percent);

        //TextLength DataValidation
        sheet.getCellRange("B17").setText("Input Text:");
        CellRange rangeTextLength = sheet.getCellRange("B18");
        rangeTextLength.getDataValidation().setAllowType(CellDataType.TextLength);
        rangeTextLength.getDataValidation().setCompareOperator(ValidationComparisonOperator.LessOrEqual);
        rangeTextLength.getDataValidation().setFormula1("5");
        rangeTextLength.getDataValidation().setErrorMessage("Enter a Valid String!");
        rangeTextLength.getDataValidation().setShowError(true);
        rangeTextLength.getDataValidation().setAlertStyle(AlertStyleType.Stop);
        rangeTextLength.getCellStyle().setKnownColor(ExcelColors.Gray25Percent);

        sheet.autoFitColumn(2);

        workbook.saveToFile("output/DataValidation.xlsx", ExcelVersion.Version2010);
    }
}
