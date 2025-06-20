import com.spire.xls.*;
import java.awt.*;
import java.io.*;

public class getDimensionsOfConvertedSVG {
    public static void main(String[] args) throws FileNotFoundException {

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file
        workbook.loadFromFile("data/CreateTable.xlsx");

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a FileOutputStream to write the SVG data to the specified file
        FileOutputStream stream = new FileOutputStream("output/result.svg");

        // Convert the worksheet to an SVG stream and get the dimensions of the resulting SVG
        Dimension dimension = sheet.toSVGStream(stream, sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());

        // Get the height of the SVG
        double Height = dimension.getHeight();

        // Get the width of the SVG
        double Width = dimension.getWidth();

        // Print the height of the SVG
        System.out.println("The height of SVG is:" + Height);

        // Print the width of the SVG
        System.out.println("The width of SVG is:" + Width);
    }
}
