import com.spire.xls.*;

public class alignPictureWithinCell {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getRange().get("A1").setText("Align Picture Within A Cell:");
        sheet.getRange().get("A1").getStyle().setVerticalAlignment( VerticalAlignType.Top);

        //Insert an image to the specific cell.
        ExcelPicture picture = sheet.getPictures().add(1, 1, "data/SpireXls.png");

        //Adjust the column width and row height so that the cell can contain the picture.
        sheet.setColumnWidth(1,40);
        sheet.setRowHeight(1,200);

        //Vertically and horizontally align the image.
        picture.setLeftColumnOffset(100);
        picture.setTopRowOffset(25);

        //Save the result file
        workbook.saveToFile("output/alignPictureWithinCell.xlsx", ExcelVersion.Version2010);

    }
}
