import com.spire.pdf.*;

public class toHTML {
    public static void main(String[] args) {
        String inputFile = "data/toHTML.pdf";
        String outputFile = "output/toHTML_result.html";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);
        pdf.saveToFile(outputFile,FileFormat.HTML);
    }
}
