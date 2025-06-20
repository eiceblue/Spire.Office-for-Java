import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class removeFootnote {
    public static void main(String[] args) {
        // Create a Document object
        Document document = new Document();

        // Load the file
        document.loadFromFile("data/footnote.docx");

        // Get the first section from the document
        Section section = document.getSections().get(0);

        // Traverse through each paragraph in the section to find footnotes
        for (int i = 0; i < section.getParagraphs().getCount(); i++) {
            Paragraph para = section.getParagraphs().get(i);
            int index = -1;

            // Iterate over child objects in the paragraph to find a Footnote
            for (int j = 0, cnt = para.getChildObjects().getCount(); j < cnt; j++) {
                ParagraphBase pBase = (ParagraphBase) para.getChildObjects().get(j);

                // Check if the current object is a Footnote
                if (pBase instanceof Footnote) {
                    index = j;
                    break;
                }
            }

            // If a Footnote is found, remove it from the paragraph's child objects
            if (index > -1)
                para.getChildObjects().removeAt(index);
        }

        // Specify the output file path and save the modified document
        String output = "output/removeFootnote.docx";
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources
        document.dispose();
    }
}
