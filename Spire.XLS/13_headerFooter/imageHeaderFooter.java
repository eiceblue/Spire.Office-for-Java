import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class imageHeaderFooter {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/headerFooterSample.xlsx";
        String outputFile = "output/imageHeaderFooter_result.xlsx";
        String imageFile = "data/logo.png";

        //Load a Workbook from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Load an image from disk
        BufferedImage image = ImageIO.read( new File(imageFile));

        //Set the image header
        sheet.getPageSetup().setLeftHeaderImage(image);
        sheet.getPageSetup().setLeftHeader("&G");

        //Set the image footer
        sheet.getPageSetup().setCenterFooterImage(image);
        sheet.getPageSetup().setCenterFooter("&G");

        //Set the view mode of the sheet
        sheet.setViewMode(ViewMode.Layout);

        //Save the Excel file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
