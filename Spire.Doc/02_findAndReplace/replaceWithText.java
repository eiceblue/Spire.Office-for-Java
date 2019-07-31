import com.spire.doc.*;

public class replaceWithText {
    public static void main(String[] args) {
        String input = "data/replaceWithText.docx";
        String output = "output/replaceWithText.docx";
        //load Word document
        Document document = new Document();
        document.loadFromFile(input, FileFormat.Docx);

        //replace the text
        document.replace("Word", "ReplacedText", false, true);

        //save the document
        document.saveToFile(output,FileFormat.Docx);
    }
}
