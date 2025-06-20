import com.spire.doc.*;
import com.spire.doc.documents.*;
import static java.awt.Color.*;

public class modifySDTColor {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document doc = new Document();

        // Load the document from a file
        doc.loadFromFile("data/ModifySTDColor.docx");

        // Iterate over each section in the document
        for (int s = 0; s < doc.getSections().getCount(); s++) {
            Section section = doc.getSections().get(s);

            // Iterate over each child object in the section's body
            for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++) {

                // Check if the child object is a Paragraph
                if (section.getBody().getChildObjects().get(i) instanceof Paragraph) {
                    Paragraph para = (Paragraph) section.getBody().getChildObjects().get(i);

                    // Iterate over each child object in the paragraph
                    for (int j = 0; j < para.getChildObjects().getCount(); j++) {

                        // Check if the child object is a StructureDocumentTagInline
                        if (para.getChildObjects().get(j) instanceof StructureDocumentTagInline) {
                            StructureDocumentTagInline sdt = (StructureDocumentTagInline) para.getChildObjects().get(j);
                            SDTProperties sdtProperties = sdt.getSDTProperties();

                            // Update the color based on the SDT type
                            switch (sdtProperties.getSDTType()){
                                case Rich_Text:
                                    sdtProperties.setColor(ORANGE);
                                    break;
                                case Text:
                                    sdtProperties.setColor(GREEN);
                                    break;
                            }
                        }
                    }
                }

                // Check if the child object is a StructureDocumentTag
                if (section.getBody().getChildObjects().get(i) instanceof StructureDocumentTag) {
                    StructureDocumentTag sdt = (StructureDocumentTag) section.getBody().getChildObjects().get(i);
                    SDTProperties sdtProperties = sdt.getSDTProperties();

                    // Update the color based on the SDT type
                    switch (sdtProperties.getSDTType()){
                        case Rich_Text:
                            sdtProperties.setColor(ORANGE);
                            break;
                        case Text:
                            sdtProperties.setColor(GREEN);
                            break;
                    }
                }
            }
        }

        // Save the modified document to a file
        String output = "output/ModifySTDColor_out.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document object
        doc.dispose();
    }
}
