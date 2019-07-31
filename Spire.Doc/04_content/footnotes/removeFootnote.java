import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.*;

public class removeFootnote {
    public static void main(String[] args) {
        String input = "data/removeFootnote.docx";
        String output = "output/removeFootnote.docx";

        Document document = new Document();
        document.loadFromFile(input);
        Section section = document.getSections().get(0);

        //traverse paragraphs in the section and find the footnote
        for (int j = 0; j < section.getParagraphs().getCount(); j++) {
            Paragraph para = section.getParagraphs().get(j);
            int index = -1;
            for (int i = 0, cnt = para.getChildObjects().getCount(); i < cnt; i++) {
                ParagraphBase pBase = (ParagraphBase) para.getChildObjects().get(i);
                if (pBase instanceof Footnote) {
                    index = i;
                    break;
                }
            }

            if (index > -1)
                //remove the footnote
                para.getChildObjects().removeAt(index);
        }
        document.saveToFile(output, FileFormat.Docx);
    }
}
