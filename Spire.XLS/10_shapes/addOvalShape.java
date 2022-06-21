import com.spire.xls.*;
import com.spire.xls.core.IOvalShape;

import java.awt.*;

public class addOvalShape {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ExcelSample_N1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add oval shape1
        IOvalShape ovalShape1 = sheet.getOvalShapes().addOval(11, 2, 100, 100);
        ovalShape1.getLine().setWeight(0);
        //Fill shape with solid color
        ovalShape1.getFill().setFillType(ShapeFillType.SolidColor);
        ovalShape1.getFill().setForeColor(Color.orange);

        //Add oval shape2
        IOvalShape ovalShape2 = sheet.getOvalShapes().addOval(11, 5, 100, 100);
        ovalShape2.getLine().setDashStyle(ShapeDashLineStyleType.Solid);
        ovalShape2.getLine().setWeight(1);
        //Fill shape with picture
        ovalShape2.getFill().customPicture("data/E-iceblueLogo.png");

        //Save the document
        String output = "output/addOvalShape_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
