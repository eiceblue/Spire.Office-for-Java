import com.spire.xls.*;

public class hideOrUnhideShape {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_5.xlsx";
        String output = "output/hideOrUnhideShape.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //hide the second shape in the worksheet
        sheet.getPrstGeomShapes().get(1).setVisible( false);

        //show the second shape in the worksheet
        //sheet.getPrstGeomShapes().get(1).setVisible(true);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
