import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.io.*;
public class getParagraphByStyleName {
    public static void main(String[] args) throws Exception{
        //Create Word document.
        Document document = new Document();

        // Load the file from disk.
        document.loadFromFile("data/Template_Docx_3.docx");

        String result = "output/getParagraphByStyleName.txt";
        File file=new File(result);
        if(!file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        bw.write("Get paragraphs by style name \"Heading1\": ");

        // Get paragraphs by style name.
        for (Object sectionObj : document.getSections()) {
            Section section = (Section)sectionObj;
            for (Object paragraphObj: section.getParagraphs()) {
                Paragraph paragraph = (Paragraph)paragraphObj;
                if ((paragraph.getStyleName().equals("Heading1"))) {
                    //Extract text
                    bw.write(paragraph.getText());
                }
            }
        }

        //Flush buffer
        bw.flush();

        //Close the stream
        bw.close();
        fw.close();

        //Dispose the document
        document.dispose();
    }
}
