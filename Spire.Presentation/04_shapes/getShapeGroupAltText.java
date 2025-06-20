import com.spire.presentation.*;

import java.io.FileWriter;

public class getShapeGroupAltText {
    public static void main(String[] args) throws Exception {
        String input="data/getShapeGroupAltText.pptx";
        String output= "output/getShapeGroupAltText_result.txt";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile(input);

        StringBuilder builder=new StringBuilder();

        //Loop through slides and shapes
        for (ISlide slide : (Iterable<ISlide>)presentation.getSlides())
        {
            for (IShape shape : (Iterable<IShape>)slide.getShapes())
            {
                if (shape instanceof GroupShape)
                {
                    //Find the shape group
                    GroupShape groupShape = (GroupShape)shape;
                    int i=1;
                    for (IShape gShape : (Iterable<IShape>)groupShape.getShapes())
                    {
                        //Append the alternative text in builder
                        builder.append(gShape.getAlternativeText()+"\r\n");
                    }
                }
            }
        }

        //Write the content in txt file
        FileWriter writer = new FileWriter(output);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
        presentation.dispose();
    }
}
