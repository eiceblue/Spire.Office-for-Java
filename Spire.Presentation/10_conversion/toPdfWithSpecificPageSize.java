
import com.spire.presentation.*;

public class toPdfWithSpecificPageSize {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/toPDF.pptx";
        String outputFile="output/toPdfWithSpecificPageSize_result.pdf";

        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Set A4 page size
        ppt.getSlideSize().setType(SlideSizeType.A4);

        //Save the PPT to PDF file format
        ppt.saveToFile(outputFile, FileFormat.PDF);
        ppt.dispose();
    }
}
