import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.io.*;
import java.math.*;
import java.util.*;

public class getContentControlProperty {
    public static void main(String[] args) throws IOException {
        // Create a new document object
        Document doc = new Document();

        // Load content from a Word document file
        doc.loadFromFile("data/contentControl.docx");

        // Declare variables for storing properties
        String alias;
        BigDecimal id;
        String tag;
        String sdtType;
        SdtType sdt = SdtType.Rich_Text;
        String content = "";

        // Get all structure tags from the document
        structureTags structureTags = GetAllTags(doc);

        // Create a header for the property data
        String property = "Alias of contentControl" + "\t" + "ID          " + "\t" + "Tag             " + "\t" + "STDType        " +"\t"+"Content        " +  "\r\n";

        Paragraph paragraph;
        TextRange textRange;

        // Process inline structure tags
        List<StructureDocumentTagInline> tagInlines = structureTags.getM_tagInlines();
        for (int i = 0; i < tagInlines.size(); i++) {
            // Retrieve properties of the structure tag
            alias = tagInlines.get(i).getSDTProperties().getAlias();
            id = tagInlines.get(i).getSDTProperties().getId();
            tag = tagInlines.get(i).getSDTProperties().getTag();
            sdt = tagInlines.get(i).getSDTProperties().getSDTType();
            sdtType = sdt.toString();

            // Check if the structure tag contains rich text or plain text
            if (sdt == SdtType.Rich_Text || sdt == SdtType.Text) {
                if (tagInlines.get(i).getChildObjects().getCount() > 0) {
                    // Iterate through child objects within the structure tag
                    for (int k = 0; k < tagInlines.get(i).getChildObjects().getCount(); k++) {
                        if (tagInlines.get(i).getChildObjects().get(k).getDocumentObjectType() == DocumentObjectType.Text_Range) {
                            // Retrieve text content from a text range object
                            textRange = (TextRange) tagInlines.get(i).getChildObjects().get(k);
                            content += textRange.getText();
                        }
                    }
                }
            }

            // Append the property data to the string
            property += alias + ",\t" + id + ",\t" + tag + ",\t" + sdtType + ",\t" + content + "\r\n";

            // Reset the content variable
            content="";
        }

        // Process other structure tags
        List<StructureDocumentTag> tags = structureTags.getM_tags();
        for (int i = 0; i < tags.size(); i++) {
            // Retrieve properties of the structure tag
            alias = tags.get(i).getSDTProperties().getAlias();
            id = tags.get(i).getSDTProperties().getId();
            tag = tags.get(i).getSDTProperties().getTag();
            sdt = tags.get(i).getSDTProperties().getSDTType();
            sdtType = sdt.toString();

            // Check if the structure tag contains rich text or plain text
            if (sdt == SdtType.Rich_Text || sdt == SdtType.Text) {
                if (tags.get(i).getChildObjects().getCount() > 0) {
                    // Iterate through child objects within the structure tag
                    for (int k = 0; k < tags.get(i).getChildObjects().getCount(); k++) {
                        if (tags.get(i).getChildObjects().get(k).getDocumentObjectType() == DocumentObjectType.Paragraph) {
                            // Retrieve text content from a paragraph object
                            paragraph = (Paragraph) tags.get(i).getChildObjects().get(k);
                            content += paragraph.getText();
                        }
                    }
                }
            }

            // Append the property data to the string
            property += alias + ",\t" + id + ",\t" + tag + ",\t" + sdtType + ",\t" + content + "\r\n";

            // Reset the content variable
            content="";
        }

        // Get all the row tags from structureTags
        List<StructureDocumentTagRow> rowtags = structureTags.getM_rowtags();

        // Iterate over each row tag
        for (int i = 0; i < rowtags.size(); i++) {
            alias = rowtags.get(i).getSDTProperties().getAlias();
            id = rowtags.get(i).getSDTProperties().getId();
            tag = rowtags.get(i).getSDTProperties().getTag();
            sdt = rowtags.get(i).getSDTProperties().getSDTType();
            sdtType = sdt.toString();

            // Check if the SDT type is Rich_Text or Text
            if (sdt == SdtType.Rich_Text || sdt == SdtType.Text) {
                // Check if the row tag has child objects
                if (rowtags.get(i).getChildObjects().getCount() > 0) {
                    // Iterate over each child object of the row tag
                    for (int k = 0; k < rowtags.get(i).getChildObjects().getCount(); k++) {
                        // Check if the child object is a Paragraph
                        if (rowtags.get(i).getChildObjects().get(k).getDocumentObjectType() == DocumentObjectType.Paragraph) {
                            paragraph = (Paragraph)rowtags.get(i).getChildObjects().get(k);
                            content += paragraph.getText();
                        }
                    }
                }
            }

            // Append the property details to the output string
            property += alias + ",\t" + id + ",\t" + tag + ",\t" + sdtType + ",\t" + content + "\r\n";
            content="";
        }

        // Get all the cell tags from structureTags
        List<StructureDocumentTagCell> celltags = structureTags.getM_celltags();

        // Iterate over each cell tag
        for (int i = 0; i < celltags.size(); i++) {
            alias = celltags.get(i).getSDTProperties().getAlias();
            id = celltags.get(i).getSDTProperties().getId();
            tag = celltags.get(i).getSDTProperties().getTag();
            sdt = celltags.get(i).getSDTProperties().getSDTType();
            sdtType = sdt.toString();

            // Check if the SDT type is Rich_Text or Text
            if (sdt == SdtType.Rich_Text || sdt == SdtType.Text) {
                // Check if the cell tag has child objects
                if (celltags.get(i).getChildObjects().getCount() > 0) {
                    // Iterate over each child object of the cell tag
                    for (int k = 0; k < celltags.get(i).getChildObjects().getCount(); k++) {
                        // Check if the child object is a Paragraph
                        if (celltags.get(i).getChildObjects().get(k).getDocumentObjectType() == DocumentObjectType.Paragraph) {
                            paragraph = (Paragraph)celltags.get(i).getChildObjects().get(k);
                            content += paragraph.getText();
                        }
                    }
                }
            }

            // Append the property details to the output string
            property += alias + ",\t" + id + ",\t" + tag + ",\t" + sdtType + ",\t" + content + "\r\n";
            content="";
        }

        // Write the property string to a file
        String output = "output/getContentControlProperty1.txt";
        File file = new File(output);
        if (!file.exists()) {
            file.delete();
        }

        // Create a new file and write the content to it.
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(property);
        bw.flush();
        bw.close();
        fw.close();

        // Dispose the document
        doc.dispose();
    }

