import com.spire.xls.*;
import com.spire.xls.core.*;
import java.awt.*;

public class modifyShadowStyleForShape {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_5.xlsx";
        String output = "output/modifyShadowStyleForShape.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the third shape from the worksheet.
        IPrstGeomShape shape = sheet.getPrstGeomShapes().get(2);

        //set the shadow style for the shape.
        shape.getShadow().setAngle(90);
        shape.getShadow().setTransparency(30);
        shape.getShadow().setDistance(10);
        shape.getShadow().setSize(130);
        shape.getShadow().setColor( Color.YELLOW);
        shape.getShadow().setBlur(30);
        shape.getShadow().hasCustomStyle( true);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
