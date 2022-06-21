import com.spire.xls.*;

import java.io.IOException;

public class toImageWithHighResolution {
    public static void main(String[] args) throws IOException {
        //Create a Workbook
        Workbook workbook = new Workbook();
        //Load the document from disk
        workbook.loadFromFile("data/imageResolutionTemplate.xlsx");
         //Iterate through all the worksheets
        for (int i = 0; i < workbook.getWorksheets().size(); i++) {
            Worksheet sheet = workbook.getWorksheets().get(i);
            //Set the image resolution
            workbook.getConverterSetting().setXDpi(300);
            workbook.getConverterSetting().setYDpi(300);
            //Save the image
            sheet.saveToImage( "output/imageResolution-" + i + ".png");
        }
    }
}
