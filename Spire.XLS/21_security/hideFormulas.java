import com.spire.xls.*;

public class hideFormulas {
    public static void main(String[] args)throws Exception {
        String input = "data/FormulasSample.xlsx";
        String output = "output/hideFormulas.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //hide the formulas in the used range
        sheet.getAllocatedRange().isFormulaHidden(true);

        //protect the worksheet with password
        sheet.protect("e-iceblue");

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
