import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class inlineImageAndPageNumber {
    public static void main(String[] args) {
       // Input and output file paths
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/Top-logo.png";
        String output = "output/inlineImageAndPageNumber.pdf";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Set the text and image to be added
        String text1 = "Spire.Pdf is a robust component by";
        String text2 = "E-iceblue Technology Co., Ltd.";
        PdfImage image = PdfImage.fromFile(input2);

        // Set the font and brush for the text
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Impact", Font.PLAIN, 10));
        PdfBrush brush = PdfBrushes.getDarkGray();

        // Measure the dimensions of the text
        Dimension2D s1 = font.measureString(text1);
        Dimension2D s2 = font.measureString(text2);

        // Set the initial position for drawing
        float x = 10;
        float y = 10;

        // Calculate the size of the image
        Dimension2D imgSize = new Dimension(image.getWidth() / 2, image.getHeight() / 2);

        // Set the size of the rectangle for text1
        Dimension2D size = new Dimension();
        size.setSize(s1.getWidth(), imgSize.getWidth());
        Rectangle2D rect1 = new Rectangle2D.Float();
        rect1.setFrame(new Point2D.Float(x, y), size);

        // Define the string format for text alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

        // Draw text1 onto the page
        page.getCanvas().drawString(text1, font, brush, rect1, format);

        // Update the position for drawing
        x += s1.getWidth();

        // Draw the image onto the page
        page.getCanvas().drawImage(image, new Point2D.Float(x, y), imgSize);

        // Update the position for drawing
        x += imgSize.getWidth();

        // Set the size of the rectangle for text2
        size.setSize(s2.getWidth(), imgSize.getHeight());
        rect1.setFrame(new Point2D.Float(x, y), size);

        // Draw text2 onto the page
        page.getCanvas().drawString(text2, font, brush, rect1, format);

        // Save the modified PDF document to the output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
