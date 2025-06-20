import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class getFontInfoOfSearchedText {
    public static void main(String[] args) {
        // Create a new PdfDocument instance
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from a file
        pdf.loadFromFile("data/findText.pdf");

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Instantiate a PdfTextFinder to search for text on the page
        PdfTextFinder finds = new PdfTextFinder(page);

        // Configure the search options (in this case, no special parameters are set)
        finds.getOptions().setTextFindParameter(EnumSet.of(TextFindParameter.None));

        // Search for the word "science" on the page and get a list of PdfTextFragment objects
        List<PdfTextFragment> result = finds.find("science");

        // Initialize a StringBuilder to store the results
        StringBuilder str = new StringBuilder();

        // Iterate over each found fragment
        for (PdfTextFragment find : result) {
            // Extract the line of text containing the search term
            String text = find.getLineText();

            // Retrieve font properties of the text fragment
            String FontName = find.getTextStates()[0].getFontName();       // Font name
            float FontSize = find.getTextStates()[0].getFontSize();         // Font size
            String FontFamily = find.getTextStates()[0].getFontFamily();    // Font family
            boolean IsBold = find.getTextStates()[0].isBold();             // Whether the text is bold
            boolean IsSimulateBold = find.getTextStates()[0].isSimulateBold(); // Whether bold is simulated
            boolean IsItalic = find.getTextStates()[0].isItalic();         // Whether the text is italic
            Color color = find.getTextStates()[0].getForegroundColor();    // Foreground color of the text

            // Append all extracted information to the StringBuilder
            str.append(text)
                    .append(" FontName: ").append(FontName)
                    .append(" FontSize:").append(FontSize)
                    .append(" FontFamily: ").append(FontFamily)
                    .append(" IsBold: ").append(IsBold)
                    .append(" IsSimulateBold: ").append(IsSimulateBold)
                    .append(" IsItalic: ").append(IsItalic)
                    .append(" color: ").append(color)
                    .append("\r\n"); // Newline for readability in the output file
        }

        // Define the path for the output text file
        String filePath = "output/result.txt";

        // Try-with-resources block to ensure the writer is closed after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the accumulated data from StringBuilder to the file
            writer.write(str.toString());
        } catch (IOException e) {
            // Handle any potential I/O exceptions
            e.printStackTrace();
        }

        pdf.dispose();

    }
}
