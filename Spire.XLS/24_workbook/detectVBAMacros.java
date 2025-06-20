import com.spire.xls.*;

public class detectVBAMacros {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified path
        workbook.loadFromFile("data/macroSample.xls");

        // Check if the workbook contains VBA macros
        boolean hasMacros = workbook.hasMacros();

        // If the workbook contains macros
        if (hasMacros) {
            // Print a message indicating that the Excel document contains VBA macros
            System.out.println("This Excel document contains VBA macros.");
        } else {
            // Print a message indicating that the Excel document doesn't contain VBA macros
            System.out.println("This Excel document doesn't contain VBA macros.");
        }

        // Clean up and release any resources used by the workbook
        workbook.dispose();
    }
}
