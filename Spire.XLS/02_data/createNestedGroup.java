import com.spire.xls.*;
import java.awt.*;

public class createNestedGroup {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the style.
        CellStyle style = workbook.getStyles().addStyle("style");
        style.getFont().setColor(Color.green);
        style.getFont().isBold(true);

        //Set the summary rows appear above detail rows.
        sheet.getPageSetup().isSummaryRowBelow(false);

        //Insert sample data to cells.
        sheet.get("A1").setValue("Project plan for project X");
        sheet.get("A1").setCellStyleName(style.getName());

        sheet.get("A3").setValue("Set up");
        sheet.get("A3").setCellStyleName(style.getName());
        sheet.get("A4").setValue("Task 1");
        sheet.get("A5").setValue("Task 2");
        sheet.get("A4:A5").borderAround(LineStyleType.Thin);
        sheet.get("A4:A5").borderInside(LineStyleType.Thin);

        sheet.get("A7").setValue("Launch");
        sheet.get("A7").setCellStyleName(style.getName());
        sheet.get("A8").setValue("Task 1");
        sheet.get("A9").setValue("Task 2");
        sheet.get("A8:A9").borderAround(LineStyleType.Thin);
        sheet.get("A8:A9").borderInside(LineStyleType.Thin);

        //Group the rows that you want to group.
        sheet.groupByRows(2, 9, false);
        sheet.groupByRows(4, 5, false);
        sheet.groupByRows(8, 9, false);

        String result = "output/createNestedGroup_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
