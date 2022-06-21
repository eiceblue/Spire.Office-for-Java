import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

public class insertWebImage {

    public static void main(String[] args) throws IOException
    {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the image
        URL url = new URL("https://www.e-iceblue.com/downloads/demo/SpireXls.png");
        BufferedImage bufferedImage = ImageIO.read(url);

        sheet.getPictures().add(3,2, bufferedImage );

        //String for output file
        String outputFile = "output/insertWebImage.xlsx";
        
        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

    }

}
