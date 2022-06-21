import com.spire.xls.*;

public class removeFormulasButKeepValues {
    public static void main(String[] args) {
        String inputFile = "data/removeFormulasButKeepValues.xlsx";
        String outputFile="output/removeFormulasButKeepValues_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Loop through worksheets.
        for (Worksheet sheet : (Iterable<Worksheet>) workbook.getWorksheets())
        {
            //Loop through cells.
            for (CellRange cell : (Iterable<CellRange>) sheet.getRange())
            {
                //If the cell contain formula, get the formula value, clear cell content, and then fill the formula value into the cell.
                if (cell.hasFormula())
                {
                    Object value = cell.getFormulaValue();
                    cell.clear(ExcelClearOptions.ClearContent);
                    cell.setValue(value.toString());
                }
            }
        }

        //Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
