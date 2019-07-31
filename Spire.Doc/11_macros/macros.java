import com.spire.doc.*;

public class macros {
    public static void main(String[] args) {
        String input = "data/macros.docm";
        String output = "output/macros.docm";

        //load Word document which contains macro
        Document doc = new Document();
        doc.loadFromFile(input, FileFormat.Docm);

        //save the file
        doc.saveToFile(output,FileFormat.Docm);
    }
}
