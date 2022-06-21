import com.spire.xls.*;

public class resetSizeAndPositionForImage {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add an image to the specific cell
        ExcelPicture picture = sheet.getPictures().add(2, 2,"data/SpireXls.png");

        //Set the size for the picture.
        picture.setWidth(200);
        picture.setHeight(200);

        //Set the position for the picture.
        picture.setLeft(200);
        picture.setTop(200);

        //Save the result file
        workbook.saveToFile("output/resetSizeAndPositionForImage.xlsx", ExcelVersion.Version2010);

    }
}
