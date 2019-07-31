import com.spire.doc.*;

public class toXML {
    public static void main(String[] args) {

        String inputFile="data/toXML.doc";
        String outputFile="output/toXML.xml";

        Document document = new Document();
        document.loadFromFile(inputFile);
        document.saveToFile(outputFile, FileFormat.Xml );
    }
}
