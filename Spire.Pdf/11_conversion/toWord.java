import com.spire.pdf.*;

public class toWord {
    public static void main(String[] args) {
        String inputFile = "data/toWord.pdf";
        String outputFile = "output/toWord_result.docx";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);
        pdf.saveToFile(outputFile,FileFormat.DOCX);
    }
}
