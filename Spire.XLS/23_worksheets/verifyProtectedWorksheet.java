import com.spire.xls.*;

public class verifyProtectedWorksheet {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified path
        workbook.loadFromFile("data/protectedWorksheet.xlsx");

        // Get the first worksheet from the Workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Check if the first worksheet is password protected
        boolean detect = worksheet.isPasswordProtected();

        // Print the result indicating whether the first worksheet is password protected or not
        System.out.println("The first worksheet is password protected or not: " + (detect == true ? "Yes!" : "No!"));

        // Release any resources used by the Workbook object
        workbook.dispose();
    }
}
