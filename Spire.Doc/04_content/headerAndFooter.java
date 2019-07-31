import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class headerAndFooter {
    public static void main(String[] args) throws Exception {
        String input = "data/headerAndFooter.docx";
        String output = "output/headerAndFooter.docx";

        //load word document
        Document document = new Document();
        document.loadFromFile(input);
        Section section = document.getSections().get(0);

        //insert header and footer
        insertHeaderAndFooter(section);

        //save as docx file.
        document.saveToFile(output, FileFormat.Docx);
    }

    private static void insertHeaderAndFooter(Section section) throws Exception {
        String headerImage = "data/header.png";
        String footerImage = "data/footer.png";
        section.getPageSetup().setPageSize(PageSize.A4);
        section.getPageSetup().getMargins().setTop(72f);
        section.getPageSetup().getMargins().setBottom(72f);
        section.getPageSetup().getMargins().setLeft(89.85f);
        section.getPageSetup().getMargins().setRight(89.85f);

        HeaderFooter header = section.getHeadersFooters().getHeader();
        HeaderFooter footer = section.getHeadersFooters().getFooter();

        //insert picture and text to header
        Paragraph headerParagraph = header.addParagraph();
        DocPicture headerPicture = headerParagraph.appendPicture(headerImage);

        //header text
        TextRange text = headerParagraph.appendText("Demo of Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(10);
        text.getCharacterFormat().setItalic(true);
        headerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        //border
        headerParagraph.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
        headerParagraph.getFormat().getBorders().getBottom().setSpace(0.05F);


        //header picture layout - text wrapping
        headerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);

        //header picture layout - position
        headerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        headerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        headerPicture.setVerticalOrigin(VerticalOrigin.Page);
        headerPicture.setVerticalAlignment(ShapeVerticalAlignment.Top);

        //insert picture to footer
        Paragraph footerParagraph = footer.addParagraph();
        DocPicture footerPicture = footerParagraph.appendPicture(footerImage);

        //footer picture layout
        footerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);
        footerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        footerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        footerPicture.setVerticalOrigin(VerticalOrigin.Page);
        footerPicture.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

        //insert page number
        footerParagraph.appendField("page number", FieldType.Field_Page);
        footerParagraph.appendText(" of ");
        footerParagraph.appendField("number of pages", FieldType.Field_Num_Pages);
        footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        //border
        footerParagraph.getFormat().getBorders().getTop().setBorderType(BorderStyle.Single);
        footerParagraph.getFormat().getBorders().getTop().setSpace(0.05F);
    }
}
