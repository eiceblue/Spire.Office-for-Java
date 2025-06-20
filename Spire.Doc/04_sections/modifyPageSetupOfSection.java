import com.spire.doc.*;
import com.spire.doc.documents.*;

public class modifyPageSetupOfSection {
    public static void main(String[] args) {
        //Create word document.
        Document doc = new Document();

        // Load the document from disk.
        doc.loadFromFile("data/Template_N2.docx");

        // Loop through all sections
        for (Object sectionObj : doc.getSections()) {
            Section section = (Section)sectionObj;
            // Modify the margins
            section.getPageSetup().setMargins(new MarginsF(100, 80, 100, 80));

            // Modify the page size
            section.getPageSetup().setPageSize(PageSize.Letter);
        }

        String output = "output/modifyPageSetupOfSection.docx";

        //Save to file
        doc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the document
        doc.dispose();
    }
}
