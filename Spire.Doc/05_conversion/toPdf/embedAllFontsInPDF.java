import com.spire.doc.*;

public class embedAllFontsInPDF {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/embedAllFontsInPDF.pdf";

        Document document = new Document();
        document.loadFromFile(inputFile);

        //embeds full fonts by default when IsEmbeddedAllFonts is set to true.
        ToPdfParameterList ppl=new ToPdfParameterList();
        ppl.isEmbeddedAllFonts(true);

        //save to pdf.
        document.saveToFile(outputFile, ppl);
    }
}
