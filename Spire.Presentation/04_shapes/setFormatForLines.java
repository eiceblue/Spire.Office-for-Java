import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setFormatForLines {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String result = "output/setFormatForLines.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        Rectangle2D rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Add a rectangle shape to the slide
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(100, 150, 200, 100));
        //Set the fill color of the rectangle shape
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.white);
        //Apply some formatting on the line of the rectangle
        shape.getLine().setStyle(TextLineStyle.THICK_THIN);
        shape.getLine().setWidth(5);
        shape.getLine().setDashStyle(LineDashStyleType.DASH);
        //Set the color of the line of the rectangle
        shape.getShapeStyle().getLineColor().setColor(Color.blue);

        //Add a ellipse shape to the slide
        shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.ELLIPSE, new Rectangle2D.Double(400, 150, 200, 100));
        //Set the fill color of the ellipse shape
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.white);
        //Apply some formatting on the line of the ellipse
        shape.getLine().setStyle(TextLineStyle.THICK_BETWEEN_THIN);
        shape.getLine().setWidth(5);
        shape.getLine().setDashStyle(LineDashStyleType.DASH_DOT);
        //Set the color of the line of the ellipse
        shape.getShapeStyle().getLineColor().setColor(Color.orange);

        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
