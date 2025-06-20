import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class headerAndFooter {
    public static void main(String[] args) throws Exception {
        String input = "data/headerAndFooter.docx";
        String output = "output/headerAndFooter.docx";

        // Load the word document from the input file
        Document document = new Document();
        document.loadFromFile(input);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Insert header and footer to the section
        insertHeaderAndFooter(section);

        // Save the modified document as a docx file
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }

    private static void insertHeaderAndFooter(Section section) throws Exception {
        // Define paths for header and footer images
        String headerImage = "data/header.png";
        String footerImage = "data/footer.png";

        // Set page size and margins for the section
        section.getPageSetup().setPageSize(PageSize.A4);
        section.getPageSetup().getMargins().setTop(72f);
        section.getPageSetup().getMargins().setBottom(72f);
        section.getPageSetup().getMargins().setLeft(89.85f);
        section.getPageSetup().getMargins().setRight(89.85f);

        // Get header and footer objects from the section
        HeaderFooter header = section.getHeadersFooters().getHeader();
        HeaderFooter footer = section.getHeadersFooters().getFooter();

        // Insert picture and text to the header
        Paragraph headerParagraph = header.addParagraph();
        DocPicture headerPicture = headerParagraph.appendPicture(headerImage);

        // Add header text
        TextRange text = headerParagraph.appendText("Demo of Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(10);
        text.getCharacterFormat().setItalic(true);
        headerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        // Set border properties for the header paragraph
        headerParagraph.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
        headerParagraph.getFormat().getBorders().getBottom().setSpace(0.05F);

        // Set layout properties for the header picture
        headerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);
        headerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        headerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        headerPicture.setVerticalOrigin(VerticalOrigin.Page);
        headerPicture.setVerticalAlignment(ShapeVerticalAlignment.Top);

        // Insert picture to the footer
        Paragraph footerParagraph = footer.addParagraph();
        DocPicture footerPicture = footerParagraph.appendPicture(footerImage);

        // Set layout properties for the footer picture
        footerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);
        footerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        footerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        footerPicture.setVerticalOrigin(VerticalOrigin.Page);
        footerPicture.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

        // Insert page number and total number of pages in the footer
        footerParagraph.appendField("page number", FieldType.Field_Page);
        footerParagraph.appendText(" of ");
        footerParagraph.appendField("number of pages", FieldType.Field_Num_Pages);
        footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        // Set border properties for the footer paragraph
        footerParagraph.getFormat().getBorders().getTop().setBorderType(BorderStyle.Single);
        footerParagraph.getFormat().getBorders().getTop().setSpace(0.05F);
    }
}

