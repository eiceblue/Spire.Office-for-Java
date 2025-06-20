import com.spire.pdf.*;
import com.spire.pdf.colorspace.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Point2D;

public class drawContentWithSpotColor {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = pdf.getPages().add();

        // Define RGB color values for spot color
        PdfRGBColor pdfRGBColor = new PdfRGBColor(148, 0, 211);

        // Initialize an instance of PdfSeparationColorSpace with the spot color
        PdfSeparationColorSpace cs = new PdfSeparationColorSpace("MySpotColor", pdfRGBColor);

        // Set tint value to 1 for the color space
        PdfSeparationColor color = new PdfSeparationColor(cs, 1f);

        // Create a PdfSolidBrush with the defined color
        PdfSolidBrush brush = new PdfSolidBrush(color);

        // Draw text "Tint=1.0" on the page at specific coordinates using the brush and font
        page.getCanvas().drawString("Tint=1.0", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(160, 160));

        // Draw a pie shape on the page using the brush and other parameters
        page.getCanvas().drawPie(brush, 148, 200, 60, 60, 360, 360);

        // Draw text "Tint=0.7" on the page at specific coordinates using the updated brush and font
        page.getCanvas().drawString("Tint=0.7", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(230, 160));

        // Update the color using the same color space and tint value 0.7
        color = new PdfSeparationColor(cs, 0.7f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 218, 200, 60, 60, 360, 360);

        // Draw text "Tint=0.4" on the page at specific coordinates using the updated brush and font
        page.getCanvas().drawString("Tint=0.4", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(300, 160));

        // Update the color using the same color space and tint value 0.4
        color = new PdfSeparationColor(cs, 0.4f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 288, 200, 60, 60, 360, 360);

        // Draw text "Tint=0.1" on the page at specific coordinates using the updated brush and font
        page.getCanvas().drawString("Tint=0.1", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(370, 160));

        // Update the RGB color values for the spot color
        pdfRGBColor = new PdfRGBColor(128, 0, 128);


        // Update the PdfSeparationColorSpace with the new RGB color values
        cs = new PdfSeparationColorSpace("MySpotColor", pdfRGBColor);

        // Update the color using the new color space and tint value 1
        color = new PdfSeparationColor(cs, 1f);

        // Update the brush with the new color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 148, 280, 60, 60, 360, 360);

        // Update the color using the same color space and tint value 0.7
        color = new PdfSeparationColor(cs, 0.7f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 218, 280, 60, 60, 360, 360);

        // Update the color using the same color space and tint value 0.4
        color = new PdfSeparationColor(cs, 0.4f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 288, 280, 60, 60, 360, 360);

        // Update the color using the same color space and tint value 0.1
        color = new PdfSeparationColor(cs, 0.1f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 358, 280, 60, 60, 360, 360);

        // Update the RGB color values for the spot color to a new set of values (72, 61, 139)
        pdfRGBColor = new PdfRGBColor(72, 61, 139);


        // Update the PdfSeparationColorSpace with the new RGB color values
        cs = new PdfSeparationColorSpace("MySpotColor", pdfRGBColor);

        // Update the color using the new color space and tint value 1
        color = new PdfSeparationColor(cs, 1f);

        // Update the brush with the new color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 148, 360, 60, 60, 360, 360);

        // Update the color using the same color space and tint value 0.7
        color = new PdfSeparationColor(cs, 0.7f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 218, 360, 60, 60, 360, 360);

        // Update the color using the same color space and tint value 0.4
        color = new PdfSeparationColor(cs, 0.4f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 288, 360, 60, 60, 360, 360);

        // Update the color using the same color space and tint value 0.1
        color = new PdfSeparationColor(cs, 0.1f);

        // Update the brush with the updated color
        brush = new PdfSolidBrush(color);

        // Draw a pie shape on the page using the updated brush and parameters
        page.getCanvas().drawPie(brush, 358, 360, 60, 60, 360, 360);

        //Save the document
        pdf.saveToFile("output/drawContentWithSpotColor.pdf");

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
