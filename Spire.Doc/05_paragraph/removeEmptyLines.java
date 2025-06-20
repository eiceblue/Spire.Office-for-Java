import com.spire.doc.*;
import com.spire.doc.documents.*;
public class removeEmptyLines {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_3.docx");

        //Traverse every section on the Word document and remove the null and empty paragraphs.
        for (Object sectionObj : document.getSections()) {
            Section section=(Section)sectionObj;

            //Get child objects
            for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++) {

                //Judge the type equals Paragraph or not
                if ((section.getBody().getChildObjects().get(i).getDocumentObjectType().equals(DocumentObjectType.Paragraph) )) {
                   String s= ((Paragraph)(section.getBody().getChildObjects().get(i))).getText().trim();
                    if (s.isEmpty()) {

                        //Remove the empty paragraph
                        section.getBody().getChildObjects().remove(section.getBody().getChildObjects().get(i));
                        i--;
                    }
                }
            }
        }

        String result = "output/removeEmptyLines.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
