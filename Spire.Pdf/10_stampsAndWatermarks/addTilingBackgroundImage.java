import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addTilingBackgroundImage {
    public static void main(String[] args) {
        // Define the input file paths
        String input1 = "data/stamp.pdf";
        String input2 = "data/E-iceblueLogo.png";

        // Define the output file path
        String output = "output/addTilingBackgroundImage.pdf";

        // Load the PDF document from the first input file
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input1);

        // Load the background image from the second input file
        PdfImage image = PdfImage.fromFile(input2);

        // Iterate through each page of the PDF document
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            // Get the current page
            PdfPageBase page = pdf.getPages().get(i);

            // Calculate the dimensions for the tiling brush based on the page canvas size
            Dimension2D dimension2D = new Dimension();
            dimension2D.setSize(page.getCanvas().getSize().getWidth() / 3, page.getCanvas().getSize().getHeight() / 5);

            // Create a tiling brush with the calculated dimensions
            PdfTilingBrush brush = new PdfTilingBrush(dimension2D);

            // Set the transparency of the brush graphics to 0.3
            brush.getGraphics().setTransparency(0.3F);

            // Draw the background image onto the brush graphics at the center
            brush.getGraphics().drawImage(image, new Point2D.Double((brush.getSize().getWidth() - image.getWidth()) / 2, (brush.getSize().getHeight() - image.getHeight()) / 2));

            // Create a rectangle with the same size as the page canvas
            Rectangle2D loRect = new Rectangle2D.Float();
            loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getSize());

            // Draw the rectangle onto the page canvas using the tiling brush as the background
            page.getCanvas().drawRectangle(brush, loRect);
        }

        // Save the modified PDF document to the specified output file
        pdf.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
