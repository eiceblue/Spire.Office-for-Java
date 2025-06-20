import com.spire.xls.*;

public class textAlign {
    public static void main(String[] args) {
        String inputFile="data/textAlign.xlsx";
        String outputFile = "output/textAlign_result.xlsx";

        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        workbook.loadFromFile(inputFile);

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set vertical alignment of range B1:C1 to Top
        sheet.getCellRange("B1:C1").getCellStyle().setVerticalAlignment(VerticalAlignType.Top);

        // Set vertical alignment of range B2:C2 to Center
        sheet.getCellRange("B2:C2").getCellStyle().setVerticalAlignment(VerticalAlignType.Center);

        // Set vertical alignment of range B3:C3 to Bottom
        sheet.getCellRange("B3:C3").getCellStyle().setVerticalAlignment(VerticalAlignType.Bottom);

        // Set horizontal alignment of range B4:C4 to General
        sheet.getCellRange("B4:C4").getCellStyle().setHorizontalAlignment(HorizontalAlignType.General);

        // Set horizontal alignment of range B5:C5 to Left
        sheet.getCellRange("B5:C5").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Left);

        // Set horizontal alignment of range B6:C6 to Center
        sheet.getCellRange("B6:C6").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Center);

        // Set horizontal alignment of range B7:C7 to Right
        sheet.getCellRange("B7:C7").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Right);

        // Set rotation angle of range B8:C8 to 45 degrees
        sheet.getCellRange("B8:C8").getCellStyle().setRotation(45);
        // Set rotation angle of range B9:C9 to 90 degrees
        sheet.getCellRange("B9:C9").getCellStyle().setRotation(90);

        // Set row height of range B8:C9 to 60
        sheet.getCellRange("B8:C9").setRowHeight(60);

        // Save the modified workbook to a new file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
