import com.spire.pdf.*;

public class toXPS {
    public static void main(String[] args) {
        String inputFile = "data/toXPS.pdf";
        String outputFile = "output/toXPS_result.xps";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        //Convert to xps file.
        pdf.saveToFile(outputFile, FileFormat.XPS);
        pdf.close();
    }
}
