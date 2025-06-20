import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class differentFirstPage {
    public static void main(String[] args) {
        String input1 = "data/multiPages.docx";
        String input2 = "data/e-iceblue.png";
        String output = "output/differentFirstPage.docx";

        // Load the document from input1 file
        Document doc = new Document();
        doc.loadFromFile(input1);

        // Get the first section and enable different first page header/footer
        Section section = doc.getSections().get(0);
        section.getPageSetup().setDifferentFirstPageHeaderFooter(true);

        // Set the first page header and append a picture to it
        Paragraph paragraph1 = section.getHeadersFooters().getFirstPageHeader().addParagraph();
        paragraph1.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
        paragraph1.appendPicture(input2);

        // Set the first page footer
        Paragraph paragraph2 = section.getHeadersFooters().getFirstPageFooter().addParagraph();
        paragraph2.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        TextRange firstPageFooter = paragraph2.appendText("First Page Footer");
        firstPageFooter.getCharacterFormat().setFontSize(10);

        // Set the other header
        Paragraph paragraph3 = section.getHeadersFooters().getHeader().addParagraph();
        paragraph3.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        TextRange headerText = paragraph3.appendText("Spire.Doc for JAVA");
        headerText.getCharacterFormat().setFontSize(10);

        // Set the other footer
        Paragraph paragraph4 = section.getHeadersFooters().getFooter().addParagraph();
        paragraph4.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        TextRange footerText = paragraph4.appendText("E-iceblue");
        footerText.getCharacterFormat().setFontSize(10);

        // Save the modified document to the output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
