import com.spire.xls.*;

public class getCellDisplayedText {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get first worksheet of the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set value for B8
        CellRange cell = sheet.getRange().get("B8");
        cell.setNumberValue(0.012345);

        //Set the cell style
        CellStyle style = cell.getCellStyle();
        style.setNumberFormat("0.00");

        //Get the cell value
        String cellValue = cell.getValue();

        //Get the displayed text of the cell
        String displayedText = cell.getDisplayedText();

        //Create StringBuilder to save
        StringBuilder content = new StringBuilder();

        //Set string format for displaying
        String result = String.format("B8 Value: " + cellValue + "\r\nB8 displayed text: " + displayedText);

        //Add result string to StringBuilder
        content.append(result);
        System.out.println(result);
    }
}
