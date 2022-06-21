import com.spire.xls.*;

public class setCommentTextRotation {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/CellValues.xlsx");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create font
        ExcelFont font = workbook.createFont();
        font.setFontName("Arial");
        font.setSize(11);
        font.setKnownColor(ExcelColors.Orange);

        CellRange range = sheet.getCellRange("E1");
        range.getComment().setText("This is a comment");
        range.getComment().getRichText().setFont(0, (range.getComment().getText().length() - 1), font);

        // Set its vertical and horizontal alignment
        range.getComment().setVAlignment(CommentVAlignType.Center);
        range.getComment().setHAlignment(CommentHAlignType.Left);

        //Set the comment text rotation
        range.getComment().setTextRotation(TextRotationType.LeftToRight);

        //Save to a file
        workbook.saveToFile("output/setCommentTextRotation.xlsx", ExcelVersion.Version2013);
    }
}
