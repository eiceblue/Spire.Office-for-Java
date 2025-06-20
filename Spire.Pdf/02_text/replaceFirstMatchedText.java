import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.util.EnumSet;

public class replaceFirstMatchedText {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF file from disk
        pdf.loadFromFile("data/ReplaceFirstMatched.pdf");

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Create an instance of PdfTextReplacer to replace text
        PdfTextReplacer replacer = new PdfTextReplacer(page);

        // Set the replace options
        PdfTextReplaceOptions options = new PdfTextReplaceOptions();
        options.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));

        // Replace the text in the document
        replacer.replaceText("Spire.PDF for Java", "Spire.PDF API");

        // Save the modified document to a file
        pdf.saveToFile("output/ReplaceFirstMatched_out.pdf", FileFormat.PDF);

        // Close the PDF document
        pdf.close();
    }
}
