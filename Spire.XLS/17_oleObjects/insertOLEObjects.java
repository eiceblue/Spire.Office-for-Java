import com.spire.xls.*;
import com.spire.xls.core.IOleObject;
import java.awt.image.BufferedImage;

public class insertOLEObjects {
    public static void main(String[] args) {
        String xlsFile = "data/insertOLEObjects.xls";
        String outputFile="output/insertOLEObjects_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Set the text of cell A1 to "Here is an OLE Object."
        worksheet.getCellRange("A1").setText("Here is an OLE Object.");

        // Generate an image from the xlsFile (not shown)
        BufferedImage image = GenerateImage(xlsFile);

        // Add an OLE object to the worksheet, embedding the xlsFile and using the generated image
        IOleObject oleObject = worksheet.getOleObjects().add(xlsFile, image, OleLinkType.Embed);

        // Set the location of the OLE object to cell B4
        oleObject.setLocation(worksheet.getCellRange("B4"));

        // Set the object type of the OLE object to ExcelWorksheet
        oleObject.setObjectType(OleObjectType.ExcelWorksheet);

        // Save the modified workbook to the specified output file path in Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release any resources used by the workbook
        workbook.dispose();
    }
    // Generate an image from a given file name
    private static BufferedImage GenerateImage(String fileName) {
        // Create a new Workbook object
        Workbook book = new Workbook();

        // Load the workbook from the specified file
        book.loadFromFile(fileName);

        // Set the left, right, top, and bottom margins of the first worksheet to 0
        book.getWorksheets().get(0).getPageSetup().setLeftMargin(0);
        book.getWorksheets().get(0).getPageSetup().setRightMargin(0);
        book.getWorksheets().get(0).getPageSetup().setTopMargin(0);
        book.getWorksheets().get(0).getPageSetup().setBottomMargin(0);

        // Convert the first worksheet to an image, specifying the range (1, 1, 19, 5)
        // The range defines the cells to be converted. Here it starts from cell A1 and ends at cell S5.
        return book.getWorksheets().get(0).toImage(1, 1, 19, 5);
    }
}
