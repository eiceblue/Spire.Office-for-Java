import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class addImageToFirstPageHeaderFooter {
    public static void main(String[] args) throws Exception {
        // Create a new workbook
        Workbook workbook = new Workbook();

        // Load a Workbook from disk
        workbook.loadFromFile("data/AddImageToFirstPageHeaderFooter.xlsx");

        // Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getPageSetup().setDifferentFirst( (byte)1);

        // Load an image from disk
        File imageFile = new File("data/Logo.png");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        // Set the image header
        sheet.getPageSetup().setFirstLeftHeaderImage(bufferedImage);
        sheet.getPageSetup().setFirstCenterHeaderImage(bufferedImage);
        sheet.getPageSetup().setFirstRightHeaderImage(bufferedImage);

        // Set the image footer
        sheet.getPageSetup().setFirstLeftFooterImage(bufferedImage);
        sheet.getPageSetup().setFirstCenterFooterImage(bufferedImage);
        sheet.getPageSetup().setFirstRightFooterImage(bufferedImage);

        // Set the view mode of the sheet
        sheet.setViewMode(ViewMode.Layout);

        // Specify the file name for the resulting Excel file
        String result = "output/Output_AddImageHeaderFooterToFirstPage.xlsx";

        // Save the workbook to the specified file in Excel 2016 format
        workbook.saveToFile(result, ExcelVersion.Version2016);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
