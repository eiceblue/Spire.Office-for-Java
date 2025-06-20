import com.spire.presentation.*;
import java.awt.geom.Point2D;
import java.io.FileWriter;
import java.util.ArrayList;

public class getShapePoint {
    public static void main(String[] args) throws Exception {
        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ShapePoint.pptx");

        //Get the first shape in first slide
        IAutoShape shape = (IAutoShape)ppt.getSlides().get(0).getShapes().get(0);

        //Get the Point of shape
        ArrayList<Point2D> points = shape.getPoints();

        StringBuilder sb = new StringBuilder();
        sb.append("point count：" + " "+points.size() + "\r\n");

        for (int i=0; i< points.size(); i++){
            sb.append("point"+ i + " "+points.get(i) + "\r\n");
        }

        //Save the result txt file
        FileWriter writer2 = new FileWriter("output/pointInformation.txt", true);
        writer2.append(sb);
        writer2.close();
    }
}
