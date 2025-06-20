import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;
import java.text.MessageFormat;

public class insertBreak {
    public static void main(String[] args) {
        // Specify the output file path for the modified document
        String output = "output/result_insertBreak.docx";

        // Create a new Document object
        Document document = new Document();

        // Add a section to the document and set its page settings
        Section section = document.addSection();
        setPage(section);

        // Insert cover content into the section
        insertCover(section);

        // Add a new section to the document and insert content
        section = document.addSection();
        insertContent(section);

        // Insert a section break to start a new page after the previous section
        section.addParagraph().insertSectionBreak(SectionBreakType.New_Page);

        // Save the modified document to the specified file path in the Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the Document object to release resources
        document.dispose();
    }

    // Set the page settings of a given section
    private static void setPage(Section section) {
        // Set the page size to A4
        section.getPageSetup().setPageSize(PageSize.A4);

        // Set the top margin to 72f
        section.getPageSetup().getMargins().setTop(72f);

        // Set the bottom margin to 72f
        section.getPageSetup().getMargins().setBottom(72f);

        // Set the left margin to 89.85f
        section.getPageSetup().getMargins().setLeft(89.85f);

        // Set the right margin to 89.85f
        section.getPageSetup().getMargins().setRight(89.85f);
    }

    // Insert cover content into a given section
    private static void insertCover(Section section) {
        // Create a paragraph style for small text
        ParagraphStyle small = new ParagraphStyle(section.getDocument());
        small.setName("small");
        small.getCharacterFormat().setFontName("Arial");
        small.getCharacterFormat().setFontSize(9);
        small.getCharacterFormat().setTextColor(Color.GRAY);

        // Add the custom style to the document's styles collection
        section.getDocument().getStyles().add(small);

        // Add paragraphs for cover content
        Paragraph paragraph = section.addParagraph();
        paragraph.appendText("The sample demonstrates how to insert section break.");
        paragraph.applyStyle(small.getName());

        // Add title paragraph
        Paragraph title = section.addParagraph();
        TextRange text = title.appendText("Field Types Supported by Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(20);
        text.getCharacterFormat().setBold(true);

        // Set formatting for the title paragraph
        title.getFormat().setBeforeSpacing((float)section.getPageSetup().getPageSize().getHeight() / 2
            - 3 * section.getPageSetup().getMargins().getTop());
        title.getFormat().setAfterSpacing(8);
        title.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        // Add another paragraph
        paragraph = section.addParagraph();
        paragraph.appendText("e-iceblue Spire.Doc team.");
        paragraph.applyStyle(small.getName());
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
    }

    // Insert content into a given section
    private static void insertContent(Section section) {

        // Create a paragraph style for the list
        ParagraphStyle list = new ParagraphStyle(section.getDocument());
        list.setName("list");
        list.getCharacterFormat().setFontName("Arial");
        list.getCharacterFormat().setFontSize(11);
        list.getParagraphFormat().setLineSpacing(1.5F * 12F);
        list.getParagraphFormat().setLineSpacingRule(LineSpacingRule.Multiple);

        // Add the custom style to the document's styles collection
        section.getDocument().getStyles().add(list);

        // Add title paragraph
        Paragraph title = section.addParagraph();
        title.appendText("Field type list:");
        title.applyStyle(list.getName());

        boolean first = true;
        // Iterate over each field type
        for (FieldType type : FieldType.values()) {
            // Skip unknown, none, and empty field types
            if (type == FieldType.Field_Unknown || type == FieldType.Field_None || type == FieldType.Field_Empty) {
                continue;
            }
            Paragraph paragraph = section.addParagraph();
            paragraph.appendText(MessageFormat.format("{0} is supported in Spire.Doc", type));
            if (first) {
                // Apply numbered list style to the first paragraph
                paragraph.getListFormat().applyNumberedStyle();
                first = false;
            } else {
                // Continue the numbering from the previous paragraph
                paragraph.getListFormat().continueListNumbering();
            }
            // Apply the list style to the paragraph
            paragraph.applyStyle(list.getName());
        }
    }
}
