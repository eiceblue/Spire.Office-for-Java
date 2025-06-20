import com.spire.pdf.*;

public class SaveMultiplePagesToOneSvg {
    public static void main(String[] args) {
        // Path to the input and output PDF document
        String inputPath = "data/Sample.pdf";
        String OutputPath = "output/oneSvg.svg";

        //Create a pdf document and load file from disk
        PdfDocument document = new PdfDocument();
        document.loadFromFile(inputPath);

        //Convert the multi-page PDF document to a single SVG file
        document.getConvertOptions().setOutputToOneSvg(true);

        //Save the pdf document to Svg document
        document.saveToFile(OutputPath, FileFormat.SVG);       

        // Close the document
        document.close();

        // Dispose of the resources used by the document
        document.dispose();
    }
}
