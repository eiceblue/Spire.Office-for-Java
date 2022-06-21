import com.spire.xls.*;
import com.spire.xls.core.ISpinnerShape;

public class addSpinnerControl {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ExcelSample_N1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set text for range C11
        sheet.getCellRange("C11").setText("Value:");
        sheet.getCellRange("C11").getStyle().getFont().isBold(true);

        //Set value for range B10
        sheet.getCellRange("C12").setNumberValue(0);

        //Add spinner control
        ISpinnerShape spinner = sheet.getSpinnerShapes().addSpinner(12, 4, 20, 20);
        spinner.setLinkedCell(sheet.getCellRange("C12"));
        spinner.setMin(0);
        spinner.setMax(100);
        spinner.setIncrementalChange(5);
        spinner.setDisplay3DShading(true);

        //Save the document
        String output = "output/addSpinnerControl_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
