import com.spire.doc.*;

public class setPositionAndNumberFormat {
    public static void main(String[] args) {
        // Load the document
        Document doc = new Document();
        doc.loadFromFile("data/footnote.docx");

        // Get the first section
        Section sec = doc.getSections().get(0);

        // Set the number format
        sec.getFootnoteOptions().setNumberFormat(FootnoteNumberFormat.Upper_Case_Letter);

        // Set the restart rule
        sec.getFootnoteOptions().setRestartRule(FootnoteRestartRule.Restart_Page);

        // Set the restart rule
        sec.getFootnoteOptions().setPosition(FootnotePosition.Print_As_End_Of_Section);

        //Save the document
        String output = "output/setPositionAndNumberFormat.docx";
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        doc.dispose();
    }
}
