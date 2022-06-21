import com.spire.xls.*;

public class editExcelComment {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/ReadComment.xls");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first comment.
        ExcelComment comment = sheet.getComments().get(0);

        //Edit the comment.
        comment.setText("This comment has been edited by Spire.XLS.");

        String result = "output/Result-EditExcelComment.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
