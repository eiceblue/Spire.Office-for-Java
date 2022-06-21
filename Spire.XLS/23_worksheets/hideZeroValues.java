import com.spire.xls.*;

public class hideZeroValues {
    public static void main(String[] args) throws Exception {
        String input = "data/sampleB_2.xlsx";
        String output = "output/hideZeroValues.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //set false to hide the zero values in sheet
        sheet.isDisplayZeros(false);

        //save the file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
