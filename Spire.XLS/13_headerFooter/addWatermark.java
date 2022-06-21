import com.spire.xls.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class addWatermark {
    public static void main(String[] args) {
            String inputFile = "data/addWatermark.xlsx";
            String outputFile = "output/addWatermark_result.xlsx";

            //Create a Workbook
            Workbook workbook = new Workbook();

            //Load Excel from disk
            workbook.loadFromFile(inputFile);

            //Insert an image in a header to mimic a watermark
            Font font = new Font("Arial", Font.PLAIN, 40);
            String watermark = "Confidential";

            for (Worksheet sheet : (Iterable<Worksheet>) workbook.getWorksheets()) {
                //Call DrawText() to create an image
                BufferedImage imgWtrmrk = drawText(watermark, font, Color.pink, Color.white, sheet.getPageSetup().getPageHeight(), sheet.getPageSetup().getPageWidth());

                //Set the image as left header image
                sheet.getPageSetup().setLeftHeaderImage(imgWtrmrk);
                sheet.getPageSetup().setLeftHeader("&G");

                //The watermark will only appear in this mode, it will disappear if the mode is normal
                sheet.setViewMode(ViewMode.Layout);
            }

            //Save the Excel file
            workbook.saveToFile(outputFile, ExcelVersion.Version2010);
        }

        private static BufferedImage drawText (String text, Font font, Color textColor, Color backColor,double height, double width)
        {
            //Create a bitmap image with specified width and height
            BufferedImage img = new BufferedImage((int) width, (int) height, TYPE_INT_ARGB);
            Graphics2D loGraphic = img.createGraphics();

            //Get the size of text
            FontMetrics loFontMetrics = loGraphic.getFontMetrics(font);
            int liStrWidth = loFontMetrics.stringWidth(text);
            int liStrHeight = loFontMetrics.getHeight();

            //Set rotation point
            loGraphic.setColor(backColor);
            loGraphic.fillRect(0, 0, (int) width, (int) height);
            loGraphic.translate(((int) width - liStrWidth) / 2, ((int) height - liStrHeight) / 2);

            //Rotate text
            loGraphic.rotate(Math.toRadians(-45));

            //Reset translate transform
            loGraphic.translate(-((int) width - liStrWidth) / 2, -((int) height - liStrHeight) / 2);

            loGraphic.setFont(font);

            //Create a brush for the text
            loGraphic.setColor(textColor);

            //Draw text on the image at center position
            loGraphic.drawString(text, ((int) width - liStrWidth) / 2, ((int) height - liStrHeight) / 2);
            loGraphic.dispose();
            return img;
        }
}
