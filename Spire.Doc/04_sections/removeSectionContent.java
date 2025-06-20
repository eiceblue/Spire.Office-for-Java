import com.spire.doc.*;
public class removeSectionContent {
    public static void main(String[] args) {
        //Create word document.
        Document doc = new Document();

        // Load the document from disk.
        doc.loadFromFile("data/Template_N3.docx");

        // Loop through all sections
        for (Object sectionObj : doc.getSections()) {
            Section section = (Section)sectionObj;

            // Remove header content
            section.getHeadersFooters().getHeader().getChildObjects().clear();

            // Remove body content
            section.getBody().getChildObjects().clear();

            // Remove footer content
            section.getHeadersFooters().getFooter().getChildObjects().clear();
        }

        String output = "output/removeSectionContent.docx";

        //Save to file
        doc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the document
        doc.dispose();
    }
}
