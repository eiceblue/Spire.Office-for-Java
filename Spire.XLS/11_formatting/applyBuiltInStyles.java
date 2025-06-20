import com.spire.xls.*;

public class applyBuiltInStyles {
    public static void main(String[] args) throws Exception {
        String input = "data/SampleB_2.xlsx";
        String output = "output/applyBuiltInStyles.xlsx";

        //Create a new instance of Workbook
        Workbook workbook = new Workbook();
        //Load the workbook from the specified file path
        workbook.loadFromFile(input);

        //Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the built-in style "Title" for the range A1:J1 in the worksheet
        sheet.getCellRange("A1:J1").setBuiltInStyle( BuiltInStyles.Title);

        //Save the workbook to the specified output file path in Excel 2010 format
        workbook.saveToFile(output, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
