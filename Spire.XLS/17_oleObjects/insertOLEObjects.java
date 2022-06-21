import com.spire.xls.*;
import com.spire.xls.core.IOleObject;

import java.awt.image.BufferedImage;

public class insertOLEObjects {
    public static void main(String[] args) {
        String xlsFile = "data/insertOLEObjects.xls";
        String outputFile="output/insertOLEObjects_result.xlsx";

        //Open xls document
        Workbook workbook = new Workbook();
        //Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);
        //Add text for A1
        worksheet.getCellRange("A1").setText("Here is an OLE Object.");
        //Generate image
        BufferedImage image = GenerateImage(xlsFile);
        //insert OLE object
        IOleObject oleObject = worksheet.getOleObjects().add(xlsFile, image, OleLinkType.Embed);
        oleObject.setLocation(worksheet.getCellRange("B4"));
        oleObject.setObjectType(OleObjectType.ExcelWorksheet);
        //save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
    private static BufferedImage GenerateImage(String fileName)
    {
        //Load file
        Workbook book = new Workbook();
        book.loadFromFile(fileName);
        //Set margins
        book.getWorksheets().get(0).getPageSetup().setLeftMargin(0);
        book.getWorksheets().get(0).getPageSetup().setRightMargin(0);
        book.getWorksheets().get(0).getPageSetup().setTopMargin(0);
        book.getWorksheets().get(0).getPageSetup().setBottomMargin(0);
        //Save sheet to image
        return book.getWorksheets().get(0).toImage(1, 1, 19, 5);
    }
}
