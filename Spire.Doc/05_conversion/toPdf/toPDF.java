import com.spire.doc.*;

public class toPDF {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/toPDF.pdf";

        //create word document
        Document document = new Document();
        document.loadFromFile(inputFile);

        //save the document to a PDF file.
        document.saveToFile(outputFile, FileFormat.PDF);
    }
}
