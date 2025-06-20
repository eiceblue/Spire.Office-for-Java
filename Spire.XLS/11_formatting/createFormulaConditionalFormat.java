import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;

public class createFormulaConditionalFormat {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/createFormulaConditionalFormat.xlsx";

        //Create a new workbook
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(input);

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get a range of cells in the first column of the worksheet
        CellRange range =sheet.getColumns()[0];

        //Add conditional formatting to the worksheet
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(range);
        //Add a condition to the conditional formatting
        IConditionalFormat conditional = xcfs.addCondition();
        conditional.setFormatType( ConditionalFormatType.Formula);
        conditional.setFirstFormula( "=($A1<$B1)");
        conditional.setBackKnownColor( ExcelColors.Yellow);

        //Save the workbook to the specified file with Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
