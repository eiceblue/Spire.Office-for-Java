import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.DocPicture;

public class imageToPdf {
    public static void main(String[] args) {
        // Input file path and name for the image
        String input = "data/Image.png";

        // Create a new Document object
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Append the picture to the paragraph using the specified input file
        DocPicture picture = paragraph.appendPicture(input);

        // Set the page size of the section to A4
        section.getPageSetup().setPageSize(PageSize.A4);

        // Set the top margin of the page to 10f
        section.getPageSetup().getMargins().setTop(10f);

        // Set the left margin of the page to 25f
        section.getPageSetup().getMargins().setLeft(25f);

        // Specify the output file path and name for the generated PDF
        String result = "output/imageToPdf.pdf";

        // Save the document to the specified file in PDF format
        doc.saveToFile(result, FileFormat.PDF);

        // Dispose of the document resources
        doc.dispose();
    }
}
