import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class addTransparentText {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Create one A4 page with no margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(0));

        // Save the current canvas state
        page.getCanvas().save();

        // Set alpha value for transparency
        float alpha = 0.25f;

        // Set transparency
        page.getCanvas().setTransparency(alpha, alpha, PdfBlendMode.Normal);

        // Create a rectangle with specified dimensions
        Rectangle rect = new Rectangle(50, 50, 450, (int) page.getSize().getHeight());

        // Create transparent text
        String text = "Spire.PDF for .NET, a professional PDF library applied to" +
                "creating, writing, editing, handling and reading PDF files" +
                "without any external dependencies within .NET" +
                "(C#, VB.NET, ASP.NET, .NET Core) application.";
        text += "\n\n\n\n\n";
        text += "Spire.PDF for Java, a PDF Java API that enables" +
                "developers to read, write, convert and print PDF documents" +
                "in Java applications without using Adobe Acrobat.";

        // Create a brush from color channel
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(30, 0, 255, 0));

        // Draw the text on the specified rectangle with the given font and brush
        page.getCanvas().drawString(text, new PdfFont(PdfFontFamily.Helvetica, 14f), brush, rect);

        // Restore the previously saved canvas state
        page.getCanvas().restore();

        // Specify the output file path
        String result = "output/addTransparentText.pdf";

        // Save the document to the specified file path in PDF format
        doc.saveToFile(result, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
