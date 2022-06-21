import com.spire.xls.*;

public class applyBuiltInStyles {
    public static void main(String[] args) throws Exception {
        String input = "data/SampleB_2.xlsx";
        String output = "output/applyBuiltInStyles.xlsx";

        //load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //apply title style
        sheet.getCellRange("A1:J1").setBuiltInStyle( BuiltInStyles.Title);

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2010);
    }
}
