import com.spire.xls.*;
import com.spire.xls.collections.CommentsCollection;

public class removeComment {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/ReadComment.xls");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get all comments in the sheet
        CommentsCollection comments = sheet.getComments();

        //Edit the the content of first comment.
        comments.get(0).setText("This comment has been edited by Spire.XLS.");
        //Remove the second comment.
        comments.get(1).remove();

        String result = "output/Result-removeComment.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
