import com.spire.xls.*;

public class detectVBAMacros {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the document from disk
        workbook.loadFromFile("data/macroSample.xls");

        // Detect if the Excel file contains VBA macros
        boolean hasMacros = workbook.hasMacros();
        if (hasMacros) {
            System.out.println("This Excel document contains VBA macros.");
        } else {
            System.out.println("This Excel document doesn't contain VBA macros.");
        }
    }
}
