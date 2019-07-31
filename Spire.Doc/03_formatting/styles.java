import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class styles {
    public static void main(String[] args) {
        String output = "output/styles.docx";

        //initialize a document
        Document document = new Document();
        Section sec = document.addSection();

        //add default title style to document
        Style titleStyle = document.addStyle(BuiltinStyle.Title);
        titleStyle.getCharacterFormat().setFontName("cambria");
        titleStyle.getCharacterFormat().setFontSize(28f);
        titleStyle.getCharacterFormat().setTextColor(new Color(42, 123, 136));

        //judge if it is Paragraph Style and then set paragraph format
        if (titleStyle instanceof ParagraphStyle) {
            ParagraphStyle ps = (ParagraphStyle) titleStyle;
            ps.getParagraphFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
            ps.getParagraphFormat().getBorders().getBottom().setColor(new Color(42, 123, 136));
            ps.getParagraphFormat().getBorders().getBottom().setLineWidth(1.5f);
            ps.getParagraphFormat().setHorizontalAlignment(HorizontalAlignment.Left);
        }
        //add default normal style and modify
        Style normalStyle = document.addStyle(BuiltinStyle.Normal);
        normalStyle.getCharacterFormat().setFontName("cambria");
        normalStyle.getCharacterFormat().setFontSize(11f);

        //add default heading1 style
        Style heading1Style = document.addStyle(BuiltinStyle.Heading_1);
        heading1Style.getCharacterFormat().setFontName("cambria");
        heading1Style.getCharacterFormat().setFontSize(14f);
        heading1Style.getCharacterFormat().setTextColor(new Color(42, 123, 136));

        //add default heading2 style
        Style heading2Style = document.addStyle(BuiltinStyle.Heading_2);
        heading2Style.getCharacterFormat().setFontName("cambria");
        heading2Style.getCharacterFormat().setFontSize(12f);
        heading2Style.getCharacterFormat().setBold(true);

        //list style
        ListStyle bulletList = new ListStyle(document, ListType.Bulleted);
        bulletList.getCharacterFormat().setFontName("cambria");
        bulletList.getCharacterFormat().setFontSize(12f);

        bulletList.setName("bulletList");
        document.getListStyles().add(bulletList);

        //apply the style
        Paragraph paragraph = sec.addParagraph();
        paragraph.appendText("Your Name");
        paragraph.applyStyle(BuiltinStyle.Title);

        paragraph = sec.addParagraph();
        paragraph.appendText("Address, City, ST ZIP Code | Telephone | Email");
        paragraph.applyStyle(BuiltinStyle.Normal);

        paragraph = sec.addParagraph();
        paragraph.appendText("Objective");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        paragraph = sec.addParagraph();
        paragraph.appendText("To get started right away, just click any placeholder text (such as this) and start typing to replace it with your own.");
        paragraph.applyStyle(BuiltinStyle.Normal);

        paragraph = sec.addParagraph();
        paragraph.appendText("Education");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        paragraph = sec.addParagraph();
        paragraph.appendText("DEGREE | DATE EARNED | SCHOOL");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        paragraph = sec.addParagraph();
        paragraph.appendText("Major:Text");
        paragraph.getListFormat().applyStyle("bulletList");
        paragraph = sec.addParagraph();
        paragraph.appendText("Minor:Text");
        paragraph.getListFormat().applyStyle("bulletList");
        paragraph = sec.addParagraph();
        paragraph.appendText("Related coursework:Text");
        paragraph.getListFormat().applyStyle("bulletList");

        paragraph = sec.addParagraph();
        paragraph.appendText("Skills & Abilities");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        paragraph = sec.addParagraph();
        paragraph.appendText("MANAGEMENT");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        paragraph = sec.addParagraph();
        paragraph.appendText("Think a document that looks this good has to be difficult to format? Think again! To easily apply any text formatting you see in this document with just a click, on the Home tab of the ribbon, check out Styles.");
        paragraph.getListFormat().applyStyle("bulletList");

        paragraph = sec.addParagraph();
        paragraph.appendText("COMMUNICATION");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        paragraph = sec.addParagraph();
        paragraph.appendText("You delivered that big presentation to rave reviews. Don’t be shy about it now! This is the place to show how well you work and play with others.");
        paragraph.getListFormat().applyStyle("bulletList");

        paragraph = sec.addParagraph();
        paragraph.appendText("LEADERSHIP");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        paragraph = sec.addParagraph();
        paragraph.appendText("Are you president of your fraternity, head of the condo board, or a team lead for your favorite charity? You’re a natural leader—tell it like it is!");
        paragraph.getListFormat().applyStyle("bulletList");

        paragraph = sec.addParagraph();
        paragraph.appendText("Experience");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        paragraph = sec.addParagraph();
        paragraph.appendText("JOB TITLE | COMPANY | DATES FROM - TO");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        paragraph = sec.addParagraph();
        paragraph.appendText("This is the place for a brief summary of your key responsibilities and most stellar accomplishments.");
        paragraph.getListFormat().applyStyle("bulletList");

        //save to docx file.
        document.saveToFile(output, FileFormat.Docx);
    }
}
