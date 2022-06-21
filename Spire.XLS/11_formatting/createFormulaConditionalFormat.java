import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;

public class createFormulaConditionalFormat {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/createFormulaConditionalFormat.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet and a cell range.
        Worksheet sheet = workbook.getWorksheets().get(0);
        CellRange range =sheet.getColumns()[0];

        //set the conditional formatting formula and apply the rule to the chosen cell range.
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(range);
        IConditionalFormat conditional = xcfs.addCondition();
        conditional.setFormatType( ConditionalFormatType.Formula);
        conditional.setFirstFormula( "=($A1<$B1)");
        conditional.setBackKnownColor( ExcelColors.Yellow);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
