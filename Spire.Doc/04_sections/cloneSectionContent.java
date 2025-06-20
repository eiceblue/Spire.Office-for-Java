import com.spire.doc.*;

public class cloneSectionContent {
    public static void main(String[] args) {
        //Create word document.
        Document doc = new Document();

        // Load the document from disk.
        doc.loadFromFile("data/SectionTemplate.docx");

        //Get the first section
        Section sec1 = doc.getSections().get(0);

        //Get the second section
        Section sec2 = doc.getSections().get(1);

        // Loop through the contents of sec1
        for (Object docObj : sec1.getBody().getChildObjects()) {
            DocumentObject obj=(DocumentObject)docObj;
            // Clone the contents to sec2
            sec2.getBody().getChildObjects().add(obj.deepClone());
        }

        String output = "output/cloneSectionContent.docx";

        //Save to file
        doc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the document
        doc.dispose();
    }
}
