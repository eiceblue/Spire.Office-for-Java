import com.spire.xls.*;

public class textAlign {
    public static void main(String[] args) {
        String inputFile="data/textAlign.xlsx";
        String outputFile = "output/textAlign_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the vertical alignment to Top
        sheet.getCellRange("B1:C1").getCellStyle().setVerticalAlignment(VerticalAlignType.Top);

        //Set the vertical alignment to Center
        sheet.getCellRange("B2:C2").getCellStyle().setVerticalAlignment(VerticalAlignType.Center);

        //Set the vertical alignment to Bottom
        sheet.getCellRange("B3:C3").getCellStyle().setVerticalAlignment(VerticalAlignType.Bottom);

        //Set the horizontal alignment to General
        sheet.getCellRange("B4:C4").getCellStyle().setHorizontalAlignment(HorizontalAlignType.General);

        //Set the horizontal alignment to Left
        sheet.getCellRange("B5:C5").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Left);

        //Set the horizontal alignment to Center
        sheet.getCellRange("B6:C6").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Center);

        //Set the horizontal alignment to Right
        sheet.getCellRange("B7:C7").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Right);

        //Set the rotation degree
        sheet.getCellRange("B8:C8").getCellStyle().setRotation(45);

        sheet.getCellRange("B9:C9").getCellStyle().setRotation(90);

        //Set the row height of cell
        sheet.getCellRange("B8:C9").setRowHeight(60);

        //Save the result file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
