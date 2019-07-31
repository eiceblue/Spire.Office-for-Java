import com.spire.pdf.*;

public class toSVG {
    public static void main(String[] args) {
        String inputFile = "data/toSVG.pdf";
        String outputFile = "output/toSVG_result.svg";

        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Convert to svg file
        doc.saveToFile(outputFile, FileFormat.SVG);
        doc.close();
    }
}
