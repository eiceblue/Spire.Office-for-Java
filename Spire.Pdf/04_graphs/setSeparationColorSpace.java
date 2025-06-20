import java.awt.*;
import com.spire.pdf.*;
import com.spire.pdf.colorspace.*;
import com.spire.pdf.graphics.*;


public class setSeparationColorSpace {

    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the PDF document
        PdfPageBase page = pdf.getPages().add();

        // Create a PdfRGBColor object representing cyan color
        PdfRGBColor c = new PdfRGBColor(Color.CYAN);

        // Create color spaces for RGB
        PdfSeparationColorSpace rgb = new PdfSeparationColorSpace("MySpotColor", new PdfRGBColor(c.getR(), c.getG(), c.getB()));
        
        // Create color spaces CMYK
        //PdfSeparationColorSpace cmyk = new PdfSeparationColorSpace("MySpotColor", new PdfRGBColor(c.getC(), c.getM(), c.getY(), c.getK()));

        // Create color spaces for grayscale
        //PdfSeparationColorSpace grayscale = new PdfSeparationColorSpace("MySpotColor", new PdfRGBColor(c.getGray()));

        // Set tint value for the separation color space
        PdfSeparationColor color = new PdfSeparationColor(rgb, 1f);

        // Create a PdfSolidBrush object with the separation color
        PdfSolidBrush brush = new PdfSolidBrush(color);

        // Draw a pie shape on the canvas using the specified brush
        page.getCanvas().drawPie(brush, 10, 30, 60, 60, 360, 360);

        // Draw a text string indicating the tint value
        page.getCanvas().drawString("Tint=1.0", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point(22, 100));

        // Update the separation color and brush for the next step
        color = new PdfSeparationColor(rgb, 0.5f);
        brush = new PdfSolidBrush(color);

        // Draw a second pie shape with a different tint value
        page.getCanvas().drawPie(brush, 80, 30, 60, 60, 360, 360);

        // Draw a text string indicating the tint value
        page.getCanvas().drawString("Tint=0.5", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point(92, 100));

        // Update the separation color and brush for the next step
        color = new PdfSeparationColor(rgb, 0.25f);
        brush = new PdfSolidBrush(color);

        // Draw a third pie shape with a different tint value
        page.getCanvas().drawPie(brush, 150, 30, 60, 60, 360, 360);

        // Draw a text string indicating the tint value
        page.getCanvas().drawString("Tint=0.25", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point(162, 100));

        // Save the modified PDF document to a file
        String output = "output.pdf";
        pdf.saveToFile(output);
        
        // Close the PDF document
        pdf.close();
        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
