import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.DocPicture;

public class hyperlink {
    public static void main(String[] args) throws Exception {
        // Specify the output file path
        String output = "output/InsertHyperlinks.docx";

        // Create a new document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Call the method to insert hyperlinks into the section
        insertHyperlink(section);

        // Save the document to the specified output file in DOCX format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }

    private static void insertHyperlink(Section section) throws Exception {
        // Get the first paragraph in the section or add a new one if none exists
        Paragraph paragraph = section.getParagraphs().getCount() > 0 ? section.getParagraphs().get(0) : section.addParagraph();

        // Append text to the paragraph and apply a built-in heading style
        paragraph.appendText("Spire.Doc for Java \r\n e-iceblue company Ltd. 2002-2019 All rights reserved");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add a new paragraph for the "Home page" hyperlink
        paragraph = section.addParagraph();
        paragraph.appendText("Home page");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add a hyperlink to the paragraph with the specified URL and display text
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("www.e-iceblue.com", "www.e-iceblue.com", HyperlinkType.Web_Link);

        // Add a new paragraph for the "Contact US" hyperlink
        paragraph = section.addParagraph();
        paragraph.appendText("Contact US");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add a hyperlink to the paragraph with the specified email address and display text
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("mailto:support@e-iceblue.com", "support@e-iceblue.com", HyperlinkType.E_Mail_Link);

        // Add a new paragraph for the "Forum" hyperlink
        paragraph = section.addParagraph();
        paragraph.appendText("Forum");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add a hyperlink to the paragraph with the specified URL and display text
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("www.e-iceblue.com/forum/", "www.e-iceblue.com/forum/", HyperlinkType.Web_Link);

        // Add a new paragraph for the "Download Link" hyperlink
        paragraph = section.addParagraph();
        paragraph.appendText("Download Link");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add a hyperlink to the paragraph with the specified URL and display text
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("www.e-iceblue.com/Download/doc-for-java.html", "www.e-iceblue.com/Download/doc-for-java.html", HyperlinkType.Web_Link);

        // Add a new paragraph for the "Insert Link On Image" hyperlink
        paragraph = section.addParagraph();
        paragraph.appendText("Insert Link On Image");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add a paragraph with an image and a hyperlink to the paragraph using the specified URL and image object
        paragraph = section.addParagraph();
        DocPicture picture = paragraph.appendPicture("data/spireDoc.png");
        paragraph.appendHyperlink("www.e-iceblue.com/Download/doc-for-java.html", picture, HyperlinkType.Web_Link);
    }
}
