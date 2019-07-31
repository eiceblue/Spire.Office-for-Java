import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.DocPicture;

public class hyperlink {
    public static void main(String[] args) throws Exception {
        String output = "output/hyperlink.docx";

        //create a word document and add a section
        Document document = new Document();
        Section section = document.addSection();

        //insert hyperlink
        insertHyperlink(section);

        //save doc file.
        document.saveToFile(output, FileFormat.Docx);
    }

    private static void insertHyperlink(Section section) throws Exception {
        Paragraph paragraph = section.getParagraphs().getCount() > 0 ? section.getParagraphs().get(0) : section.addParagraph();
        paragraph.appendText("Spire.Doc for Java \r\n e-iceblue company Ltd. 2002-2019 All rights reserved");
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        paragraph = section.addParagraph();
        paragraph.appendText("Home page");
        paragraph.applyStyle(BuiltinStyle.Heading_2);
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("www.e-iceblue.com", "www.e-iceblue.com", HyperlinkType.Web_Link);

        paragraph = section.addParagraph();
        paragraph.appendText("Contact US");
        paragraph.applyStyle(BuiltinStyle.Heading_2);
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("mailto:support@e-iceblue.com", "support@e-iceblue.com", HyperlinkType.E_Mail_Link);

        paragraph = section.addParagraph();
        paragraph.appendText("Forum");
        paragraph.applyStyle(BuiltinStyle.Heading_2);
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("www.e-iceblue.com/forum/", "www.e-iceblue.com/forum/", HyperlinkType.Web_Link);

        paragraph = section.addParagraph();
        paragraph.appendText("Download Link");
        paragraph.applyStyle(BuiltinStyle.Heading_2);
        paragraph = section.addParagraph();
        paragraph.appendHyperlink("www.e-iceblue.com/Download/download-word-for-net-now.html", "www.e-iceblue.com/Download/download-word-for-net-now.html", HyperlinkType.Web_Link);

        paragraph = section.addParagraph();
        paragraph.appendText("Insert Link On Image");
        paragraph.applyStyle(BuiltinStyle.Heading_2);
        paragraph = section.addParagraph();
        DocPicture picture = paragraph.appendPicture("data/spireDoc.png");
        paragraph.appendHyperlink("www.e-iceblue.com/Download/download-word-for-net-now.html", picture, HyperlinkType.Web_Link);
    }
}
