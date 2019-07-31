import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;
import java.text.MessageFormat;

public class insertBreak {
    public static void main(String[] args) {
        String output = "output/insertBreak.docx";
        //create word document
        Document document = new Document();
        Section section = document.addSection();

        //page setup
        setPage(section);

        //Add cover.
        insertCover(section);

        section = document.addSection();
        //add content
        insertContent(section);
        //insert a break code
        section.addParagraph().insertSectionBreak(SectionBreakType.New_Page);

        //save as doc file.
        document.saveToFile(output, FileFormat.Docx);
    }
    private static void setPage(Section section) {
        section.getPageSetup().setPageSize(PageSize.A4);
        section.getPageSetup().getMargins().setTop(72f);
        section.getPageSetup().getMargins().setBottom(72f);
        section.getPageSetup().getMargins().setLeft(89.85f);
        section.getPageSetup().getMargins().setRight(89.85f);
    }

    private static void insertCover(Section section) {
        ParagraphStyle small = new ParagraphStyle(section.getDocument());
        small.setName("small");
        small.getCharacterFormat().setFontName("Arial");
        small.getCharacterFormat().setFontSize(9);
        small.getCharacterFormat().setTextColor(Color.GRAY);
        section.getDocument().getStyles().add(small);

        Paragraph paragraph = section.addParagraph();
        paragraph.appendText("The sample demonstrates how to insert section break.");
        paragraph.applyStyle(small.getName());

        Paragraph title = section.addParagraph();
        TextRange text = title.appendText("Field Types Supported by Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(20);
        text.getCharacterFormat().setBold(true);
        title.getFormat().setBeforeSpacing((float)section.getPageSetup().getPageSize().getHeight() / 2 - 3 * section.getPageSetup().getMargins().getTop());

        title.getFormat().setAfterSpacing(8);
        title.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        paragraph = section.addParagraph();
        paragraph.appendText("e-iceblue Spire.Doc team.");
        paragraph.applyStyle(small.getName());
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
    }

    private static void insertContent(Section section) {
        ParagraphStyle list = new ParagraphStyle(section.getDocument());
        list.setName("list");
        list.getCharacterFormat().setFontName("Arial");
        list.getCharacterFormat().setFontSize(11);
        list.getParagraphFormat().setLineSpacing(1.5F * 12F);
        list.getParagraphFormat().setLineSpacingRule(LineSpacingRule.Multiple);
        section.getDocument().getStyles().add(list);

        Paragraph title = section.addParagraph();
        title.appendText("Field type list:");
        title.applyStyle(list.getName());

        boolean first = true;
        for (FieldType type : FieldType.values()) {
            if (type == FieldType.Field_Unknown
                    || type == FieldType.Field_None || type == FieldType.Field_Empty) {
                continue;
            }
            Paragraph paragraph = section.addParagraph();
            paragraph.appendText(MessageFormat.format("{0} is supported in Spire.Doc", type));

            if (first) {
                paragraph.getListFormat().applyNumberedStyle();
                first = false;
            } else {
                paragraph.getListFormat().continueListNumbering();
            }
            paragraph.applyStyle(list.getName());
        }
    }
}
