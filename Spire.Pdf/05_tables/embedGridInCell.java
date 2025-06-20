import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;

import java.awt.*;
import java.awt.geom.*;

public class embedGridInCell {
    public static void main(String[] args) {
          // Define input path and output path
        String inputFile = "data/embedGridInCell.pdf";
        String outputFile = "output/embedGridInCell_result.pdf";

        // Create a new PdfDocument and load the input file from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create a new PdfGrid
        PdfGrid grid = new PdfGrid();

        // Add a row to the grid
        PdfGridRow row = grid.getRows().add();

        // Set the height of the first row
        row.setHeight(80);

        // Add two columns to the grid
        grid.getColumns().add(2);

        // Set the width of the first column
        grid.getColumns().get(0).setWidth(120);
        grid.getColumns().get(1).setWidth(300);

        // Set the value of the cell in the first column and format it
        row.getCells().get(0).setValue("Embedded grid");
        row.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Define the dimensions for the image
        Dimension2D imageSize = new Dimension(70, 70);

        // Calculate the left and right padding for the cell
        float LR = (float) (grid.getColumns().get(0).getWidth() - imageSize.getWidth()) / 2;

        // Set the cell padding for the grid
        grid.getStyle().setCellPadding(new PdfPaddings(LR, LR, 1, 1));

        // Create a PdfGridCellContentList to hold the image
        PdfGridCellContentList list = new PdfGridCellContentList();

        // Create a PdfGridCellContent for the image and set its value
        PdfGridCellContent textAndStyle = new PdfGridCellContent();
        textAndStyle.setImage(PdfImage.fromFile("data/E-iceblueLogo.png"));

        // Set the size of the image
        textAndStyle.setImageSize(imageSize);

        // Add the image to the list
        list.getList().add(textAndStyle);

        // Set the value of the cell in the first column to the list of images
        row.getCells().get(0).setValue(list);

        // Create another PdfGrid
        PdfGrid grid2 = new PdfGrid();

        // Add two columns to the second grid
        grid2.getColumns().add(2);

        // Add a row to the second grid
        PdfGridRow newrow = grid2.getRows().add();

        // Set the width of the columns in the second grid
        grid2.getColumns().get(0).setWidth(120);
        grid2.getColumns().get(1).setWidth(120);

        // Set the value and string format for the first cell in the new row
        newrow.getCells().get(0).setValue("Embedded grid");
        newrow.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Set the value and string format for the second cell in the new row
        newrow.getCells().get(1).setValue("Embedded grid");
        newrow.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Assign 'grid2' to the second cell in the 'row'
        row.getCells().get(1).setValue(grid2);
        row.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Define an array of data for populating the grid
        String[] data = {
                "VendorName;Address1 & City & State & Country",
                "Cacor Corporation;161 Southfield Rd  & Southfield & OH & U.S.A.",
                "Underwater; 50 N 3rd Street & Indianapolis & IN & U.S.A.",
                "J.W.  Luscher;65 Addams Street & Berkely & MA & U.S.A.",
                "Scuba;3105 East Brace & Rancho Dominguez & CA & U.S.A.",
                "Divers Supply;5208 University Dr & Macon & GA & U.S.A.",
                "Techniques;52 Dolphin Drive & Redwood City & CA & U.S.A.",
                "Perry Scuba; 3443 James Ave & Hapeville & GA & U.S.A.",
                "Beauchat, Inc.;45900 SW 2nd Ave & Ft Lauderdale & FL & U.S.A.",
                "Amor Aqua;42 West 29th Street & New York & NY & U.S.A.",
                "Aqua Research;P.O. Box 998 & Cornish & NH & U.S.A.",
                "B&K Undersea;116 W 7th Street & New York & NY & U.S.A.",
                "Diving;1148 David Drive & San Diego & DA & U.S.A.",
                "Nautical;65 NW 167 Street & Miami & FL & U.S.A.",
                "Glen Specialties;17663 Campbell Lane & Huntington Beach & CA & U.S.A.",
                "Dive Time;20 Miramar Ave & Long Beach & CA & U.S.A.",
                "Undersea Systems;18112 Gotham Street & Huntington Beach & C & U.S.A.",
        };

        // Insert data into the grid
        for (int r = 0; r < data.length; r++) {
            PdfGridRow row1 = grid.getRows().add();
            String[] rowData = data[r].split(";");
            for (int c = 0; c < rowData.length; c++) {
                // Set the value and string format for each cell in the row
                row1.getCells().get(c).setValue(rowData[c]);
                row1.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
            }
        }

        // Draw the PDF grid onto the page at a specific location
        grid.draw(page, new Point(80, 330));

        // Save the PDF document to the specified output file
        doc.saveToFile(outputFile);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
