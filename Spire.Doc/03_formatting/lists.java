import com.spire.doc.*;
import com.spire.doc.documents.*;

public class lists {
    public static void main(String[] args) {
        String output="output/lists.docx";
        //initialize a document
        Document document = new Document();
        //add a section
        Section sec = document.addSection();
        //Add paragraph and set list style
        Paragraph paragraph = sec.addParagraph();
        paragraph.appendText("Lists");
        paragraph.applyStyle(BuiltinStyle.Title);

        paragraph = sec.addParagraph();
        paragraph.appendText("Numbered List:").getCharacterFormat().setBold(true);

        //create list style
        ListStyle numberList = new ListStyle(document, ListType.Numbered);
        numberList.setName("numberList");

        numberList.getLevels().get(1).setNumberPrefix("\u0000.");
        numberList.getLevels().get(1).setPatternType(ListPatternType.Arabic);
        numberList.getLevels().get(2).setNumberPrefix("\u0000.\u0001.");
        numberList.getLevels().get(2).setPatternType(ListPatternType.Arabic);

        ListStyle bulletList= new ListStyle(document, ListType.Bulleted);
        bulletList.setName("bulletList");

        //add the list style into document
        document.getListStyles().add(numberList);
        document.getListStyles().add(bulletList);

        //add paragraph and apply the list style
        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 1");
        paragraph.getListFormat().applyStyle(numberList.getName());

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2");
        paragraph.getListFormat().applyStyle(numberList.getName());

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.1");
        paragraph.getListFormat().applyStyle(numberList.getName());
        paragraph.getListFormat().setListLevelNumber(1);

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.2");
        paragraph.getListFormat().applyStyle(numberList.getName());
        paragraph.getListFormat().setListLevelNumber(1);

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.2.1");
        paragraph.getListFormat().applyStyle(numberList.getName());
        paragraph.getListFormat().setListLevelNumber(2);
        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.2.2");
        paragraph.getListFormat().applyStyle(numberList.getName());
        paragraph.getListFormat().setListLevelNumber(2);
        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.2.3");
        paragraph.getListFormat().applyStyle(numberList.getName());
        paragraph.getListFormat().setListLevelNumber(2);

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.3");
        paragraph.getListFormat().applyStyle(numberList.getName());
        paragraph.getListFormat().setListLevelNumber(1);

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 3");
        paragraph.getListFormat().applyStyle(numberList.getName());

        paragraph = sec.addParagraph();
        paragraph.appendText("Bulleted List:").getCharacterFormat().setBold(true);

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 1");
        paragraph.getListFormat().applyStyle(bulletList.getName());
        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2");
        paragraph.getListFormat().applyStyle(bulletList.getName());

        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.1");
        paragraph.getListFormat().applyStyle(bulletList.getName());
        paragraph.getListFormat().setListLevelNumber(1);
        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 2.2");
        paragraph.getListFormat().applyStyle(bulletList.getName());
        paragraph.getListFormat().setListLevelNumber(1);
        paragraph = sec.addParagraph();
        paragraph.appendText("List Item 3");
        paragraph.getListFormat().applyStyle(bulletList.getName());

        //save doc file.
        document.saveToFile(output, FileFormat.Docx);
    }
}
