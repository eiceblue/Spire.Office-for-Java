import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.util.ArrayList;
import java.util.List;

public class removeContentControlTagAfterEdited {
    public static void main(String[] args)  {

        // Create a new Document object
        Document doc = new Document();

        // Load the document from a file
        doc.loadFromFile("data/ContentControl.docx");

        // Get all the structure tags in the document
        structureTags structureTags = GetAllTags(doc);

        // Remove ContentControl tags after editing for tagInlines
        List<StructureDocumentTagInline> tagInlines = structureTags.getM_tagInlines();
        for (int i = 0; i < tagInlines.size(); i++) {
            StructureDocumentTagInline std = tagInlines.get(i);
            std.getSDTProperties().isTemporary(true);
        }

        // Remove ContentControl tags after editing for tags
        List<StructureDocumentTag> tags = structureTags.getM_tags();
        for (int i = 0; i < tags.size(); i++) {
            StructureDocumentTag std = tags.get(i);
            std.getSDTProperties().isTemporary(true);
        }

        // Remove ContentControl tags after editing for rowTags
        List<StructureDocumentTagRow> rowTags = structureTags.getM_rowtags();
        for (int i = 0; i < rowTags.size(); i++) {
            StructureDocumentTagRow std = rowTags.get(i);
            std.getSDTProperties().isTemporary(true);
        }

        // Remove ContentControl tags after editing for cellTags
        List<StructureDocumentTagCell> cellTags = structureTags.getM_celltags();
        for (int i = 0; i < cellTags.size(); i++) {
            StructureDocumentTagCell std = cellTags.get(i);
            std.getSDTProperties().isTemporary(true);
        }

        // Save the modified document to a file
        String output = "output/DeleteStructureDataTagAfterEdited.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document object
        doc.dispose();
    }

    public static structureTags GetAllTags(Document document) {
        // Create a StructureTags
        structureTags structureTags = new structureTags();

        // Iterate through the sections of the document
        for (int i = 0; i < document.getSections().getCount(); i++) {
            Section section = document.getSections().get(i);

            // Iterate through the child objects in the body of each section
            for (int j = 0; j < section.getBody().getChildObjects().getCount(); j++) {
                DocumentObject obj = section.getBody().getChildObjects().get(j);

                // Check the type of the child object
                if (obj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag) {
                    // If it is a StructureDocumentTag, add it to the list of tags
                    structureTags.getM_tags().add((StructureDocumentTag) obj);
                } else if (obj.getDocumentObjectType() == DocumentObjectType.Paragraph) {
                    // If it is a Paragraph, iterate through its child objects
                    Paragraph para = (Paragraph) obj;
                    for (int k = 0; k < para.getChildObjects().getCount(); k++) {
                        DocumentObject pobj = para.getChildObjects().get(k);
                        if (pobj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Inline) {
                            // If it is a StructureDocumentTagInline, add it to the list of tagInlines
                            structureTags.getM_tagInlines().add((StructureDocumentTagInline) pobj);
                        }
                    }
                } else if (obj.getDocumentObjectType() == DocumentObjectType.Table) {
                    // If it is a Table, iterate through its rows and cells
                    Table table = (Table) obj;
                    for (int r = 0; r < table.getRows().getCount(); r++) {
                        if (table.getRows().get(r).getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Row) {
                            // If it is a StructureDocumentTagRow, add it to the list of rowTags
                            structureTags.getM_rowtags().add((StructureDocumentTagRow) (table.getRows().get(r)));
                        }
                        TableRow row = table.getRows().get(r);
                        for (int c = 0; c < row.getCells().getCount(); c++) {
                            if (row.getCells().get(c).getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Cell) {
                                // If it is a StructureDocumentTagCell, add it to the list of cellTags
                                structureTags.getM_celltags().add((StructureDocumentTagCell) (row.getCells().get(c)));
                            }
                            TableCell cell = row.getCells().get(c);
                            for (int s = 0; s < cell.getChildObjects().getCount(); s++) {
                                DocumentObject cellChild = cell.getChildObjects().get(s);
                                if (cellChild.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag) {
                                    // If it is a StructureDocumentTag, add it to the list of tags
                                    structureTags.getM_tags().add((StructureDocumentTag) cellChild);
                                } else if (cellChild.getDocumentObjectType() == DocumentObjectType.Paragraph) {
                                    // If it is a Paragraph, iterate through its child objects
                                    Paragraph para = (Paragraph) cellChild;
                                    for (int t = 0; t < para.getChildObjects().getCount(); t++) {
                                        DocumentObject pobj = para.getChildObjects().get(t);
                                        if (pobj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag_Inline) {
                                            // If it is a StructureDocumentTagInline, add it to the list of tagInlines
                                            structureTags.getM_tagInlines().add((StructureDocumentTagInline) pobj);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Return the StructureTags object containing all the retrieved tags
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
