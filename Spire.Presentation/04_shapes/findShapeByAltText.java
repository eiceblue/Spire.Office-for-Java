import com.spire.presentation.*;

public class findShapeByAltText {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile("data/findShapeByAltText.pptx");

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Find shape in the slide
        IShape shape = FindShape(slide, "Shape1");

        if (shape != null)
        {
            System.out.println("The name of found shape is: "+shape.getName());
        }
    }
    private static IShape FindShape(ISlide slide, String altText)
    {
        //Loop through shapes in the slide
        for (IShape shape : (Iterable<IShape>)slide.getShapes())
        {
            //Find the shape whose alternative text is altText
            if (shape.getAlternativeText().compareTo(altText) == 0)
            {
                return shape;
            }
        }
        return null;
    }
}
