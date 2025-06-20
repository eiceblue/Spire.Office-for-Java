import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.io.*;

public class textToPDF {
    public static void main(String[] args) throws IOException {
        // Input and output file paths
        String input = "data/TextToPdf.txt";
        String output = "output/textToPdf_out.pdf";

        // Read text from the input file
        String text = readTextFromFile(input);

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a section to the document
        PdfSection section = doc.getSections().add();

        // Add a page to the section
        PdfPageBase page = section.getPages().add();

        // Specify the font for the text
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 11);

        // Set the line spacing for the text layout
        PdfStringFormat format = new PdfStringFormat();
        format.setLineSpacing(20f);

        // Set the brush color for the text
        PdfBrush brush = PdfBrushes.getBlack();

        // Configure the text layout to fit within the page and paginate the content
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);

        // Define the bounds of the text widget on the page
        Rectangle2D.Float bounds = new Rectangle2D.Float();
        bounds.setRect(10, 20, page.getCanvas().getClientSize().getWidth(), page.getCanvas().getClientSize().getHeight());

        // Create a new text widget with the specified text, font, and brush
        PdfTextWidget textWidget = new PdfTextWidget(text, font, brush);
        textWidget.setStringFormat(format);

        // Draw the text widget on the page within the specified bounds using the given layout
        textWidget.draw(page, bounds, textLayout);

        // Save the document to the specified output file path in PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
	
    public static String readTextFromFile(String fileName) throws IOException {
        // Create a new instance of StringBuffer to store the content
        StringBuffer sb = new StringBuffer();

        // Create a BufferedReader object to read the file line by line
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String content = null;

        // Read each line from the file until there are no more lines
        while ((content = br.readLine()) != null) {
            // Append the line to the StringBuffer
            sb.append(content);
        }

        // Return the string representation of the accumulated content
        return sb.toString();
    }
}
