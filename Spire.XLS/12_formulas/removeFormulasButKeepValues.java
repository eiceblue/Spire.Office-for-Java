import com.spire.xls.*;

public class removeFormulasButKeepValues {
    public static void main(String[] args) {
        String inputFile = "data/removeFormulasButKeepValues.xlsx";
        String outputFile="output/removeFormulasButKeepValues_result.xlsx";

        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from an input file
        workbook.loadFromFile(inputFile);

        // Iterate over each worksheet in the workbook
        for (Worksheet sheet : (Iterable<Worksheet>) workbook.getWorksheets())
        {
            // Iterate over each cell range in the worksheet
            for (CellRange cell : (Iterable<CellRange>) sheet.getRange())
            {
                // Check if the cell contains a formula
                if (cell.hasFormula())
                {
                    // Get the value of the formula
                    Object value = cell.getFormulaValue();

                    // Clear the cell's content
                    cell.clear(ExcelClearOptions.ClearContent);

                    // Set the cell's value to the string representation of the formula value
                    cell.setValue(value.toString());
                }
            }
        }

        // Save the modified workbook to an output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
