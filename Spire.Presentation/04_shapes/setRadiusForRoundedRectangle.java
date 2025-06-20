import com.spire.presentation.*;
import java.awt.geom.Rectangle2D;

public class setRadiusForRoundedRectangle {
    public static void main(String[] args) throws Exception {
        //Create a PPT document.
        Presentation presentation = new Presentation();
        ISlide iSlide = presentation.getSlides().get(0);

       //Insert a rectangle with four round corners and set its radius
        IAutoShape autoShape1=iSlide.getShapes().appendShape(ShapeType.ROUND_CORNER_RECTANGLE,new Rectangle2D.Float(50,50,150,150));
        autoShape1.setRoundRadius(autoShape1.getWidth()/3);
		
        //Insert a rectangle with one round corner and set its radius
        IAutoShape autoShape2=iSlide.getShapes().appendShape(ShapeType.ONE_ROUND_CORNER_RECTANGLE,new Rectangle2D.Float(250,50,150,150));
        autoShape2.setRoundRadius(autoShape2.getWidth()/3);

        //Insert a rectangle with one round corner and which one round cornet is snipped and set its radius
        IAutoShape autoShape3=iSlide.getShapes().appendShape(ShapeType.ONE_SNIP_ONE_ROUND_CORNER_RECTANGLE,new Rectangle2D.Float(450,50,150,150));
        autoShape3.setRoundRadius(autoShape3.getWidth()/3);

        //Insert a rectangle with two diagonal round corners and set its radius
        IAutoShape autoShape4=iSlide.getShapes().appendShape(ShapeType.TWO_DIAGONAL_ROUND_CORNER_RECTANGLE,new Rectangle2D.Float(50,250,150,150));
        autoShape4.setRoundRadius(autoShape4.getWidth()/3);

        //Insert a rectangle with two same side round corners and set its radius
        IAutoShape autoShape5=iSlide.getShapes().appendShape(ShapeType.TWO_SAMESIDE_ROUND_CORNER_RECTANGLE,new Rectangle2D.Float(250,250,150,150));
        autoShape5.setRoundRadius(autoShape5.getWidth()/3);
		
        //Save the result ppt file
        presentation.saveToFile("output/setRadiusofRoundedRectangle_result.pptx", FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
