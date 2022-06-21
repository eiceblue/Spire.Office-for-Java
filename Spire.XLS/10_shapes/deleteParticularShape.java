import com.spire.xls.*;

public class deleteParticularShape {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_5.xlsx";
        String output = "output/deleteParticularShape.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //delete the first shape in the worksheet
        sheet.getPrstGeomShapes().get(0).remove();

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
