import com.spire.xls.*;

public class writeComment {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/WriteComment.xlsx");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Create font
        ExcelFont font = workbook.createFont();
        font.setFontName("Arial");
        font.setSize(11);
        font.setKnownColor(ExcelColors.Orange);
        ExcelFont fontBlue = workbook.createFont();
        fontBlue.setKnownColor(ExcelColors.LightBlue);
        ExcelFont fontGreen = workbook.createFont();
        fontGreen.setKnownColor(ExcelColors.LightGreen);
        //Specify the cell range for regular comment
        CellRange range = sheet.getCellRange("B11");
        range.setText("Regular comment");
        range.getComment().setText("Regular comment");
        range.autoFitColumns();
        //Specify the cell range for rich text comment
        range = sheet.getCellRange("B12");
        range.setText("Rich text comment");
        range.getRichText().setFont(0, 16, font);
        range.autoFitColumns();
        //Set font color for rich text comment
        range.getComment().getRichText().setText("Rich text comment");
        range.getComment().getRichText().setFont(0, 4, fontGreen);
        range.getComment().getRichText().setFont(5, 9, fontBlue);
        //Save to a file
        workbook.saveToFile("output/WriteComment_result.xlsx", ExcelVersion.Version2013);
    }
}
