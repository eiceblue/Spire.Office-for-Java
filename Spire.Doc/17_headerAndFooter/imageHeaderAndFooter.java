import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;

public class imageHeaderAndFooter {
    public static void main(String[] args) {
        String input1 = "data/multiPages.docx";
        String input2 = "data/e-iceblue.png";
        String input3 = "data/logo.png";
        String output = "output/imageHeaderAndFooter.docx";

        // Load the document from the input1 file
        Document doc = new Document();
        doc.loadFromFile(input1);

        // Get the header of the first page
        HeaderFooter header = doc.getSections().get(0).getHeadersFooters().getHeader();

        // Add a paragraph to the header
        Paragraph paragraph = header.addParagraph();

        // Set the horizontal alignment of the paragraph
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        // Append a picture to the paragraph
        DocPicture headerImage = paragraph.appendPicture(input2);
        headerImage.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

        // Get the footer of the first section
        HeaderFooter footer = doc.getSections().get(0).getHeadersFooters().getFooter();

        // Add a paragraph to the footer
        Paragraph paragraph2 = footer.addParagraph();

        // Set the horizontal alignment of the paragraph
        paragraph2.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);

        // Append a picture to the paragraph
        DocPicture footerImage = paragraph2.appendPicture(input3);

        // Append text to the paragraph
        TextRange copyrightText = paragraph2.appendText("Copyright © 2013 e-iceblue. All Rights Reserved.");
        copyrightText.getCharacterFormat().setFontName("Arial");
        copyrightText.getCharacterFormat().setFontSize(10);
        copyrightText.getCharacterFormat().setTextColor(Color.BLACK);

        // Save the document
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
