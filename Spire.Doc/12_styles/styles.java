import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class styles {
    public static void main(String[] args) {
        // Specify the output file path
        String output = "output/styles.docx";

        // Create a new Document instance
        Document document = new Document();

        // Add a new section to the document
        Section sec = document.addSection();

        // Define a title style
        Style titleStyle = document.addStyle(BuiltinStyle.Title);
        titleStyle.getCharacterFormat().setFontName("cambria");
        titleStyle.getCharacterFormat().setFontSize(28f);
        titleStyle.getCharacterFormat().setTextColor(new Color(42, 123, 136));

        // Customize the bottom border of the title style
        if (titleStyle instanceof ParagraphStyle) {
            ParagraphStyle ps = (ParagraphStyle)titleStyle;
            ps.getParagraphFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
            ps.getParagraphFormat().getBorders().getBottom().setColor(new Color(42, 123, 136));
            ps.getParagraphFormat().getBorders().getBottom().setLineWidth(1.5f);
            ps.getParagraphFormat().setHorizontalAlignment(HorizontalAlignment.Left);
        }

        // Define a normal style
        Style normalStyle = document.addStyle(BuiltinStyle.Normal);
        normalStyle.getCharacterFormat().setFontName("cambria");
        normalStyle.getCharacterFormat().setFontSize(11f);

        // Define a heading 1 style
        Style heading1Style = document.addStyle(BuiltinStyle.Heading_1);
        heading1Style.getCharacterFormat().setFontName("cambria");
        heading1Style.getCharacterFormat().setFontSize(14f);
        heading1Style.getCharacterFormat().setTextColor(new Color(42, 123, 136));

        // Define a heading 2 style
        Style heading2Style = document.addStyle(BuiltinStyle.Heading_2);
        heading2Style.getCharacterFormat().setFontName("cambria");
        heading2Style.getCharacterFormat().setFontSize(12f);
        heading2Style.getCharacterFormat().setBold(true);

        // Define a bullet list style
        ListStyle bulletList = new ListStyle(document, ListType.Bulleted);
        bulletList.getCharacterFormat().setFontName("cambria");
        bulletList.getCharacterFormat().setFontSize(12f);
        bulletList.setName("bulletList");
        document.getListStyles().add(bulletList);

        // Create a paragraph and apply the title style to it
        Paragraph paragraph = sec.addParagraph();
        paragraph.appendText("Your Name");
        paragraph.applyStyle(BuiltinStyle.Title);

        // Create a paragraph and apply the normal style to it
        paragraph = sec.addParagraph();
        paragraph.appendText("Address, City, ST ZIP Code | Telephone | Email");
        paragraph.applyStyle(BuiltinStyle.Normal);

        // Create a paragraph and apply the heading 1 style to it
        paragraph = sec.addParagraph();
        paragraph.appendText("Objective");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText(
            "To get started right away, just click any placeholder text (such as this) and start typing to replace it with your own.");
        paragraph.applyStyle(BuiltinStyle.Normal);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("Education");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("DEGREE | DATE EARNED | SCHOOL");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("Major:Text");
        paragraph.getListFormat().applyStyle("bulletList");

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("Minor:Text");
        paragraph.getListFormat().applyStyle("bulletList");

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("Related coursework:Text");
        paragraph.getListFormat().applyStyle("bulletList");

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("Skills & Abilities");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("MANAGEMENT");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText(
            "Think a document that looks this good has to be difficult to format? Think again! To easily apply any text formatting you see in this document with just a click, on the Home tab of the ribbon, check out Styles.");
        paragraph.getListFormat().applyStyle("bulletList");

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("COMMUNICATION");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText(
            "You delivered that big presentation to rave reviews. Don’t be shy about it now! This is the place to show how well you work and play with others.");
        paragraph.getListFormat().applyStyle("bulletList");

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("LEADERSHIP");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText(
            "Are you president of your fraternity, head of the condo board, or a team lead for your favorite charity? You’re a natural leader—tell it like it is!");
        paragraph.getListFormat().applyStyle("bulletList");

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("Experience");
        paragraph.applyStyle(BuiltinStyle.Heading_1);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText("JOB TITLE | COMPANY | DATES FROM - TO");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Create a new paragraph and add it to the section
        paragraph = sec.addParagraph();
        paragraph.appendText(
            "This is the place for a brief summary of your key responsibilities and most stellar accomplishments.");
        paragraph.getListFormat().applyStyle("bulletList");

        // Save the document to the specified output file in Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources
        document.dispose();
    }
}
