import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class getEmbeddedImages {
    public static void main(String[] args) throws IOException {

        // Define the output directory path
        String outputFile = "output/";

        // Create a new Workbook object
        Workbook wb = new Workbook();

        // Load the Excel file "EmbedImageViaWps.xlsx" from the "data" directory
        wb.loadFromFile("data/EmbedImageViaWps.xlsx");

        // Access the first worksheet in the workbook
        Worksheet sheet = wb.getWorksheets().get(0);

        // Get an array of ExcelPicture objects representing cell images in the worksheet
        ExcelPicture[] pc = sheet.getCellImages();

        // Iterate through each ExcelPicture object in the array
        for (int i = 0; i < pc.length; i++) {
            ExcelPicture ep = pc[i];

            // Get the BufferedImage of the ExcelPicture
            BufferedImage image = ep.getPicture();

            // Write the image to a PNG file in the output directory
            ImageIO.write(image, "PNG", new File(outputFile + String.format("result_%d.png", i)));
        }

        // Dispose of the workbook object
        wb.dispose();
    }
}
