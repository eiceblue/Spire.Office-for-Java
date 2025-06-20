import com.spire.doc.*;

public class cloneSection {
    public static void main(String[] args) {
        //Create the source word document.
        Document srcDoc = new Document();

        // Load the document from disk.
        srcDoc.loadFromFile("data/SectionTemplate.docx");

        //Create the destination word document.
        Document desDoc = new Document();

        // Initializes a section with a null value.
        Section cloneSection = null;

        for (Object sectionObj : srcDoc.getSections()) {
            Section section = (Section)sectionObj;
            // Clone section
            cloneSection = section.deepClone();
            // Add the cloneSection in destination file
            desDoc.getSections().add(cloneSection);
        }

        String output = "output/cloneSection.docx";

        //Save to file.
        desDoc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the documents
        srcDoc.dispose();
        desDoc.dispose();
    }
}
