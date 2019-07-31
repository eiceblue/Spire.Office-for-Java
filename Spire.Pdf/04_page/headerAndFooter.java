import java.awt.*;
import java.awt.geom.*;
import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

public class headerAndFooter {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/headerAndFooter.pdf");
        PdfBrush brush = PdfBrushes.getBlack();
        PdfPen pen = new PdfPen(brush, 0.75f);
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 9), true);
        PdfStringFormat rightAlign = new PdfStringFormat(PdfTextAlignment.Right);
        PdfStringFormat leftAlign = new PdfStringFormat(PdfTextAlignment.Left);
        rightAlign.setMeasureTrailingSpaces(false);
        PdfMargins margin = doc.getPageSettings().getMargins();

        float space = font.getHeight() * 0.75f;
        float x = 0;
        float y = 0;
        float width = 0;

        //Create a new pdf document
        PdfDocument newPdf = new PdfDocument();
        PdfPageBase newPage;

        for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {
            //Add new page
            newPage = newPdf.getPages().add(page.getSize(), new PdfMargins(0));

            newPage.getCanvas().setTransparency(0.5f);
            x = margin.getLeft();
            width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
            y = margin.getTop() - space;

            //Draw header line
            newPage.getCanvas().drawLine(pen, x, y + 15, x + width, y + 15);
            y = y + 10 - font.getHeight();

            //Draw header image into newPage
            newPage.getCanvas().setTransparency(0.5f);
            PdfImage headerImage = PdfImage.fromFile("data/Header.png");
            newPage.getCanvas().drawImage(headerImage, new Point2D.Float(0, 0));

            //Draw header text into newPage
            newPage.getCanvas().drawString("Demo of Spire.Pdf", font, brush, x + width, y, rightAlign);

            //Draw footer image into newPage
            PdfImage footerImage = PdfImage.fromFile("data/Footer.png");
            newPage.getCanvas().drawImage(footerImage, new Point2D.Float(0, (float) (newPage.getCanvas().getClientSize().getHeight() - footerImage.getPhysicalDimension().getHeight())));

            brush = PdfBrushes.getDarkBlue();
            font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 12), true);
            y = (float)( newPage.getCanvas().getClientSize().getHeight() - margin.getBottom() - font.getHeight());

            //Draw footer text into newPage
            newPage.getCanvas().drawString("Created by E-iceblue Co,.Ltd", font, brush, x, y, leftAlign);

            newPage.getCanvas().setTransparency(1);

            //Draw the page into newPage
            page.createTemplate().draw(newPage.getCanvas(), new Point2D.Float(0, 0));
        }

        //Save the document
        newPdf.saveToFile("output/headerAndFooter.pdf");
        newPdf.close();
    }
}