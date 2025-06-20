import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.util.EnumSet;

public class replaceAllMatchedText {
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

            // Set the replace options
            PdfTextReplaceOptions options = new PdfTextReplaceOptions();
            options.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));
            options.setReplaceType(EnumSet.of(ReplaceActionType.IgnoreCase));

            // Replace the text in the document
            replacer.replaceAllText("PDF", "DOC");
        }

        // Save the modified document to a file
        pdf.saveToFile("output/out.pdf", com.spire.pdf.FileFormat.PDF);

        // Close the PDF document
        pdf.close();
    }
}
