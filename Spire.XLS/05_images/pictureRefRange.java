import com.spire.xls.*;

public class pictureRefRange {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/PictureRefRange.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getCellRange("A1").setValue("Spire.XLS");
        sheet.getCellRange("B3").setValue("E-iceblue");

        //Get the first picture in worksheet
        ExcelPicture picture = sheet.getPictures().get(0);

        //Set the referenced range of the picture to A1:B3
        picture.setRefRange("A1:B3");

        //Save the Excel file
        String result = "output/PictureRefRange_out.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
