import com.spire.presentation.*;

import java.awt.geom.Rectangle2D;

public class linkToLastViewedSlide {

    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt=new Presentation();
        //Load the PPT document from disk.
        ppt.loadFromFile("data/lastView.pptx");
        //Create a shape
        IAutoShape autoShape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(100, 100, 100, 100));
        //Link to recently viewed slide show
        ClickHyperlink lastViewedSlide = ClickHyperlink.getLastViewedSlide();
        autoShape.setClick(lastViewedSlide);
        //Save the document
        ppt.saveToFile("output/linkToLastViewedSlide.pptx", FileFormat.PPTX_2013);
    }
}
