import com.spire.pdf.*;
import java.io.*;
import com.spire.pdf.exporting.text.IOCR;

public class extractTextByOCRFunction {
    public static void main(String[] args) throws Exception{
        String inputPath = "data/OCR.pdf";
        String outputFile = "output/ocrFunction.txt";

        IOCR loIOCR=(image)->{
            String extractedText = "";
            //OCR API
            //extractedText = ...
            return extractedText;
        };
        PdfDocument.setExportTextOCRHandler(loIOCR);
        PdfDocument pdf=new PdfDocument();
        pdf.loadFromFile(inputPath);
        String text = "";
        for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
            text += page.extractText();
        }
        FileWriter sw = new FileWriter(outputFile);
        sw.write(text);
        sw.flush();
        sw.close();
        pdf.close();
    }
}
