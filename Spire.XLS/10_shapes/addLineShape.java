import com.spire.xls.*;
import com.spire.xls.core.ILineShape;
import java.awt.*;

public class addLineShape {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ExcelSample_N1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add shape line1
        ILineShape line1 = sheet.getLines().addLine(10, 2, 200, 1, LineShapeType.Line);
        //Set dash style type
        line1.setDashStyle(ShapeDashLineStyleType.Solid);
        //Set color
        line1.setColor(Color.BLUE);
        //Set weight
        line1.setWeight(2);
        //Set end arrow style type
        line1.setEndArrowHeadStyle(ShapeArrowStyleType.LineArrow);

        //Add shape line2
        ILineShape line2 = sheet.getLines().addLine(12, 2, 200, 1, LineShapeType.CurveLine);
        line2.setDashStyle(ShapeDashLineStyleType.Dotted);
        line2.setColor(Color.ORANGE);
        line2.setWeight(2);

        //Add shape line3
        ILineShape line3 = sheet.getLines().addLine(14, 2, 200, 1, LineShapeType.ElbowLine);
        line3.setDashStyle(ShapeDashLineStyleType.DashDotDot);
        line3.setColor(Color.PINK);
        line3.setWeight(2);

        //Add shape line4
        ILineShape line4 = sheet.getLines().addLine(16, 2, 200, 1, LineShapeType.LineInv);
        line4.setDashStyle(ShapeDashLineStyleType.Dashed);
        line4.setColor(Color.green);
        line4.setWeight(2);
        line4.setBeginArrowHeadStyle(ShapeArrowStyleType.LineArrow);
        line4.setEndArrowHeadStyle(ShapeArrowStyleType.LineArrow);
        //Save the document
        String output = "output/InsertLineShape_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
