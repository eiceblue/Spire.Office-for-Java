import com.spire.xls.*;

public class addVariableArray {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set marker designer field in cell A1
        sheet.getCellRange("A1").setValue("&=Array");

        //Fill Array
        workbook.getMarkerDesigner().addParameter("Array", new String[] { "Spire.Xls", "Spire.Doc", "Spire.PDF", "Spire.Presentation", "Spire.Email" });
        workbook.getMarkerDesigner().apply();
        workbook.calculateAllValue();

        //AutoFit
        sheet.getAllocatedRange().autoFitRows();
        sheet.getAllocatedRange().autoFitColumns();

        //Save the document
        String output = "output/addVariableArray_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
