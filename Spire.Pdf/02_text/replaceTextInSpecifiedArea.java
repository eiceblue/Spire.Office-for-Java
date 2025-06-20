import com.spire.pdf.*;
import com.spire.pdf.texts.*;

import java.awt.geom.Rectangle2D;
import java.util.EnumSet;

public class replaceTextInSpecifiedArea {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF file from disk
        pdf.loadFromFile("data/template_az.pdf");

        // Get all pages of the document
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            PdfPageBase page = pdf.getPages().get(i);

            // Create an instance of PdfTextReplacer to replace text
            PdfTextReplacer replacer = new PdfTextReplacer(page);

            // Set the replacement area for the text replacer
            replacer.getOptions().setReplacementArea(new Rectangle2D.Float(10, 0, 841, 150));

            // Specify the type of replacement to be performed
            replacer.getOptions().setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));

            // Replace the text in the document
            replacer.replaceAllText("PDF", "Doc");
        }

        // Save the modified document to a file
        pdf.saveToFile("output/replaceTextInSpecifiedArea_out.pdf", com.spire.pdf.FileFormat.PDF);

        // Close the PDF document
        pdf.close();
    }
}
