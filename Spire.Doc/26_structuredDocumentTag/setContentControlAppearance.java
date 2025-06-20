import com.spire.doc.*;
import com.spire.doc.documents.*;

public class setContentControlAppearance {
    public static void main(String[] args) {
        //Create a new document
        Document doc = new Document();

        // Load from file
        doc.loadFromFile("data/contentControl.docx");
        
        //Traverse all content controls
        for (Object sectionObj : doc.getSections()) {
            Section section = (Section) sectionObj;
            for (Object docObj : section.getBody().getChildObjects()) {
                // Get  structureTag in the Word document
                if (docObj instanceof StructureDocumentTag) {
                    DocumentObject Obj = (DocumentObject) docObj;
                    SDTProperties sdtProperties = ((StructureDocumentTag) Obj).getSDTProperties();
                    // Set appearance of the content control
                    switch (sdtProperties.getSDTType()) {
                        //Set appearance as "Hidden"
                        case Text:
                            sdtProperties.setAppearance(SdtAppearance.Hidden);
                            break;
                        //Set appearance as "BoundingBox"
                        case Rich_Text:
                            sdtProperties.setAppearance(SdtAppearance.Bounding_Box);
                            break;
                        //Set appearance as "Tags"
                        case Picture:
                            sdtProperties.setAppearance(SdtAppearance.Tags);
                            break;
                        //Set appearance as "Default"
                        case Check_Box:
                            sdtProperties.setAppearance(SdtAppearance.Default);
                            break;
                    }
                }
            }
        }
        //save the document
        String result = "output/SetContentControlAppearance.docx";
        doc.saveToFile(result, FileFormat.Docx);

        // Dispose the document
        doc.dispose();
    }
}
