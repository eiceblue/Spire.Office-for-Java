import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.utilities.PdfImageHelper;
import com.spire.pdf.utilities.PdfImageInfo;
import java.awt.*;
import java.awt.geom.*;

public class replaceImageWithText {
    public static void main(String[] args)throws Exception {
      // Specify the input PDF file path
        String input = "data/DeleteImage.pdf";

        // Specify the output PDF file path for the modified document
        String output = "output/replaceImageWithText.pdf";

        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file path
        doc.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Get information about the images present on the page
        PdfImageHelper imageHelper = new PdfImageHelper();
        PdfImageInfo[] imageInfo = imageHelper.getImagesInfo(page);

        // Retrieve the width and height of the first image in pixels
        float widthInPixel = imageInfo[0].getImage().getWidth();
        float heightInPixel = imageInfo[0].getImage().getHeight();

        // Convert the width and height from pixel units to points
        PdfUnitConvertor convertor = new PdfUnitConvertor();
        float width = convertor.convertUnits(widthInPixel, PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
        float height = convertor.convertUnits(heightInPixel, PdfGraphicsUnit.Pixel,PdfGraphicsUnit.Point);

        // Get the location (x, y) of the first image's bounding box
        float xPos = (float) imageInfo[0].getBounds().getX();
        float yPos = (float) imageInfo[0].getBounds().getY();

        // Delete the first image from the page
        imageHelper.deleteImage(imageInfo[0]);

        // Create a rectangle using the image's location and size
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(width, height);
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(xPos, yPos), dimension2D);

        // Specify the format for the replacement text
        PdfStringFormat format = new PdfStringFormat();
        format.setAlignment(PdfTextAlignment.Center);
        format.setLineAlignment(PdfVerticalAlignment.Middle);

        // Draw the replacement text on the page's canvas within the specified rectangle
        page.getCanvas().drawString("ReplacedText", new PdfFont(PdfFontFamily.Helvetica, 18f), PdfBrushes.getDeepSkyBlue(), rect, format);

        // Save the modified PDF document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
