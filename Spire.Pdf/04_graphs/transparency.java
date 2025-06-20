import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.*;
import java.awt.*;

public class transparency {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a section to the document
        PdfSection section = doc.getSections().add();

        // Load the image from a file
        PdfImage image = PdfImage.fromFile("data/chartImage.png");

        // Calculate the dimensions of the image
        double imageWidth = image.getPhysicalDimension().getWidth() / 2;
        double imageHeight = image.getPhysicalDimension().getHeight() / 2;

        // Get all available blend modes
        PdfBlendMode[] modes= PdfBlendMode.values();

        // Iterate over each blend mode
        for (PdfBlendMode loMode : modes) {
            // Add a new page to the section
            PdfPageBase page = section.getPages().add();

            // Get the width of the page canvas
            float pageWidth = (float) page.getCanvas().getClientSize().getWidth();

            // Set the initial y-coordinate position
            float y = 10;
            y = y + 5;

            // Create a brush for drawing text
            PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(new Color(255, 69, 0)));

            // Create a font for the text
            PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 12));

            // Set the format for the text alignment
            PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);

            // Generate the text to display on the page
            String text = String.format("Transparency Blend Mode: %1$s", loMode);

            // Draw the text on the page
            page.getCanvas().drawString(text, font, brush, pageWidth / 2, y, format);

            // Measure the size of the drawn text
            Dimension2D size = font.measureString(text, format);

            // Update the y-coordinate position
            y = y + (float) size.getHeight() + 6;

            // Draw the image on the page
            page.getCanvas().drawImage(image, 0, y, imageWidth, imageHeight);

            // Save the current canvas state
            page.getCanvas().save();

            // Calculate the distance between each image
            float d = (float) (page.getCanvas().getClientSize().getWidth() - imageWidth) / 5;

            // Set the initial x and y coordinates for drawing images
            float x = d;
            y = y + d / 2;

            // Draw multiple images with varying transparency levels
            for (int i = 0; i < 5; i++) {
                // Calculate the alpha (transparency) value
                float alpha = 1.0f / 6 * (5 - i);

                // Set the transparency blend mode
                page.getCanvas().setTransparency(alpha, alpha, loMode);

                // Draw the image on the page with the specified transparency
                page.getCanvas().drawImage(image, x, y, imageWidth, imageHeight);

                // Update the x and y coordinates for the next image
                x = x + d;
                y = y + d / 2;
            }

            // Restore the previous canvas state
            page.getCanvas().restore();
        }

        // Save the PDF document to a file
        doc.saveToFile("output/transparency.pdf");
		
        // Close the PDF document
        doc.close();
		
        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
