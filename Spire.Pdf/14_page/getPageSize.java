import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.io.*;

public class getPageSize {
    public static void main(String[] args) throws IOException {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/getPageSize_out.txt";

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load an existing pdf from disk
        doc.loadFromFile(input);

        //Get the first page of the loaded PDF file
        PdfPageBase page = doc.getPages().get(0);

        //Get the width of page based on "point"
        double pointWidth = page.getSize().getWidth();

        //Get the height of page
        double pointHeight = page.getSize().getHeight();

        //Create PdfUnitConvertor to convert the unit
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //Convert the size with "pixel"
        float pixelWidth = unitCvtr.convertUnits((float) pointWidth, PdfGraphicsUnit.Point, PdfGraphicsUnit.Pixel);
        float pixelHeight = unitCvtr.convertUnits((float) pointHeight, PdfGraphicsUnit.Point, PdfGraphicsUnit.Pixel);

        //Convert the size with "inch"
        float inchWidth = unitCvtr.convertUnits((float) pointWidth, PdfGraphicsUnit.Point, PdfGraphicsUnit.Inch);
        float inchHeight = unitCvtr.convertUnits((float) pointHeight, PdfGraphicsUnit.Point, PdfGraphicsUnit.Inch);

        //Convert the size with "centimeter"
        float centimeterWidth = unitCvtr.convertUnits((float) pointWidth, PdfGraphicsUnit.Point, PdfGraphicsUnit.Centimeter);
        float centimeterHeight = unitCvtr.convertUnits((float) pointHeight, PdfGraphicsUnit.Point, PdfGraphicsUnit.Centimeter);

        //Create StringBuilder to save
        StringBuilder content = new StringBuilder();

        //Add pointSize string to StringBuilder
        content.append("The page size of the file is (width: " + pointWidth + "pt, height: " + pointHeight + "pt)." + "\r\n");
        content.append("The page size of the file is (width: " + pixelWidth + "pixel, height: " + pixelHeight + "pixel)." + "\r\n");
        content.append("The page size of the file is (width: " + inchWidth + "inch, height: " + inchHeight + "inch)." + "\r\n");
        content.append("The page size of the file is (width: " + centimeterWidth + "cm, height: " + centimeterHeight + "cm.)" + "\r\n");

        // Create a FileWriter to write information to the output file
        FileWriter writer = new FileWriter(output);
        writer.write(content.toString());
        writer.flush();
        writer.close();

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }


}
