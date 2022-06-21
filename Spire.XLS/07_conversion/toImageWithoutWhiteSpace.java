import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class toImageWithoutWhiteSpace {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/ExcelSampleN.xlsx";
        String outputFile="output/toImageWithoutWhiteSpace.png";

        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the margin as 0 to remove the white space around the image
        sheet.getPageSetup().setLeftMargin(0);
        sheet.getPageSetup().setTopMargin(0);
        sheet.getPageSetup().setRightMargin(0);
        sheet.getPageSetup().setBottomMargin(0);

        //Save the sheet to image
        BufferedImage bufferedImage = sheet.toImage(sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());
        ImageIO.write(bufferedImage,"PNG",new File(outputFile));
    }
}
