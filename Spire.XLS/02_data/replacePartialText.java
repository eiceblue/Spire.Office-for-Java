import com.spire.xls.*;

public class replacePartialText {
    public static void main(String[] args) {
        //create a new workbook
        Workbook workbook = new Workbook();

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //set text value
        sheet.getRange().get("A1").setText("Hello World");
        sheet.getRange().get("A1").autoFitColumns();

        //replace partial Text
        sheet.getCellList().get(0).textPartReplace("World","Spire");

        //save
        workbook.saveToFile("output/replaced.xlsx");
        workbook.dispose();
    }
}
