import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Point2D;

public class splitAPageIntoMultipage {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String input = "data/JavaPDFSample_2.pdf";
        String output = "output/splitAPageIntoMultipage_out.pdf";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create a new PDF document
        PdfDocument newPdf = new PdfDocument();

        // Set margins for the new document's pages
        newPdf.getPageSettings().getMargins().setAll(0);

        // Set the width and height of the new document's pages to match the original page
        newPdf.getPageSettings().setWidth((float) page.getSize().getWidth());
        newPdf.getPageSettings().setHeight((float) page.getSize().getWidth() / 2);

        // Add a new page to the new document
        PdfPageBase newPage = newPdf.getPages().add();

        // Configure text layout settings for drawing the original page onto the new page
        PdfTextLayout format = new PdfTextLayout();
        format.setBreak(PdfLayoutBreakType.Fit_Page);
        format.setLayout(PdfLayoutType.Paginate);

        // Draw the original page onto the new page using a template
        page.createTemplate().draw(newPage, new Point2D.Float(0, 0), format);

        // Save the modified document to the specified output file
        newPdf.saveToFile(output);

        // Close both the input and output documents
        doc.close();
        newPdf.close();

        // Dispose of the PDF documents to free up system resources
        doc.dispose();
        newPdf.dispose();
    }
}
