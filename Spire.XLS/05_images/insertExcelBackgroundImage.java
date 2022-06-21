
import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class insertExcelBackgroundImage {

    public static void main(String[] args) throws IOException
    {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/ReadImages.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //Set the image to be background image of the worksheet.
        BufferedImage bufferedImage = ImageIO.read(new File("data/Background.png"));
        sheet1.getPageSetup().setBackgoundImage(bufferedImage);

        //String for output file
        String outputFile = "output/insertExcelBackgroundImage.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

    }
}
