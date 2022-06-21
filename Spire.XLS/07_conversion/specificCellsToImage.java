import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class specificCellsToImage {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/ConversionSample1.xlsx";
        String outputFile="output/specificCellsToImage.png";

        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Specify Cell Ranges and save to image formats
        BufferedImage bufferedImage = sheet.toImage(1, 1, 7, 5);
        ImageIO.write(bufferedImage,"PNG",new File(outputFile));
    }
}
