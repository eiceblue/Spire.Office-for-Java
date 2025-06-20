import com.spire.pdf.*;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class template {
    public static void main(String[] args) throws Exception {
        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Set the page layout of the document to "Two_Column_Left"
        doc.getViewerPreferences().setPageLayout(PdfPageLayout.Two_Column_Left);

        // Initialize a PdfUnitConvertor to convert measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set the margin values for the document using PdfMargins
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Set up the document template using setDocumentTemplate()
        setDocumentTemplate(doc, PdfPageSize.A4, margin);

        // Create a new section in the document
        PdfSection section = doc.getSections().add();

        // Customize the section's page settings
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(new PdfMargins(0));

        // Set up the section template using setSectionTemplate()
        setSectionTemplate(section, PdfPageSize.A4, margin, "Section 1");

        // Add multiple pages to the section and draw content on each page using drawPage()
        PdfNewPage page = section.getPages().add();
        drawPage(page);

        page = section.getPages().add();
        drawPage(page);

        page = section.getPages().add();
        drawPage(page);

        page = section.getPages().add();
        drawPage(page);

        // Save the document to a file named "output/template.pdf"
        doc.saveToFile("output/template.pdf");

        // Close the document and release associated resources
        doc.close();
        doc.dispose();
    }

    static void setSectionTemplate(PdfSection section, java.awt.geom.Dimension2D pageSize, PdfMargins margin, String label) {
        // Create an odd left space template element with the specified width and full page height.
        PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
        leftSpace.setForeground(true);
        section.getTemplate().setOddLeft(leftSpace);

        // Define font, format, and bounds for the label in the odd left space template.
        Font loFont = new Font("Arial", Font.ITALIC, 9);
        PdfTrueTypeFont font = new PdfTrueTypeFont(loFont);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        float y = (float) (pageSize.getHeight() - margin.getTop() - margin.getBottom()) * (1 - 0.618f);
        Rectangle2D bounds = new Rectangle2D.Double(10, y, margin.getLeft() - 20, font.getHeight() + 6);

        // Draw a rectangle and the label text on the odd left space template.
        leftSpace.getGraphics().drawRectangle(PdfBrushes.getOrangeRed(), bounds);
        leftSpace.getGraphics().drawString(label, font, PdfBrushes.getWhite(), bounds, format);

        // Create an even right space template element with the specified width and full page height.
        PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
        rightSpace.setForeground(true);
        section.getTemplate().setEvenRight(rightSpace);

        // Update bounds for the label in the even right space template.
        bounds = new Rectangle2D.Double(10, y, margin.getRight() - 20, font.getHeight() + 6);

        // Draw a rectangle and the label text on the even right space template.
        rightSpace.getGraphics().drawRectangle(PdfBrushes.getSaddleBrown(), bounds);
        rightSpace.getGraphics().drawString(label, font, PdfBrushes.getWhite(), bounds, format);
    }

    static void setDocumentTemplate(PdfDocument doc, java.awt.geom.Dimension2D pageSize, PdfMargins margin) {
        // Create a left space template element with the specified width and full page height.
        PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
        doc.getTemplate().setLeft(leftSpace);

        // Create a top space template element with the full page width and the specified height.
        // Set it as foreground to ensure it appears on top of other elements.
        PdfPageTemplateElement topSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getTop());
        topSpace.setForeground(true);
        doc.getTemplate().setTop(topSpace);

        // Define font, format, and label for the header.
        Font loFont = new Font("Arial", Font.ITALIC, 9);
        PdfTrueTypeFont font = new PdfTrueTypeFont(loFont);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        String label = "Demo of Spire.Pdf";
        java.awt.geom.Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(font.measureString(label, format));
        float y = topSpace.getHeight() - font.getHeight() - 1;
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.75f);

        // Set transparency and draw a horizontal line on the top space template.
        topSpace.getGraphics().setTransparency(0.5f);
        topSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);

        // Calculate Y coordinate and draw the label text on the top space template aligned to the right.
        y = y - 1 - (float) dimension2D.getHeight();
        topSpace.getGraphics().drawString(label, font, PdfBrushes.getBlack(), pageSize.getWidth() - margin.getRight(), y, format);

        // Create a right space template element with the specified width and full page height.
        PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
        doc.getTemplate().setRight(rightSpace);

        // Create a bottom space template element with the full page width and the specified height.
        // Set it as foreground to ensure it appears on top of other elements.
        PdfPageTemplateElement bottomSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getBottom());
        bottomSpace.setForeground(true);
        doc.getTemplate().setBottom(bottomSpace);

        // Calculate Y coordinate for drawing the line and page number label on the bottom space template.
        y = font.getHeight() + 1;

        // Set transparency and draw a horizontal line on the bottom space template.
        bottomSpace.getGraphics().setTransparency(0.5f);
        bottomSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);
        y = y + 1;

        // Set up page number label fields and draw the label on the bottom space template.
        PdfPageNumberField pageNumber = new PdfPageNumberField();
        PdfPageCountField pageCount = new PdfPageCountField();
        PdfCompositeField pageNumberLabel = new PdfCompositeField();
        pageNumberLabel.setAutomaticFields(new PdfAutomaticField[]{pageNumber, pageCount});
        pageNumberLabel.setBrush(PdfBrushes.getBlack());
        pageNumberLabel.setFont(font);
        pageNumberLabel.setStringFormat(format);
        pageNumberLabel.setText("page {0} of {1}");
        pageNumberLabel.draw(bottomSpace.getGraphics(), pageSize.getWidth() - margin.getRight()-50, y);

        // Load and create a header image template element from the specified file.
        String inputFile1 = "data/header.png";
        PdfImage headerImage = PdfImage.fromFile(inputFile1);
        Point2D pageLeftTop = new Point2D.Double(-margin.getLeft(), -margin.getTop());
        PdfPageTemplateElement header = new PdfPageTemplateElement(pageLeftTop, headerImage.getPhysicalDimension());
        header.setForeground(false);

        // Set transparency and draw the header image on the template.
        header.getGraphics().setTransparency(0.5f);
        header.getGraphics().drawImage(headerImage, 0, 0);

        // Add the header template element as a stamp on the document template.
        doc.getTemplate().getStamps().add(header);

        // Load and create a footer image template element from the specified file.
        String inputFile2 = "data/footer.png";
        PdfImage footerImage = PdfImage.fromFile(inputFile2);
        y = (float) (pageSize.getHeight() - footerImage.getPhysicalDimension().getHeight());
        Point2D footerLocation = new Point2D.Double(-margin.getLeft(), y);
        PdfPageTemplateElement footer = new PdfPageTemplateElement(footerLocation, footerImage.getPhysicalDimension());
        footer.setForeground(false);
        // Set transparency and draw the footer image on the template.
        footer.getGraphics().setTransparency(0.5f);
        footer.getGraphics().drawImage(footerImage, 0, 0);
        // Add the footer template element as a stamp on the document template.
        doc.getTemplate().getStamps().add(footer);
    }
    static void drawPage(PdfPageBase page) throws IOException{
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
