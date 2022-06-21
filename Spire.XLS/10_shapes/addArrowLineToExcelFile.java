import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.XlsLineShape;
import java.awt.*;

public class addArrowLineToExcelFile {
    public static void main(String[] args) throws Exception {
        String output = "output/addArrowLineToExcelFile.xlsx";
        //create a workbook.
        Workbook workbook = new Workbook();

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //add a Double Arrow and fill the line with solid color.
        XlsLineShape line = (XlsLineShape)sheet.getTypedLines().addLine();
        line.setTop(10);
        line.setLeft( 20);
        line.setWidth(100);
        line.setHeight(0);
        line.setColor( Color.BLUE);
        line.setBeginArrowHeadStyle( ShapeArrowStyleType.LineArrow);
        line.setEndArrowHeadStyle(ShapeArrowStyleType.LineArrow);

        //add an Arrow and fill the line with solid color.
        XlsLineShape line_1 = (XlsLineShape)sheet.getTypedLines().addLine();
        line_1.setTop(50);
        line_1.setLeft(30);
        line_1.setWidth(100);
        line_1.setHeight(100);
        line_1.setColor( Color.RED);
        line_1.setBeginArrowHeadStyle(ShapeArrowStyleType.LineNoArrow);
        line_1.setEndArrowHeadStyle(ShapeArrowStyleType.LineArrow);

        //add an Elbow Arrow Connector.
        XlsLineShape line3 = (XlsLineShape)sheet.getTypedLines().addLine();
        line3.setLineShapeType( LineShapeType.ElbowLine);
        line3.setWidth(30);
        line3.setHeight(50);
        line3.setEndArrowHeadStyle( ShapeArrowStyleType.LineArrow);
        line3.setTop(100);
        line3.setLeft(50);

        //add an Elbow Double-Arrow Connector.
        XlsLineShape line2 = (XlsLineShape)sheet.getTypedLines().addLine();
        line2.setLineShapeType(LineShapeType.ElbowLine);
        line2.setWidth(50);
        line2.setHeight(50);
        line2.setEndArrowHeadStyle( ShapeArrowStyleType.LineArrow);
        line2.setBeginArrowHeadStyle( ShapeArrowStyleType.LineArrow);
        line2.setLeft(120);
        line2.setTop( 100);

        //add a Curved Arrow Connector.
        line3 = (XlsLineShape)sheet.getTypedLines().addLine();
        line3.setLineShapeType(LineShapeType.CurveLine);
        line3.setWidth(30);
        line3.setHeight(50);
        line3.setEndArrowHeadStyle( ShapeArrowStyleType.LineArrowOpen);
        line3.setTop(100);
        line3.setLeft(200);

        //add a Curved Double-Arrow Connector.
        line2 = (XlsLineShape)sheet.getTypedLines().addLine();
        line2.setLineShapeType(LineShapeType.CurveLine);
        line2.setWidth(30);
        line2.setHeight(50);
        line2.setEndArrowHeadStyle( ShapeArrowStyleType.LineArrowOpen);
        line2.setBeginArrowHeadStyle(ShapeArrowStyleType.LineArrowOpen);
        line2.setLeft( 250);
        line2.setTop(100);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
