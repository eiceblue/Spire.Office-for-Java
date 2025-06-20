import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.interchange.taggedpdf.*;
import java.awt.*;
import java.awt.geom.*;

public class createTaggedPDF {
    public static void main(String[] args) {
        String outputPath = "output/";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        doc.getPages().add();

        // Set the tab order of the first page to "Structure"
        doc.getPages().get(0).setTabOrder(TabOrder.Structure);

        // Create a PdfTaggedContent object and set the language and title
        PdfTaggedContent taggedContent = new PdfTaggedContent(doc);
        taggedContent.setLanguage("en-US");
        taggedContent.setTitle("test");

        // Define a TrueType font and solid brush for text rendering
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Times New Roman", Font.PLAIN, 12), true);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        // Create structure elements for the document, paragraphs, and spans
        PdfStructureElement article = taggedContent.getStructureTreeRoot().appendChildElement(PdfStandardStructTypes.Document);
        PdfStructureElement paragraph1 = article.appendChildElement(PdfStandardStructTypes.Paragraph);
        PdfStructureElement span1 = paragraph1.appendChildElement(PdfStandardStructTypes.Span);

        // Begin marked content for span1
        span1.beginMarkedContent(doc.getPages().get(0));

        // Define a string format for text alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Justify);

        // Draw the first text on the page canvas within a specified rectangle using the defined font, brush, and format
        doc.getPages().get(0).getCanvas().drawString("Spire.PDF for Java is a professional PDF API applied to creating, writing, editing, handling, and reading PDF files.",
                font, brush, new Rectangle(40, 0, 480, 80), format);

        // End marked content for span1
        span1.endMarkedContent(doc.getPages().get(0));

        // Create another paragraph and begin marked content
        PdfStructureElement paragraph2 = article.appendChildElement(PdfStandardStructTypes.Paragraph);
        paragraph2.beginMarkedContent(doc.getPages().get(0));

        // Draw the second text on the page canvas within a specified rectangle using the defined font, brush, and format
        doc.getPages().get(0).getCanvas().drawString("Spire.PDF for Java can be applied to easily convert Text, Image, SVG, HTML to PDF and convert PDF to Excel in high quality.",
                font, brush, new Rectangle(40, 80, 480, 60), format);

        // End marked content for paragraph2
        paragraph2.endMarkedContent(doc.getPages().get(0));

        // Add a figure element and draw an image on the page canvas
        PdfStructureElement figure1 = article.appendChildElement(PdfStandardStructTypes.Figure);
        figure1.setAlt("replacement text1");
        figure1.beginMarkedContent(doc.getPages().get(0), null);

        // Draw an image on the page canvas at a specific location using the specified dimension
        PdfImage image = PdfImage.fromFile("E-logo.png");
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(100, 100);
        doc.getPages().get(0).getCanvas().drawImage(image, new Point2D.Float(40, 200), dimension2D);

        // End marked content for figure1
        figure1.endMarkedContent(doc.getPages().get(0));
        // Add another figure element and draw a rectangle on the page canvas
        PdfStructureElement figure2 = article.appendChildElement(PdfStandardStructTypes.Figure);
        figure2.setAlt("replacement text2");
        figure2.beginMarkedContent(doc.getPages().get(0), null);

        // Draw a rectangle on the page canvas using PdfPens and a specified rectangle
        doc.getPages().get(0).getCanvas().drawRectangle(PdfPens.getBlack(), new Rectangle(300, 200, 100, 100));

        // End marked content for figure2
        figure2.endMarkedContent(doc.getPages().get(0));

        // Specify the output filename for the generated PDF
        String result = "CreateTaggedFile_result.pdf";

        // Save the document to the specified output path
        doc.saveToFile(outputPath + result);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
