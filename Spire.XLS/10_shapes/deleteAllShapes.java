import com.spire.xls.*;

public class deleteAllShapes {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_5.xlsx";
        String output = "output/deleteAllShapes.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //delete all shapes in the worksheet
        for (int i = sheet.getPrstGeomShapes().getCount()-1; i >= 0; i--)
        {
            sheet.getPrstGeomShapes().get(i).remove();
        }
        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
