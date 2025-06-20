import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.util.EnumSet;

public class replaceWithRegularExpression {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF file from disk
        pdf.loadFromFile("data/template_az.pdf");

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Create an instance of PdfTextReplacer to replace text
        PdfTextReplacer replacer = new PdfTextReplacer(page);

        // Set the replace type to Regex
        PdfTextReplaceOptions options = new PdfTextReplaceOptions();
        options.setReplaceType(EnumSet.of(ReplaceActionType.Regex));

        // Set the replace options
        replacer.setOptions(options);

        // Specify the regular expression
        String regularExpression ="\\bP\\w*F\\b";

        // Replace all target text matching the regular expression with new text
        replacer.replaceAllText(regularExpression,"DOC" );

        // Save the modified document to a file
        pdf.saveToFile("output/out.pdf", com.spire.pdf.FileFormat.PDF);

        // Close the PDF document
        pdf.close();
    }
}
