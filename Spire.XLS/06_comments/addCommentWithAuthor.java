import com.spire.xls.*;

public class addCommentWithAuthor {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Specify the cell range for regular comment
        CellRange range = sheet.getCellRange("C1");


        //Set the author and comment content
        String author = "E-iceblue";
        String text = "This is demo to show how to add a comment with editable Author property.";

        //Add comment to the range and set properties
        ExcelComment comment = range.addComment();
        comment.setWidth(200);
        comment.setVisible(true);
        comment.setText(author + "\r" + text);

        //Set the font of the author
        ExcelFont font = workbook.createFont();
        font.setFontName("Tahoma");
        font.setKnownColor(ExcelColors.Black);
        font.isBold(true);
        comment.getRichText().setFont(0, author.length(),font);

        //Save to a file
        workbook.saveToFile("output/addCommentWithAuthor.xlsx", ExcelVersion.Version2013);
    }
}
