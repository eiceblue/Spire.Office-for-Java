import com.spire.xls.*;

public class insertImageInWPSCell {
    public static void main(String[] args) {

        String inputImage = "data/Logo.png";
        String output = "output/insertImageInWPSCell.xlsx";

        //Create a new instance of Workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Embed an image into cell B1
        sheet.getCellRange("B1").insertOrUpdateCellImage(inputImage,true);

        //Save the workbook to the specified output file path in Excel 2010 format
        workbook.saveToFile(output, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
