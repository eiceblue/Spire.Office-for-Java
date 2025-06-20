import com.spire.presentation.*;

public class convertODPtoPDF {

    public static void main(String[] args) throws Exception {
        Presentation presentation = new Presentation();

        //Load ODP file from disk
        presentation.loadFromFile("data/toPdf.odp", FileFormat.ODP);

        String result = "output/ConvertODPtoPDF_result.pdf";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PDF);
    }
}
