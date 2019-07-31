import com.spire.pdf.*;

public class changePdfVersion {
    public static void main(String[] args) {
        String inputFile = "data/changePdfVersion.pdf";
        String outputFile = "output/pdfChangePdfVersion_result.pdf";

        //Open pdf document
        PdfDocument document = new PdfDocument();
        document.loadFromFile(inputFile);

        //Change the pdf version and save
        document.getFileInfo().setVersion(PdfVersion.Version_1_6);
        document.saveToFile(outputFile, FileFormat.PDF);
        document.close();
    }
}
