import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;

public class createPdfLinkAnnotation {
    public static void main(String[] args) {
		// Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Specify the rectangle and file path for the file link annotation
        Rectangle2D rect = new Rectangle2D.Double(0, 40, 250, 35);
        String filePath = "data/template_az.pdf";

        // Create a file link annotation based on the specified parameters and add it to the page
        PdfFileLinkAnnotation link = new PdfFileLinkAnnotation(rect, filePath);
        ((PdfNewPage) page).getAnnotations().add(link);

        // Create a free text annotation based on the same rectangle and set its content
        PdfFreeTextAnnotation text = new PdfFreeTextAnnotation(rect);
        text.setText("Click here! This is a link annotation.");
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 15);
        text.setFont(font);
        ((PdfNewPage) page).getAnnotations().add(text);

        // Set the file path for saving the document
        String result = "output/createPdfLinkAnnotation_out.pdf";

        // Save the document
        doc.saveToFile(result);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
