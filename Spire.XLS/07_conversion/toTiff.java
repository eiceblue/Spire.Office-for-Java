import com.spire.xls.*;

import java.io.IOException;

public class toTiff {
    public static void main(String[] args) throws IOException {
        //Create a Workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/toTiffTemplate.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Save the first worksheet to tiff
        String outputName="output/toTiffResult.tif";
        sheet.saveToTiff(outputName);

    }
}
