import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class pageSetup {
    public static void main(String[] args) throws Exception {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Set up the page margin using unit conversion
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a page to the PDF document with A4 size and specified margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
        page.setBackgroundColor(new Color(210, 105, 30));

        // Call the drawPage() method to draw the content on the page
        drawPage(page);

        // Repeat the process for additional pages with different backgrounds and setups
        page = doc.getPages().add(PdfPageSize.A4, margin);
        page.setBackgroundColor(new Color(255, 127, 80));
        drawPage(page);

        page = doc.getPages().add(PdfPageSize.A3, margin, PdfPageRotateAngle.Rotate_Angle_180, PdfPageOrientation.Landscape);
        page.setBackgroundColor(new Color(255, 182, 193));
        drawPage(page);

        // Create a section in the document
        PdfSection section = doc.getSections().add();

        // Add a page to the section with A4 size and specified margins
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        drawPage(page);

        page = section.getPages().add();
        page.setBackgroundColor(new Color(135, 206, 250));
        drawPage(page);

        // Create another section in the document with landscape orientation
        section = doc.getSections().add();
        section.getPageSettings().setOrientation(PdfPageOrientation.Landscape);
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        drawPage(page);

        // Add more pages to the section with different rotations and setups
        section = doc.getSections().add();
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_90);
        drawPage(page);

        section = doc.getSections().add();
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_180);
        drawPage(page);

        // Save the PDF document to a file
        doc.saveToFile("output/pageSetup.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    static void drawPage(PdfPageBase page) throws IOException {
        // Define the input file paths for the image and text file
        String inputFile_1 = "data/Wikipedia_Science.png";
        String inputFile_2 = "data/Summary_of_Science.txt";

        // Get the width of the page and initialize 'y' position
        float pageWidth = (float) page.getCanvas().getClientSize().getWidth();
        float y = 0;

        // Increase 'y' position by 5
        y = y + 5;

        // Set up brush, font, and format for drawing text
        PdfBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.black));
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);
        String text = "Summary of Science";

        // Draw the title at the center of the page
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);

        // Measure the size of the title and update 'y' position
        Dimension2D size = font2.measureString(text, format2);
        y = y + (float) size.getHeight() + 6;

        // Load the image from file and draw it on the page
        PdfImage image = PdfImage.fromFile(inputFile_1);
        page.getCanvas().drawImage(image, new Point2D.Float(pageWidth - (float) image.getPhysicalDimension().getWidth(), y));

        // Calculate the available space for the image and its bottom position
        float imageLeftSpace = pageWidth - (float) image.getPhysicalDimension().getWidth() - 2;
        float imageBottom = (float) image.getPhysicalDimension().getHeight() + y;

        // Set up fonts, brushes, and formats for drawing additional text
        PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);

        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";

        // Draw the first part of the source indication text
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);
        size = font3.measureString(text1, format3);
        float x1 = (float) size.getWidth();

        // Reset paragraph indent
        format3.setParagraphIndent(0);

        // Set up font and brush for drawing the 'Wikipedia' text
        PdfTrueTypeFont font4 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        PdfBrush brush3 = PdfBrushes.getBlue();

        // Draw the 'Wikipedia' text
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);
        size = font4.measureString(text2, format3);
        x1 = x1 + (float) size.getWidth();

        // Draw the last part of the source indication text
        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);

        // Update 'y' position
        y = y + (float) size.getHeight();

        // Set up format for drawing the main text content
        PdfStringFormat format4 = new PdfStringFormat();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile_2));
        String content = null;

        // Read the content from the text file and construct a string
        while ((content = br.readLine()) != null) {
            sb.append(content).append("\r\n");
        }
        text = sb.toString();

        // Set up font and format for the main text content
        PdfTrueTypeFont font5 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10));
        format4.setLineSpacing(font5.getSize() * 1.5f);

        // Create a layouter for laying out the text within a specific region on the page
        PdfStringLayouter textLayouter = new PdfStringLayouter();

        // Calculate the available height for the main text content
        float imageLeftBlockHeight = imageBottom - y;

        // Set up the dimension for the layout region
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(imageLeftSpace, imageLeftBlockHeight);

        // Layout the text within the specified region
        PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, dimension2D);

        // Check if the layout result fits within the available space
        if (result.getActualSize().getHeight() < imageBottom - y) {
            // Increase the available space by the line height and re-layout the text
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            Dimension2D dimension = new Dimension();
            dimension.setSize(imageLeftSpace, imageLeftBlockHeight);
            result = textLayouter.layout(text, font5, format4, dimension);
        }

        // Iterate through the lines of the layout result and draw them on the page, updating the 'y' position
        for (LineInfo line : result.getLines()) {
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }

        // Create a text widget for the remaining text and set up its format
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);

        // Set the bounds for the text widget and draw it on the page
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(new Point2D.Float(0, y), page.getCanvas().getClientSize());
        textWidget.setStringFormat(format4);
        textWidget.draw(page, bounds, textLayout);
    }
}
