import com.spire.presentation.*;

public class resetShapeSizeAndPosition{
    public static void main(String[] args) throws Exception {
        String input="data/shapeTemplate.pptx";
        String output = "output/resetShapeSizeAndPosition_result.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile(input);

        //Define the original slide size
        double currentHeight = ppt.getSlideSize().getSize().getHeight();
        double currentWidth = ppt.getSlideSize().getSize().getWidth();

        //Change the slide size as A3
        ppt.getSlideSize().setType(SlideSizeType.A3);

        //Define the new slide size
        double newHeight = ppt.getSlideSize().getSize().getHeight();
        double newWidth = ppt.getSlideSize().getSize().getWidth();

        //Define the ratio from the old and new slide size
        double ratioHeight = newHeight / currentHeight;
        double ratioWidth = newWidth / currentWidth;

        //Reset the size and position of the shape on the slide
        for (ISlide slide :(Iterable<ISlide>) ppt.getSlides())
        {
            for (IShape shape: (Iterable<IShape>)slide.getShapes())
            {
                shape.setHeight((float) (shape.getHeight() * ratioHeight));
                shape.setWidth((float)(shape.getWidth() * ratioWidth));

                shape.setLeft((float)shape.getLeft() * ratioHeight);
                shape.setTop((float)shape.getTop() * ratioWidth);
            }
        }

        //Save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
