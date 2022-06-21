import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class readImages {

    public static void main(String[] args)  throws IOException {
        //Create a Workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ReadImages.xlsx");

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first image
        ExcelPicture pic = sheet.getPictures().get(0);
        BufferedImage loImage = pic.getPicture();
        ImageIO.write(loImage,"png",new File("output/ReadImages.png"));
    }
}
