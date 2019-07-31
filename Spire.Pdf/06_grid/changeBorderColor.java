import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class changeBorderColor {
    public static void main(String[] args) {
        PdfDocument document = new PdfDocument();
        PdfPageBase page = document.getPages().add();
        String[] data = {"VendorName;Address1;City;State;Country", "Cacor Corporation;161 Southfield Rd;Southfield;OH;U.S.A.", "Underwater;50 N 3rd Street;Indianapolis;IN;U.S.A.", "J.W.  Luscher Mfg.;65 Addams Street;Berkely;MA;U.S.A.", "Scuba Professionals;3105 East Brace;Rancho Dominguez;CA;U.S.A.", "Divers'  Supply Shop;5208 University Dr;Macon;GA;U.S.A.", "Techniques;52 Dolphin Drive;Redwood City;CA;U.S.A.", "Perry Scuba;3443 James Ave;Hapeville;GA;U.S.A.", "Beauchat, Inc.;45900 SW 2nd Ave;Ft Lauderdale;FL;U.S.A.", "Amor Aqua;42 West 29th Street;New York;NY;U.S.A.", "Aqua Research Corp.;P.O. Box 998;Cornish;NH;U.S.A.", "B&K Undersea Photo;116 W 7th Street;New York;NY;U.S.A.", "Diving International Unlimited;1148 David Drive;San Diego;DA;U.S.A.", "Nautical Compressors;65 NW 167 Street;Miami;FL;U.S.A.", "Glen Specialties, Inc.;17663 Campbell Lane;Huntington Beach;CA;U.S.A.", "Dive Time;20 Miramar Ave;Long Beach;CA;U.S.A.", "Undersea Systems, Inc.;18112 Gotham Street;Huntington Beach;CA;U.S.A.", "Felix Diving;310 S Michigan Ave;Chicago;IL;U.S.A.", "Central Valley Skin Divers;160 Jameston Ave;Jamaica;NY;U.S.A.", "Parkway Dive Shop;241 Kelly Street;South Amboy;NJ;U.S.A.", "Marine Camera & Dive;117 South Valley Rd;San Diego;CA;U.S.A.", "Dive Canada;275 W Ninth Ave;Vancouver;British Columbia;Canada", "Dive & Surf;P.O. Box 20210;Indianapolis;IN;U.S.A.", "Fish Research Labs;29 Wilkins Rd Dept. SD;Los Banos;CA;U.S.A."};
        //Create a grid
        PdfGrid grid = new PdfGrid();
        //Add rows
        for (int r = 0; r < data.length; r++) {
            PdfGridRow row =  grid.getRows().add();
        }
        //Add columns
        grid.getColumns().add(5);
        grid.getColumns().get(0).setWidth(120);
        grid.getColumns().get(1).setWidth(120);
        grid.getColumns().get(2).setWidth(120);
        grid.getColumns().get(3).setWidth(50);
        grid.getColumns().get(4).setWidth(60);

        //set the height of rows
        float height = (float) page.getCanvas().getClientSize().getHeight() - (grid.getRows().size() + 1);
        for (int i = 0; i < grid.getRows().size(); i++) {
            grid.getRows().get(i).setHeight(12.5f);
        }
        //Insert data to grid
        for (int r = 0; r < data.length; r++) {
            String[] rowData = data[r].split("[;]", -1);
            for (int c = 0; c < rowData.length; c++) {
                grid.getRows().get(r).getCells().get(c).setValue(rowData[c]);
            }
        }
        grid.getRows().get(0).getStyle().setFont( new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 8 ), true));
        //Set color of border
        PdfBorders border = new PdfBorders();
        border.setAll(new PdfPen(new PdfRGBColor(new Color(173,216,230))));

        for (PdfGridRow pgr : (Iterable<? extends PdfGridRow>) grid.getRows()) {
            for (PdfGridCell pgc : (Iterable<PdfGridCell>) pgr.getCells()) {
                pgc.getStyle().setBorders(border);
            }
        }
        //Draw the grid
        grid.draw(page, new Point2D.Float(10, 100));
        document.saveToFile("output/changeBorderColor.pdf");
        document.close();
    }
}
