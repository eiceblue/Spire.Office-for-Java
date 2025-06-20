import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class setLineBreak {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create one A4 page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(40));

        //Create brush from color channel
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        //Create text
        String text = "Spire.PDF for .NET" +
                "\n" +
                "A professional PDF library applied to" +
                " creating, writing, editing, handling and reading PDF files" +
                " without any external dependencies within .NET" +
                "( C#, VB.NET, ASP.NET, .NET Core) application.";
        text += "\n\rSpire.PDF for Java" +
                "\n" +
                "A PDF Java API that enables developers to read, " +
                "write, convert and print PDF documents" +
                "in Java applications without using Adobe Acrobat.";
        text += "\n\r";
        text += "Welcome to evaluate Spire.PDF!";

        //Create rectangle with specified dimensions
        Rectangle rect = new Rectangle(50, 50, (int)page.getSize().getWidth() - 150, (int)page.getSize().getHeight());

        //Draw the text
        page.getCanvas().drawString(text, new PdfFont(PdfFontFamily.Helvetica, 13f), brush, rect);

        // Output file path to save the modified document
        String result = "output/setLineBreak.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
