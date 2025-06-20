import com.spire.doc.*;
import com.spire.doc.documents.*;

public class asciiCharactersBulletStyle {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Create and configure ListStyle 1
        ListStyle listStyle1 = new ListStyle(document, ListType.Bulleted);
        listStyle1.setName("listStyle");
        listStyle1.getLevels().get(0).setBulletCharacter(ASCII2String(0x006e));
        listStyle1.getLevels().get(0).getCharacterFormat().setFontName("Wingdings");
        document.getListStyles().add(listStyle1);

        // Create and configure ListStyle 2
        ListStyle listStyle2 = new ListStyle(document, ListType.Bulleted);
        listStyle2.setName("listStyle2");
        listStyle2.getLevels().get(0).setBulletCharacter(ASCII2String(0x0075));
        listStyle2.getLevels().get(0).getCharacterFormat().setFontName("Wingdings");
        document.getListStyles().add(listStyle2);

        // Create and configure ListStyle 3
        ListStyle listStyle3 = new ListStyle(document, ListType.Bulleted);
        listStyle3.setName("listStyle3");
        listStyle3.getLevels().get(0).setBulletCharacter(ASCII2String(0x00b2));
        listStyle3.getLevels().get(0).getCharacterFormat().setFontName("Wingdings");
        document.getListStyles().add(listStyle3);

        // Create and configure ListStyle 4
        ListStyle listStyle4 = new ListStyle(document, ListType.Bulleted);
        listStyle4.setName("listStyle4");
        listStyle4.getLevels().get(0).setBulletCharacter(ASCII2String(0x00d8));
        listStyle4.getLevels().get(0).getCharacterFormat().setFontName("Wingdings");
        document.getListStyles().add(listStyle4);

        // Add Paragraph 1 to the section and apply ListStyle 1
        Paragraph p1 = section.getBody().addParagraph();
        p1.appendText("Spire.Doc for Java");
        p1.getListFormat().applyStyle(listStyle1.getName());

        // Add Paragraph 2 to the section and apply ListStyle 2
        Paragraph p2 = section.getBody().addParagraph();
        p2.appendText("Spire.Doc for Java");
        p2.getListFormat().applyStyle(listStyle2.getName());

        // Add Paragraph 3 to the section and apply ListStyle 3
        Paragraph p3 = section.getBody().addParagraph();
        p3.appendText("Spire.Doc for Java");
        p3.getListFormat().applyStyle(listStyle3.getName());

        // Add Paragraph 4 to the section and apply ListStyle 4
        Paragraph p4 = section.getBody().addParagraph();
        p4.appendText("Spire.Doc for Java");
        p4.getListFormat().applyStyle(listStyle4.getName());

        // Set the output file path
        String output = "output/ASCIICharactersBulletStyle_output.docx";

        // Save the document to the output file in Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Release the resources associated with the document
        document.dispose();
    }

    // Method to convert ASCII value to a string
    public static String ASCII2String(int ascii) {
        return String.valueOf((char) ascii);
    }
}
