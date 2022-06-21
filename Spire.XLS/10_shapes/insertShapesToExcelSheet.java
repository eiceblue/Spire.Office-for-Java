import com.spire.xls.*;
import com.spire.xls.core.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class insertShapesToExcelSheet {
    public static void main(String[] args) throws Exception {
        String output = "output/insertShapesToExcelSheet.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //add a triangle shape.
        IPrstGeomShape triangle = sheet.getPrstGeomShapes().addPrstGeomShape(2, 2, 100, 100, PrstGeomShapeType.Triangle);

        //fill the triangle with solid color.
        triangle.getFill().setForeColor( Color.YELLOW);
        triangle.getFill().setFillType( ShapeFillType.SolidColor);

        //add a heart shape.
        IPrstGeomShape heart = sheet.getPrstGeomShapes().addPrstGeomShape(2, 5, 100, 100, PrstGeomShapeType.Heart);

        //fill the heart with gradient color.
        heart.getFill().setForeColor(Color.RED);
        heart.getFill().setFillType(ShapeFillType.Gradient);

        //add an arrow shape with default color.
        IPrstGeomShape arrow = sheet.getPrstGeomShapes().addPrstGeomShape(10, 2, 100, 100, PrstGeomShapeType.CurvedRightArrow);

        //add a cloud shape.
        IPrstGeomShape cloud = sheet.getPrstGeomShapes().addPrstGeomShape(10, 5, 100, 100, PrstGeomShapeType.Cloud);

        //fill the cloud with custom picture
        BufferedImage image = ImageIO.read(new File("data/SpireXls.png"));
        cloud.getFill().customPicture(image, "SpireXls.png");
        cloud.getFill().setFillType( ShapeFillType.Picture);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