    public static structureTags GetAllTags(Document document) {
        // Create a new instance of StructureTags
        structureTags structureTags = new structureTags();

        // Iterate over each section in the document
        for (int i = 0; i < document.getSections().getCount(); i++) {
            Section section = document.getSections().get(i);

            // Iterate over each child object in the section's body
            for (int j = 0; j < section.getBody().getChildObjects().getCount(); j++) {
                DocumentObject obj = section.getBody().getChildObjects().get(j);

                // Check if the child object is a Structure_Document_Tag
                if (obj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag) {
                    structureTags.getM_tags().add((StructureDocumentTag)obj);
                }
                // Check if the child object is a Paragraph
                else if (obj.getDocumentObjectType() == DocumentObjectType.Paragraph) {
                    Paragraph para = (Paragraph)obj;

                    // Iterate over each child object in the paragraph
                    for (int k = 0; k < para.getChildObjects().getCount(); k++) {
                        DocumentObject pobj = para.getChildObjects().get(k);

                        // Check if the child object is a Structure_Document_Tag_Inline
                        if (pobj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Inline) {
                            structureTags.getM_tagInlines().add((StructureDocumentTagInline)pobj);
                        }
                    }
                }
                // Check if the child object is a Table
                else if (obj.getDocumentObjectType() == DocumentObjectType.Table) {
                    Table table = (Table)obj;

                    // Iterate over each row in the table
                    for(int r = 0; r < table.getRows().getCount(); r++) {
                        // Check if the row is a Structure_Document_Tag_Row
                        if (table.getRows().get(r).getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Row) {
                            structureTags.getM_rowtags().add((StructureDocumentTagRow)(table.getRows().get(r)));
                        }

                        TableRow row = table.getRows().get(r);

                        // Iterate over each cell in the row
                        for (int c = 0; c < row.getCells().getCount(); c++) {
                            // Check if the cell is a Structure_Document_Tag_Cell
                            if (row.getCells().get(c).getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Cell) {
                                structureTags.getM_celltags().add((StructureDocumentTagCell)(row.getCells().get(c)));
                            }

                            TableCell cell = row.getCells().get(c);

                            // Iterate over each child object in the cell
                            for (int s = 0; s < cell.getChildObjects().getCount(); s++) {
                                DocumentObject cellChild = cell.getChildObjects().get(s);

                                // Check if the child object is a Structure_Document_Tag
                                if (cellChild.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag) {
                                    structureTags.getM_tags().add((StructureDocumentTag)cellChild);
                                }
                                // Check if the child object is a Paragraph
                                else if (cellChild.getDocumentObjectType() == DocumentObjectType.Paragraph) {
                                    Paragraph para = (Paragraph)cellChild;

                                    // Iterate over each child object in the paragraph
                                    for (int t = 0; t < para.getChildObjects().getCount(); t++) {
                                        DocumentObject pobj = para.getChildObjects().get(t);

                                        // Check if the child object is a Structure_Document_Tag_Inline
                                        if (pobj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Inline) {
                                            structureTags.getM_tagInlines().add((StructureDocumentTagInline)pobj);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return structureTags;
    }
}

class structureTags {
    private List<StructureDocumentTagInline> m_tagInlines;

    public void setM_tagInlines(List<StructureDocumentTagInline> m_tagInlines) {
        this.m_tagInlines = m_tagInlines;
    }

    public List<StructureDocumentTagInline> getM_tagInlines() {
        if (m_tagInlines == null)
            m_tagInlines = new ArrayList<StructureDocumentTagInline>();
        return m_tagInlines;
    }

    private List<StructureDocumentTag> m_tags;

    public List<StructureDocumentTag> getM_tags() {
        if (m_tags == null)
            m_tags = new ArrayList<StructureDocumentTag>();
        return m_tags;
    }

    public void setM_tags(List<StructureDocumentTag> m_tags) {
        this.m_tags = m_tags;
    }

    private List<StructureDocumentTagRow> m_rowtags;

    public List<StructureDocumentTagRow> getM_rowtags() {
        if (m_rowtags == null)
            m_rowtags = new ArrayList<StructureDocumentTagRow>();
        return m_rowtags;
    }

    public void setM_rowtags(List<StructureDocumentTagRow> m_rowtags) {
        this.m_rowtags = m_rowtags;
    }
    private List<StructureDocumentTagCell> m_celltags;

    public List<StructureDocumentTagCell> getM_celltags() {
        if (m_celltags == null)
            m_celltags = new ArrayList<StructureDocumentTagCell>();
        return m_celltags;
    }

    public void setM_celltags(List<StructureDocumentTagCell> m_celltags) {
        this.m_celltags = m_celltags;
    }
}

