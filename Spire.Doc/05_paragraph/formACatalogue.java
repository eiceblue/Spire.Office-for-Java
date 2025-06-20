import com.spire.doc.*;
import com.spire.doc.documents.*;
public class formACatalogue {
    public static void main(String[] args){
        //Create Word document.
        Document document = new Document();

        //Add a new section.
        Section section = document.addSection();
        Paragraph paragraph = section.addParagraph();

        //Add Heading 1.
        paragraph.appendText(BuiltinStyle.Heading_1.toString());
        paragraph.applyStyle(BuiltinStyle.Heading_1);
        paragraph.getListFormat().applyNumberedStyle();

        // Add Heading 2.
        paragraph = section.addParagraph();
        paragraph.appendText(BuiltinStyle.Heading_2.toString());
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        //List style for Headings 2.
        ListStyle listSty2 = new ListStyle(document, ListType.Numbered);
        for (Object listLevelObj : listSty2.getLevels()) {
            ListLevel listLev = (ListLevel)listLevelObj;
            listLev.setUsePrevLevelPattern(true);
            listLev.setNumberPrefix("1.");
        }
        listSty2.setName("MyStyle2");
        document.getListStyles().add(listSty2);
        paragraph.getListFormat().applyStyle(listSty2.getName());

        //Add list style 3.
        ListStyle listSty3 = new ListStyle(document, ListType.Numbered);
        for (Object listLevelObj : listSty3.getLevels()) {
            ListLevel listLev = (ListLevel)listLevelObj;
            listLev.setUsePrevLevelPattern(true);
            listLev.setNumberPrefix("1.1.");
        }
        listSty3.setName("MyStyle3");
        document.getListStyles().add(listSty3);

        // Add Heading 3.
        for (int i = 0; i < 4; i++) {
            paragraph = section.addParagraph();
            // Append text
            paragraph.appendText(BuiltinStyle.Heading_3.toString());
            // Apply list style 3 for Heading 3
            paragraph.applyStyle(BuiltinStyle.Heading_3);
            paragraph.getListFormat().applyStyle(listSty3.getName());
        }

        String result = "output/formACatalogue.docx";

        // Save to file.
        document.saveToFile(result, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
