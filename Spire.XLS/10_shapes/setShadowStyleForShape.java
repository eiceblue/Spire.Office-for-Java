import com.spire.xls.*;
import com.spire.xls.core.*;
import java.awt.*;

public class setShadowStyleForShape {
    public static void main(String[] args) throws Exception {
        String output = "output/setShadowStyleForShape.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //add an ellipse shape.
        IPrstGeomShape ellipse = sheet.getPrstGeomShapes().addPrstGeomShape(5, 5, 150, 100, PrstGeomShapeType.Ellipse);

        //set the shadow style for the ellipse.
        ellipse.getShadow().setAngle( 90);
        ellipse.getShadow().setDistance(10);
        ellipse.getShadow().setSize( 150);
        ellipse.getShadow().setColor( Color.GRAY);
        ellipse.getShadow().setBlur(30);
        ellipse.getShadow().setTransparency(1);
        ellipse.getShadow().hasCustomStyle(true);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
