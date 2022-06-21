import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class setRowColorByConditionalFormat {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile = "output/setRowColorByConditionalFormat_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Select the range that you want to format.
        CellRange dataRange = sheet.getAllocatedRange();

        //Set conditional formatting.
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(dataRange);
        IConditionalFormat format1 = xcfs.addCondition();
        //Determines the cells to format.
        format1.setFirstFormula("=MOD(ROW(),2)=0");
        //Set conditional formatting type
        format1.setFormatType(ConditionalFormatType.Formula);
        //Set the color
        format1.setBackColor(Color.lightGray);

        //Set the backcolor of the odd rows as Yellow
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        xcfs1.addRange(dataRange);
        IConditionalFormat format2 = xcfs.addCondition();
        format2.setFirstFormula("=MOD(ROW(),2)=1");
        format2.setFormatType(ConditionalFormatType.Formula);
        format2.setBackColor(Color.yellow);

        //Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
