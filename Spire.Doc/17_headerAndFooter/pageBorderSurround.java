import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;

public class pageBorderSurround {
    public static void main(String[] args) {
        String output = "output/pageBorderSurround.docx";

        // Create a new document object
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Set page borders properties
        section.getPageSetup().getBorders().setBorderType(BorderStyle.Wave);
        section.getPageSetup().getBorders().setColor(Color.GREEN);
        section.getPageSetup().getBorders().getLeft().setSpace(20);
        section.getPageSetup().getBorders().getRight().setSpace(20);

        // Add a paragraph to the header
        Paragraph paragraph1 = section.getHeadersFooters().getHeader().addParagraph();
        paragraph1.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
        TextRange headerText = paragraph1.appendText("Header isn't included in page border");
        headerText.getCharacterFormat().setFontName("Calibri");
        headerText.getCharacterFormat().setFontSize(20);
        headerText.getCharacterFormat().setBold(true);

        // Add a paragraph to the footer
        Paragraph paragraph2 = section.getHeadersFooters().getFooter().addParagraph();
        paragraph2.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
        TextRange footerText = paragraph2.appendText("Footer is included in page border");
        footerText.getCharacterFormat().setFontName("Calibri");
        footerText.getCharacterFormat().setFontSize(20);
        footerText.getCharacterFormat().setBold(true);

        // Set page setup properties
        section.getPageSetup().setPageBorderIncludeHeader(false);
        section.getPageSetup().setHeaderDistance(40);
        section.getPageSetup().setPageBorderIncludeFooter(true);
        section.getPageSetup().setFooterDistance(40);

        // Save the document to the output file
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
