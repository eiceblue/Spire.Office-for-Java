import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.util.*;

public class addContentControls {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Append text to the paragraph
        TextRange txtRange = paragraph.appendText("The following example shows how to add content controls in a Word document.");

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();
        txtRange = paragraph.appendText("Add Combo Box Content Control:  ");
        txtRange.getCharacterFormat().setItalic(true);

        // Create a StructureDocumentTagInline object
        StructureDocumentTagInline sd = new StructureDocumentTagInline(document);

        // Add the StructureDocumentTagInline to the child objects of the paragraph
        paragraph.getChildObjects().add(sd);

        // Set the SDTType of the StructureDocumentTagInline to Combo_Box
        sd.getSDTProperties().setSDTType(SdtType.Combo_Box);

        // Create a SdtComboBox object
        SdtComboBox cb = new SdtComboBox();

        // Add list items to the SdtComboBox
        cb.getListItems().add(new SdtListItem("Spire.Doc"));
        cb.getListItems().add(new SdtListItem("Spire.XLS"));
        cb.getListItems().add(new SdtListItem("Spire.PDF"));

        // Set the control properties of the StructureDocumentTagInline to the SdtComboBox
        sd.getSDTProperties().setControlProperties(cb);

        // Create a TextRange object
        TextRange rt = new TextRange(document);

        // Set the text of the TextRange to the display text of the first list item in the SdtComboBox
        rt.setText(cb.getListItems().get(0).getDisplayText());

        // Add the TextRange to the child objects of the SDTContent
        sd.getSDTContent().getChildObjects().add(rt);

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();
        txtRange = paragraph.appendText("Add Text Content Control:  ");
        txtRange.getCharacterFormat().setItalic(true);

        // Create a new StructureDocumentTagInline object
        sd = new StructureDocumentTagInline(document);

        // Add the StructureDocumentTagInline to the child objects of the paragraph
        paragraph.getChildObjects().add(sd);

        // Set the SDTType of the StructureDocumentTagInline to Text
        sd.getSDTProperties().setSDTType(SdtType.Text);

        // Create a SdtText object
        SdtText text = new SdtText(true);

        // Enable multiline for the SdtText
        text.isMultiline(true);

        // Set the control properties of the StructureDocumentTagInline to the SdtText
        sd.getSDTProperties().setControlProperties(text);

        // Create a new TextRange object
        rt = new TextRange(document);

        // Set the text of the TextRange
        rt.setText("Text");

        // Add the TextRange to the child objects of the SDTContent
        sd.getSDTContent().getChildObjects().add(rt);

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();
        txtRange = paragraph.appendText("Add Picture Content Control:  ");
        txtRange.getCharacterFormat().setItalic(true);

        // Create a new StructureDocumentTagInline object
        sd = new StructureDocumentTagInline(document);

        // Add the StructureDocumentTagInline to the child objects of the paragraph
        paragraph.getChildObjects().add(sd);

        // Set the SDTType of the StructureDocumentTagInline to Picture
        sd.getSDTProperties().setSDTType(SdtType.Picture);

        // Create a DocPicture object
        DocPicture pic = new DocPicture(document);

        // Set the width and height of the picture
        pic.setWidth(10f);
        pic.setHeight(10f);

        // Load an image from file
        pic.loadImage("data/logo.png");

        // Add the picture to the child objects of the SDTContent
        sd.getSDTContent().getChildObjects().add(pic);

        // Add an empty paragraph to the section
        section.addParagraph();

        // Create a new paragraph in the section
        paragraph = section.addParagraph();

        // Append text to the paragraph
        txtRange = paragraph.appendText("Add Date Picker Content Control: ");

        // Set the text formatting to italic
        txtRange.getCharacterFormat().setItalic(true);

        // Create a new inline structure document tag
        sd = new StructureDocumentTagInline(document);

        // Add the structure document tag to the paragraph's child objects
        paragraph.getChildObjects().add(sd);

        // Set the type of the structure document tag to Date Picker
        sd.getSDTProperties().setSDTType(SdtType.Date_Picker);

        // Create a new date object for the control properties
        SdtDate date = new SdtDate();

        // Set the calendar type of the date control
        date.setCalendarType(CalendarType.Default);

        // Set the date format of the date control
        date.setDateFormat("yyyy.MM.dd");

        // Set the current date as the full date of the date control
        date.setFullDate(new Date());

        // Set the control properties of the structure document tag
        sd.getSDTProperties().setControlProperties(date);

        // Create a new text range object
        rt = new TextRange(document);

        // Set the text of the text range
        rt.setText("2019.12.31");

        // Add the text range to the content of the structure document tag
        sd.getSDTContent().getChildObjects().add(rt);

        // Add an empty paragraph to create space
        section.addParagraph();

        // Create a new paragraph in the section
        paragraph = section.addParagraph();

        // Append text to the paragraph
        txtRange = paragraph.appendText("Add Drop-Down List Content Control: ");

        // Set the text formatting to italic
        txtRange.getCharacterFormat().setItalic(true);

        // Create a new inline structure document tag
        sd = new StructureDocumentTagInline(document);

        // Add the structure document tag to the paragraph's child objects
        paragraph.getChildObjects().add(sd);

        // Set the type of the structure document tag to Drop-Down List
        sd.getSDTProperties().setSDTType(SdtType.Drop_Down_List);

        // Create a new drop-down list object for the control properties
        SdtDropDownList sddl = new SdtDropDownList();

        // Add a list item to the drop-down list
        sddl.getListItems().add(new SdtListItem("Harry"));

        // Add another list item to the drop-down list
        sddl.getListItems().add(new SdtListItem("Jerry"));

        // Set the control properties of the structure document tag
        sd.getSDTProperties().setControlProperties(sddl);

        // Create a new text range object
        rt = new TextRange(document);

        // Set the text of the text range to the first list item
        rt.setText(sddl.getListItems().get(0).getDisplayText());

        // Add the text range to the content of the structure document tag
        sd.getSDTContent().getChildObjects().add(rt);

        // Save the document to a file
        String output = "output/addContentControls.docx";
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        document.dispose();
    }
}
