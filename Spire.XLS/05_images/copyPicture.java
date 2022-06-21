import com.spire.xls.*;

import java.awt.image.BufferedImage;

public class copyPicture {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/ReadImages.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //Add a new worksheet as destination sheet
        Worksheet destinationSheet = workbook.getWorksheets().add("DestSheet");

        //Get the first picture from the first worksheet
        ExcelPicture sourcePicture = sheet1.getPictures().get(0);

        //Get the image
        BufferedImage image = sourcePicture.getPicture();

        //Add the image into the added worksheet
        destinationSheet.getPictures().add(2,2,image);

        //String for output file
        String outputFile = "output/copyPicture.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

    }
}
