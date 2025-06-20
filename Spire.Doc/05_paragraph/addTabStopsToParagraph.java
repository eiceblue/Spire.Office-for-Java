import com.spire.doc.*;
import com.spire.doc.documents.*;

public class addTabStopsToParagraph {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Add a section.
        Section section = document.addSection();

        //Add paragraph 1.
        Paragraph paragraph1 = section.addParagraph();

        //Add tab and set its position (in points).
        Tab tab = paragraph1.getFormat().getTabs().addTab(28);

        // Set tab alignment.
        tab.setJustification(TabJustification.Left);

        // Move to next tab and append text.
        paragraph1.appendText("\tWashing Machine");

        // Add another tab and set its position (in points).
        tab = paragraph1.getFormat().getTabs().addTab(280);

        // Set tab alignment.
        tab.setJustification(TabJustification.Left);

        // Specify tab leader type.
        tab.setTabLeader(TabLeader.Dotted);

        // Move to next tab and append text.
        paragraph1.appendText("\t$650");

        //Add paragraph 2.
        Paragraph paragraph2 = section.addParagraph();

        // Add tab and set its position (in points).
        tab = paragraph2.getFormat().getTabs().addTab(28);

        // Set tab alignment.
        tab.setJustification(TabJustification.Left);

        // Move to next tab and append text.
        paragraph2.appendText("\tRefrigerator");

        // Add another tab and set its position (in points).
        tab = paragraph2.getFormat().getTabs().addTab(280);

        // Set tab alignment.
        tab.setJustification(TabJustification.Left);

        // Specify tab leader type.
        tab.setTabLeader(TabLeader.No_Leader);

        // Move to next tab and append text.
        paragraph2.appendText("\t$800");

        String result = "output/addTabStopsToParagraph.docx";

        // Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
