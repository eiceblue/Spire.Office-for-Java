import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class imageHeaderFooter {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/headerFooterSample.xlsx";
        String outputFile = "output/imageHeaderFooter_result.xlsx";
        String imageFile = "data/logo.png";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from a specified path
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create an Image object from a specified image file
        BufferedImage image = ImageIO.read( new File(imageFile));

        // Set the left header image and text for the page setup
        sheet.getPageSetup().setLeftHeaderImage(image);
        sheet.getPageSetup().setLeftHeader("&G");

        // Set the center footer image and text for the page setup
        sheet.getPageSetup().setCenterFooterImage(image);
        sheet.getPageSetup().setCenterFooter("&G");

        // Set the view mode of the sheet to Layout
        sheet.setViewMode(ViewMode.Layout);

        // Save the modified workbook to a specified path with Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
