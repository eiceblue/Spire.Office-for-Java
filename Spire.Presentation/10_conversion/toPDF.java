import com.spire.presentation.*;

public class toPDF {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/toPDF.pptx";
        String outputFile="output/toPDF_result.pdf";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Save the PPT to PDF file format
        ppt.saveToFile(outputFile, FileFormat.PDF);
        ppt.dispose();
    }
}
