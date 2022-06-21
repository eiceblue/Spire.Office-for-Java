import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class setTrafficLightsIcons {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Add a worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add some data to the Excel sheet cell range and set the format for them.
        sheet.getCellRange("A1").setText("Traffic Lights");
        sheet.getCellRange("A2").setNumberValue(0.95);
        sheet.getCellRange("A2").setNumberFormat("0%");
        sheet.getCellRange("A3").setNumberValue(0.5);
        sheet.getCellRange("A3").setNumberFormat("0%");
        sheet.getCellRange("A4").setNumberValue(0.1);
        sheet.getCellRange("A4").setNumberFormat("0%");
        sheet.getCellRange("A5").setNumberValue(0.9);
        sheet.getCellRange("A5").setNumberFormat("0%");
        sheet.getCellRange("A6").setNumberValue(0.7);
        sheet.getCellRange("A6").setNumberFormat("0%");
        sheet.getCellRange("A7").setNumberValue(0.6);
        sheet.getCellRange("A7").setNumberFormat("0%");

        //Set the height of row and width of column for Excel cell range.
        sheet.getAllocatedRange().setRowHeight(20);
        sheet.getAllocatedRange().setColumnWidth(25);

        //Add a conditional formatting.
        XlsConditionalFormats conditional = sheet.getConditionalFormats().add();
        conditional.addRange(sheet.getAllocatedRange());
        IConditionalFormat format1 = conditional.addCondition();

        //Add a conditional formatting of cell range and set its type to CellValue.
        format1.setFormatType(ConditionalFormatType.CellValue);
        format1.setFirstFormula("300");
        format1.setOperator(ComparisonOperatorType.Less);
        format1.setFontColor(Color.black);
        format1.setBackColor(Color.lightGray);

        //Add a conditional formatting of cell range and set its type to IconSet.
        conditional.addRange(sheet.getAllocatedRange());
        IConditionalFormat format = conditional.addCondition();
        format.setFormatType(ConditionalFormatType.IconSet);
        format.getIconSet().setIconSetType(IconSetType.ThreeTrafficLights1);

        //Save to file.
        String result = "output/setTrafficLightsIcons_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
