import com.spire.xls.*;

public class hideOrShowComment {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/CommentSample.xlsx");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Hide the second comment
        sheet.getComments().get(1).isVisible(false);

        //Show the third comment
        sheet.getComments().get(2).isVisible(true);

        String result = "output/Result-hideOrShowComment.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
