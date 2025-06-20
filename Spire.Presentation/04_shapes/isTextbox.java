import com.spire.presentation.FileFormat;
import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.io.Console;

public class isTextbox {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/IsTextboxSample.pptx";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile(inputFile);
        for (ISlide slide:(Iterable<? extends ISlide>) presentation.getSlides())
        {
            for (IShape shape:(Iterable<? extends IShape>) slide.getShapes())
            {
                if (shape instanceof IAutoShape)
                {
                    //Judge if the shape is textbox
                    boolean isTextbox=shape.isTextBox();
                    System.out.println(isTextbox? "shape is text box" : "shape is not text box");
                }
            }
        }
    }
}
