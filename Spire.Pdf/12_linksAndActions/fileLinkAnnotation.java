import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class fileLinkAnnotation {
    public static void main(String[] args) throws Exception {
        // Set the output file path for the PDF document
        String output = "output/fileLinkAnnotation.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor to convert units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set the page margin settings
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.0f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a page to the document with specified size and margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Define a brush for text drawing
        PdfBrush brush1 = PdfBrushes.getBlack();

        // Define a font for the text
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 13), true);

        // Set the string format for text alignment
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Left);

        // Set the position for drawing
        float x = 0;
        float y = 50;

        // Set the specification string for the document
        String specification = "The sample demonstrates how to create a file link in PDF document.";

        // Draw the specification string on the page canvas
        page.getCanvas().drawString(specification, font1, brush1, x, y, format1);

        // Use MeasureString to get the height of the specification string
        y = y + (float) font1.measureString(specification, format1).getHeight() + 10;

        // Add the file link annotation to the page
        addFileLinkAnnotation(page, y);

        // Save the document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
	
    private static void addFileLinkAnnotation(PdfPageBase page, float y) {
		// Set the input file path for the linked file
		String input = "data/headerAndFooter.pdf";

		// Define a font for the text
		PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 12), true);

		// Define the string format for the text alignment
		PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

		// Set the prompt text string
		String prompt = "Launch a File: ";

		// Draw the prompt text string on the page canvas
		page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

		// Use MeasureString to get the width of the prompt string
		float x = (float) font.measureString(prompt, format).getWidth();

		// Set the label string for the file name
		String label = "Sample.pdf";

		// Use MeasureString to get the dimensions of the label string
		Dimension2D dimension2D = font.measureString(label);

		// Create a rectangle based on the dimensions of the label string
		Rectangle2D bounds = new Rectangle2D.Float(x, y, (float) dimension2D.getWidth(), (float) dimension2D.getHeight());

		// Draw the label string on the page canvas
		page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

		// Create a PdfFileLinkAnnotation with the specified bounds and linked file path
		PdfFileLinkAnnotation annotation = new PdfFileLinkAnnotation(bounds, input);

		// Set the color for the annotation
		annotation.setColor(new PdfRGBColor(Color.BLUE));

		// Add the annotation to the page's annotation collection
		page.getAnnotationsWidget().add(annotation);
	}
}
