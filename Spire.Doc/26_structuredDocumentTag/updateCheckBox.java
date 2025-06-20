import com.spire.doc.*;
import com.spire.doc.documents.*;

import java.util.*;

public class updateCheckBox {
    public static void main(String[] args) {
        //Create a document
        Document document = new Document();

        //Load the document from disk.
        document.loadFromFile("data/checkBoxContentControl.docx");

        //Call StructureTags
        StructureTagInLines structureTags = GetAllTags(document);

        //Create list
        List<StructureDocumentTagInline> tagInlines = structureTags.getM_tagInlines();

        //Get the controls
        for (int i = 0; i < tagInlines.size(); i++)
        {
            //Get the type
            String type = tagInlines.get(i).getSDTProperties().getSDTType().toString();

            //Update the status
            if ("Check_Box".equals(type))
            {
                // Get the sdtCheckBox
                SdtCheckBox scb = (SdtCheckBox)tagInlines.get(i).getSDTProperties().getControlProperties() ;

                // Judge the status
                if (scb.getChecked())
                {
                    scb.setChecked(false);
                }
                else
                {
                    scb.setChecked(true);
                }
            }

        }
        //Save the document
        String output = "output/updateCheckBox.docx";
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        document.dispose();
    }

    public static StructureTagInLines GetAllTags(Document document) {
        StructureTagInLines structureTags = new StructureTagInLines();

        // Iterate through the sections of the document
        for (int i = 0; i < document.getSections().getCount(); i++) {
            Section section = document.getSections().get(i);

            // Iterate through the child objects in the body of each section
            for (int j = 0; j < section.getBody().getChildObjects().getCount(); j++){
                DocumentObject obj = section.getBody().getChildObjects().get(j);

                // Check if the child object is a paragraph
                if(obj.getDocumentObjectType() == DocumentObjectType.Paragraph) {

                    // Iterate through the child objects of the paragraph
                    for (int k = 0; k < ((Paragraph)obj).getChildObjects().getCount(); k++) {
                        DocumentObject pobj = ((Paragraph)obj).getChildObjects().get(k);

                        // Check if the child object is a StructureDocumentTagInline
                        if (pobj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Inline) {
                            // If it is, add it to the list of tagInlines
                            structureTags.getM_tagInlines().add((StructureDocumentTagInline)pobj);
                        }
                    }
                }
            }
        }

        // Return the StructureTagInLines object containing all the retrieved StructureDocumentTagInline objects
        return structureTags;
    }
}

class StructureTagInLines {
    private List<StructureDocumentTagInline> m_tagInlines;

    public void setM_tagInlines(List<StructureDocumentTagInline> m_tagInlines) {
        this.m_tagInlines = m_tagInlines;
    }

    public List<StructureDocumentTagInline> getM_tagInlines() {
        if (m_tagInlines == null)
            m_tagInlines = new ArrayList<StructureDocumentTagInline>();
        return m_tagInlines;
    }
}
