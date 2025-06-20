import com.spire.doc.*;
import com.spire.doc.documents.*;

import java.awt.*;

public class differentPageSetup {
    public static void main(String[] args) {
        // Create a new Document object and load the document "DifferentPageSetup.docx" from the specified path
        Document doc = new Document("data/DifferentPageSetup.docx");

        // Retrieve the first section of the document
        Section sectionOne = doc.getSections().get(0);

        // Set the orientation of the first section to Landscape
        sectionOne.getPageSetup().setOrientation(PageOrientation.Landscape);

        // Retrieve the second section of the document
        Section sectionTwo = doc.getSections().get(1);

        // Set the page size of the second section to a custom dimension of 800x800
        sectionTwo.getPageSetup().setPageSize(new Dimension(800, 800));

        // Specify the output file path for the modified document
        String result = "output/result-differentPageSetup.docx";

        // Save the modified document to the specified file path in the Docx_2013 format
        doc.saveToFile(result, FileFormat.Docx_2013);

        // Dispose of the doc object to release resources
        doc.dispose();
    }
}
