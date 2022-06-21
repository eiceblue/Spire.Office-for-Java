import com.spire.xls.*;

public class getSettingsOfDataValidation {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/Sample.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Cell B4 has the Decimal Validation
        CellRange cell = sheet.getCellRange("B4");

        //Get the valditation of this cell
        Validation validation = cell.getDataValidation();

        //Get the settings
        String allowType = validation.getAllowType().toString();
        String data = validation.getCompareOperator().toString();
        String minimum = validation.getFormula1().toString();
        String maximum = validation.getFormula2().toString();
        boolean ignoreBlank = validation.getIgnoreBlank();

        System.out.println("Allow Type:" + allowType);
        System.out.println("Data:" + data);
        System.out.println("Minimum:" + minimum);
        System.out.println("Maximum:" + maximum);
        System.out.println("IgnoreBlank:" + ignoreBlank);

    }
}
