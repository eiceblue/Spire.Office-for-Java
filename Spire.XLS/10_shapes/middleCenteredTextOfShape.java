import com.spire.xls.*;
import com.spire.xls.core.IPrstGeomShape;

import java.awt.*;

public class middleCenteredTextOfShape {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add a rectangle shape
        IPrstGeomShape rect = sheet.getPrstGeomShapes().addPrstGeomShape(11,2,300,300, PrstGeomShapeType.Rect);

        //Fill the rectangle with solid color
        rect.getFill().setForeColor(Color.white);
        rect.getFill().setFillType(ShapeFillType.SolidColor);

        rect.setText("E-iceblue");
        //Middle centered the text of IPrstGeomShape
        rect.setTextVerticalAlignment(ExcelVerticalAlignment.MiddleCentered);

        //Save the document
        workbook.saveToFile("output/middleCenteredTextOfShape.xlsx", ExcelVersion.Version2013);
    }
}
