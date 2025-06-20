import com.spire.xls.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class addWatermark {
    public static void main(String[] args) {
            String inputFile = "data/addWatermark.xlsx";
            String outputFile = "output/addWatermark_result.xlsx";

            // Create a new workbook object
            Workbook workbook = new Workbook();

            // Load an existing workbook from a file
            workbook.loadFromFile(inputFile);

            // Define the font and watermark text
            Font font = new Font("Arial", Font.PLAIN, 40);
            String watermark = "Confidential";

            //  Loop through each worksheet in the workbook
            for (Worksheet sheet : (Iterable<Worksheet>) workbook.getWorksheets()) {
                // Draw the watermark image
                BufferedImage imgWtrmrk = drawText(watermark, font, Color.pink, Color.white, sheet.getPageSetup().getPageHeight(), sheet.getPageSetup().getPageWidth());

                // Set the watermark image as the left header image
                sheet.getPageSetup().setLeftHeaderImage(imgWtrmrk);

                //  Set the left header to display the page number
                sheet.getPageSetup().setLeftHeader("&G");

                //  The watermark will only appear in this mode, it will disappear if the mode is normal
                sheet.setViewMode(ViewMode.Layout);
            }

            // Save the modified workbook to a new file
            workbook.saveToFile(outputFile, ExcelVersion.Version2010);

            // Release the resources used by the workbook
            workbook.dispose();
        }

        private static BufferedImage drawText (String text, Font font, Color textColor, Color backColor,double height, double width)
        {
            // Create a new bitmap image with specified width and height
            BufferedImage img = new BufferedImage((int) width, (int) height, TYPE_INT_ARGB);

            // Create a Graphics object from the image
            Graphics2D loGraphic = img.createGraphics();

            //  Measure the size of the text using the specified font
            FontMetrics loFontMetrics = loGraphic.getFontMetrics(font);
            int liStrWidth = loFontMetrics.stringWidth(text);
            int liStrHeight = loFontMetrics.getHeight();

            // Set rotation point
            loGraphic.setColor(backColor);
            loGraphic.fillRect(0, 0, (int) width, (int) height);
            loGraphic.translate(((int) width - liStrWidth) / 2, ((int) height - liStrHeight) / 2);

            // Rotate the drawing surface by -45 degrees
            loGraphic.rotate(Math.toRadians(-45));

            // Translate the drawing origin back to its original position
            loGraphic.translate(-((int) width - liStrWidth) / 2, -((int) height - liStrHeight) / 2);

            loGraphic.setFont(font);

            // Create a brush for the text
            loGraphic.setColor(textColor);

            // Draw text on the image at center position
            loGraphic.drawString(text, ((int) width - liStrWidth) / 2, ((int) height - liStrHeight) / 2);

            loGraphic.dispose();
            // Return the resulting image with the watermark
            return img;
        }
}
