import com.spire.xls.*;

public class formatTable {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/FormatTable.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add Default Style to the table
        sheet.getListObjects().get(0).setBuiltInTableStyle(TableBuiltInStyles.TableStyleMedium9);

        //Show total
        sheet.getListObjects().get(0).setDisplayTotalRow(true);

        //Set calculation type
        sheet.getListObjects().get(0).getColumns().get(0).setTotalsRowLabel("Total");
        sheet.getListObjects().get(0).getColumns().get(1).setTotalsCalculation(ExcelTotalsCalculation.None);
        sheet.getListObjects().get(0).getColumns().get(2).setTotalsCalculation(ExcelTotalsCalculation.None);
        sheet.getListObjects().get(0).getColumns().get(3).setTotalsCalculation(ExcelTotalsCalculation.Sum);
        sheet.getListObjects().get(0).getColumns().get(4).setTotalsCalculation(ExcelTotalsCalculation.Sum);
        sheet.getListObjects().get(0).setShowTableStyleRowStripes(true);
        sheet.getListObjects().get(0).setShowTableStyleColumnStripes(true);

        //Save to file
        workbook.saveToFile("output/formatTable_result.xlsx", ExcelVersion.Version2013);
    }
}
