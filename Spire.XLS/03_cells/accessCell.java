import com.spire.xls.*;

public class accessCell {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/AccessCell.xlsx");

        StringBuilder builder = new StringBuilder();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Access cell by its name
        CellRange range1 = sheet.getRange().get("A1");
        builder.append("Value of range1: " + range1.getText()+"\n");

        //Access cell by index of row and column
        CellRange range2 = sheet.getRange().get(2,1);
        builder.append("Value of range2: " + range2.getText()+"\n");

        //Access cell in cell collection
        CellRange range3 = sheet.getCells()[2];
        builder.append("Value of range3: " + range3.getText()+"\n");

        System.out.println(builder);
    }
}
