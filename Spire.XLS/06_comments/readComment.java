import com.spire.xls.*;

public class readComment {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/ReadComment.xls");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Print out the comment
        System.out.println("A1 Comment = " + sheet.getCellRange("A1").getComment().getText());
        System.out.println("A2 Comment = " + sheet.getCellRange("A2").getComment().getRichText().getRtfText());
    }
}
