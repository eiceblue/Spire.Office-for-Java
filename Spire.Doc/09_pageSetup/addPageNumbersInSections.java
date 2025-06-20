import com.spire.doc.*;
import com.spire.doc.documents.*;

public class addPageNumbersInSections {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load a Word document from the specified file
        document.loadFromFile("data/Template_Docx_4.docx");

        // Iterate through the first three sections of the document
        for (int i = 0; i < 3; i++) {
            // Get the footer of the current section
            HeaderFooter footer = document.getSections().get(i).getHeadersFooters().getFooter();

            // Add a paragraph to the footer
            Paragraph footerParagraph = footer.addParagraph();

            // Append a page number field to the footer paragraph
            footerParagraph.appendField("page number", FieldType.Field_Page);

            // Append " of " text to the footer paragraph
            footerParagraph.appendText(" of ");

            // Append a section pages field to the footer paragraph
            footerParagraph.appendField("number of pages", FieldType.Field_Section_Pages);

            // Set the horizontal alignment of the footer paragraph to right
            footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

            // If it's the last iteration, exit the loop
            if (i == 2)
                break;
            else {
                // Enable page numbering restart for the next section
                document.getSections().get(i + 1).getPageSetup().setRestartPageNumbering(true);

                // Set the starting page number for the next section to 1
                document.getSections().get(i + 1).getPageSetup().setPageStartingNumber(1);
            }
        }

        // Specify the output file path
        String result = "output/result-addPageNumbersInSections.docx";

        // Save the modified document to the specified file in Docx format compatible with Word 2013
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose of the Document object to release resources
        document.dispose();
    }
}
