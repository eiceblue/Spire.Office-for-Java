import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class rotateNewPDF {
    public static void main(String[] args) {
        // Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor to convert measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create an instance of PdfMargins to set the margins of the document
        PdfMargins margin = new PdfMargins();

        // Set the top margin using the converted value from centimeters to points
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin using the converted value from centimeters to points
        margin.setLeft(unitCvtr.convertUnits(2.0f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Add a new section to the document
        PdfSection section = doc.getSections().add();

        // Set the page size of the section to A4
        section.getPageSettings().setSize(PdfPageSize.A4);

        // Set the margins of the section
        section.getPageSettings().setMargins(margin);

        // Set the rotation angle of the section to 90 degrees (clockwise rotation)
        section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_90);

        // Add a new page to the section
        PdfPageBase page = section.getPages().add();

        // Set up the brush, font, and string format for drawing on the page
        PdfBrush brush = PdfBrushes.getBlack();
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 13), true);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        // Set the coordinates for text drawing
        float x = 0;
        float y = 50;

        // Set the specification for the sample
        String specification = "The sample demonstrates how to rotate a page when creating a PDF document.";

        // Draw the specification text on the page
        page.getCanvas().drawString(specification, font, brush, x, y, format);

        // Specify the output file path
        String result = "output/rotateNewPDF_out.pdf";

        // Save the PDF document to the specified output file location
        doc.saveToFile(result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
