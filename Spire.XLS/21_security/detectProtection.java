import com.spire.xls.*;

public class detectProtection {
    public static void main(String[] args) {
        // Load the document from disk
        String input = "data/protectedWorkbook.xlsx";
        // Detect if the Excel workbook is password protected
        boolean value = Workbook.bookIsPasswordProtected(input);

        if (value) {
            System.out.println("This excel workbook is password protected.");
        } else {
            System.out.println("This excel workbook is not password protected.");
        }
    }
}
