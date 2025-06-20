import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class transition {
    public static void main(String[] args) throws Exception {
        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Set the page mode of the document to "Full_Screen"
        doc.getViewerPreferences().setPageMode(PdfPageMode.Full_Screen);

        // Initialize a PdfUnitConvertor to convert measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set the margin values for the document using PdfMargins
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Create a new section in the document
        PdfSection section = doc.getSections().add();

        // Customize the section's page settings
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);

        // Set up transition effects for the section's page settings
        section.getPageSettings().setTransition(new PdfPageTransition());
        section.getPageSettings().getTransition().setDuration(2);
        section.getPageSettings().getTransition().setStyle(PdfTransitionStyle.Fly);
        section.getPageSettings().getTransition().setPageDuration(1);

        // Add pages to the section and draw content on each page
        PdfNewPage page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(Color.RED);

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(0, 128, 0));

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(Color.BLUE);

        // Create a new section in the document
        section = doc.getSections().add();

        // Customize the section's page settings
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);

        // Set up transition effects for the section's page settings
        section.getPageSettings().setTransition(new PdfPageTransition());
        section.getPageSettings().getTransition().setDuration(2);
        section.getPageSettings().getTransition().setStyle(PdfTransitionStyle.Box);
        section.getPageSettings().getTransition().setPageDuration(1);

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(255, 165, 0));

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(165, 42, 42));

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(0, 0, 128));

        // Create a new section in the document
        section = doc.getSections().add();

        // Customize the section's page settings
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);

        // Set up transition effects for the section's page settings
        section.getPageSettings().setTransition(new PdfPageTransition());
        section.getPageSettings().getTransition().setDuration(2);
        section.getPageSettings().getTransition().setStyle(PdfTransitionStyle.Split);
        section.getPageSettings().getTransition().setDimension(PdfTransitionDimension.Vertical);
        section.getPageSettings().getTransition().setMotion(PdfTransitionMotion.Inward);
        section.getPageSettings().getTransition().setPageDuration(1);

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(255, 165, 0));

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(165, 42, 42));

        page = section.getPages().add();
        drawPage(page);
        page.setBackgroundColor(new Color(0, 0, 128));

        // Save the document to a file named "output/transition.pdf"
        String output = "output/transition.pdf";
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document and release associated resources
        doc.close();
        doc.dispose();
    }

    static void drawPage(PdfPageBase page) throws IOException {
        // Input file paths
        String inputFile_1 = "data/wikipedia_Science.png";
        String inputFile_2 = "data/summary_of_Science.txt";

        // Get the width of the page canvas and initialize the starting Y coordinate
        float pageWidth = (float) page.getCanvas().getClientSize().getWidth();
        float y = 0;

        // Set up brushes, fonts, and formats for drawing the title text
        y = y + 5;
        PdfBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.black));
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);

        // Draw the title text at the center of the page
        String text = "Summary of Science";
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);
        Dimension2D size = font2.measureString(text, format2);

        // Adjust the Y coordinate based on the title height and spacing
        y = y + (float) size.getHeight() + 6;

        // Load and draw an image on the page
        PdfImage image = PdfImage.fromFile(inputFile_1);
        page.getCanvas().drawImage(image, new Point2D.Float(pageWidth - (float) image.getPhysicalDimension().getWidth(), y));
        float imageLeftSpace = pageWidth - (float) image.getPhysicalDimension().getWidth() - 2;
        float imageBottom = (float) image.getPhysicalDimension().getHeight() + y;

        // Set up fonts, formats, and text for drawing additional text elements
        PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";

        // Draw the additional text elements on the page
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);
        size = font3.measureString(text1, format3);
        float x1 = (float) size.getWidth();
        format3.setParagraphIndent(0);
        PdfTrueTypeFont font4 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        PdfBrush brush3 = PdfBrushes.getBlue();
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);
        size = font4.measureString(text2, format3);
        x1 = x1 + (float) size.getWidth();
        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);
        y = y + (float) size.getHeight();

        // Set up formats and read the content from the text file into a string buffer
        PdfStringFormat format4 = new PdfStringFormat();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile_2));
        String content = null;
        while ((content = br.readLine()) != null) {
            sb.append(content).append("\r\n");
        }
        text = sb.toString();

        // Set up fonts and formats for text layout
        PdfTrueTypeFont font5 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10));
        format4.setLineSpacing(font5.getSize() * 1.5f);
        PdfStringLayouter textLayouter = new PdfStringLayouter();
        float imageLeftBlockHeight = imageBottom - y;
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(imageLeftSpace, imageLeftBlockHeight);

        // Layout the text within the available space and handle pagination if necessary
        PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, dimension2D);
        if (result.getActualSize().getHeight() < imageBottom - y) {
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            Dimension2D dimension = new Dimension();
            dimension.setSize(imageLeftSpace, imageLeftBlockHeight);
            result = textLayouter.layout(text, font5, format4, dimension);
        }
        // Draw the lines of laid-out text on the page
        for (LineInfo line : result.getLines()) {
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }

        // Create a text widget for the remaining text and set layout options
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(new Point2D.Float(0, y), page.getCanvas().getClientSize());
        textWidget.setStringFormat(format4);

        // Draw the remaining text widget on the page
        textWidget.draw(page, bounds, textLayout);
    }
}
