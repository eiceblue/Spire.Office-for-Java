import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class setTrafficLightsIcons {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set text and number formats for cells A1 to A7
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

        // Set row height and column width for the allocated range of cells
        sheet.getAllocatedRange().setRowHeight(20);
        sheet.getAllocatedRange().setColumnWidth(25);

        // Add conditional formatting to the allocated range of cells
        XlsConditionalFormats conditional = sheet.getConditionalFormats().add();
        conditional.addRange(sheet.getAllocatedRange());

        // Add a condition for comparing cell values
        IConditionalFormat format1 = conditional.addCondition();
        format1.setFormatType(ConditionalFormatType.CellValue);
        format1.setFirstFormula("300");
        format1.setOperator(ComparisonOperatorType.Less);
        format1.setFontColor(Color.black);
        format1.setBackColor(Color.lightGray);

        // Add another condition for applying traffic lights icons
        IConditionalFormat format = conditional.addCondition();
        format.setFormatType(ConditionalFormatType.IconSet);
        format.getIconSet().setIconSetType(IconSetType.ThreeTrafficLights1);

        // Specify the output file path
        String result = "output/setTrafficLightsIcons_result.xlsx";

        // Save the workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
