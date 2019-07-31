import com.spire.doc.*;

public class toOdt {
    public static void main(String[] args) {
        String input = "data/convertedTemplate.docx";
        String output = "output/toOdt.odt";
        //load Word document
        Document document= new Document();
        document.loadFromFile(input);

        //save the document to odt format
        document.saveToFile(output, FileFormat.Odt);
    }
}
