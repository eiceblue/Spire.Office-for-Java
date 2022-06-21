import com.spire.xls.*;

public class croppedPositionOfPicture {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/ReadImages.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);


        //Get the first picture from the first worksheet
        ExcelPicture Picture = sheet1.getPictures().get(0);

        //Get the cropped position
        int left = Picture.getLeft();
        int top = Picture.getTop();
        int width = Picture.getWidth();
        int height = Picture.getHeight();

        System.out.println("Crop position: Left " + left);
        System.out.println("Crop position: Top " + top);
        System.out.println("Crop position: Width " + width);
        System.out.println("Crop position: Height " + height);

    }
}
