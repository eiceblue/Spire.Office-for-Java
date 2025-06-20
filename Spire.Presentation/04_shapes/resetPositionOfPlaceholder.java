import com.spire.presentation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class resetPositionOfPlaceholder {
    public static void main(String[] args) throws Exception {
        String input="data/resetPositionOfPlaceholder.pptx";
        String output="output/resetPositionOfDateTimeAndSlideNumber_result.pptx";

        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile(input);

        //Get the first slide from the sample document.
        ISlide slide = presentation.getSlides().get(0);

        for (IShape shapeToMove :(Iterable<IShape>) slide.getShapes())
        {
            //Reset the position of the slide number to the left.
            if (shapeToMove.getName().contains("Slide Number Placeholder"))
            {
                shapeToMove.setLeft(0);
            }

            else if (shapeToMove.getName().contains("Date Placeholder"))
            {
                //Reset the position of the date time to the center.
                shapeToMove.setLeft(presentation.getSlideSize().getSize().getWidth()/ 2);

                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date dt=new Date();
                String time=sf.format(dt);

                //Reset the date time display style.
                ((IAutoShape)shapeToMove).getTextFrame().getTextRange().getParagraph().setText(time);
                ((IAutoShape)shapeToMove).getTextFrame().isCentered(true);
            }
        }

        //Save to file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
