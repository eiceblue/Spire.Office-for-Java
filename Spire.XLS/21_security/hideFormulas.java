import com.spire.xls.*;

public class hideFormulas {
    public static void main(String[] args)throws Exception {
        String input = "data/FormulasSample.xlsx";
        String output = "output/hideFormulas.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Hide formulas in the allocated range of the worksheet
        sheet.getAllocatedRange().isFormulaHidden(true);

        // Protect the worksheet with a password "e-iceblue"
        sheet.protect("e-iceblue");

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
