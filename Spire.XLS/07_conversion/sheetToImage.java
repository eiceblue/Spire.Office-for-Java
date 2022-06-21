import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class sheetToImage {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/ExcelSampleN.xlsx";
        String outputFile="output/SheetToImage.png";

        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Save the sheet to image
        BufferedImage bufferedImage = sheet.toImage(sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());
        ImageIO.write(bufferedImage,"PNG",new File(outputFile));
    }
}
