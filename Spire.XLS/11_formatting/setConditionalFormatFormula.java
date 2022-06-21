import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class setConditionalFormatFormula {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the default first  worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add ConditionalFormat
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();

        //Define the range
        xcfs.addRange(sheet.getCellRange("B5"));

        //Add condition
        IConditionalFormat format = xcfs.addCondition();
        format.setFormatType(ConditionalFormatType.CellValue);

        //If greater than 1000
        format.setFirstFormula("1000");
        format.setOperator(ComparisonOperatorType.Greater);
        format.setBackColor(Color.orange);

        sheet.getCellRange("B1").setNumberValue(40);
        sheet.getCellRange("B2").setNumberValue(500);
        sheet.getCellRange("B3").setNumberValue(300);
        sheet.getCellRange("B4").setNumberValue(400);

        //Set a SUM formula for B5
        sheet.getCellRange("B5").setFormula("=SUM(B1:B4)");

        //Add text
        sheet.getCellRange("C5").setText("If Sum of B1:B4 is greater than 1000, B5 will have orange background.");

        //String for output file
        String outputFile = "output/setConditionalFormatFormula_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
