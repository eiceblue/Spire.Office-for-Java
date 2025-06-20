import com.spire.presentation.*;

import java.io.FileWriter;
import java.util.ArrayList;

public class getAllTitles {
    public static void main(String[] args) throws Exception {
        String input="data/titles.pptx";
        String output= "output/getAllTitles.txt";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile(input);

        //Instantiate a list of IShape objects
        ArrayList<IShape> shapelist = new ArrayList<IShape>();

        //Loop through all sildes and all shapes on each slide
        for (ISlide slide : (Iterable<ISlide>)ppt.getSlides())
        {
            for (IShape shape :(Iterable<IShape>)slide.getShapes())
            {
                if (shape.getPlaceholder() != null)
                {
                    //Get all titles
                    switch (shape.getPlaceholder().getType())
                    {
                        case TITLE:
                            shapelist.add(shape);
                            break;
                        case CENTERED_TITLE:
                            shapelist.add(shape);
                            break;
                        case SUBTITLE:
                            shapelist.add(shape);
                            break;
                    }
                }
            }
        }

        //Loop through the list and get the inner text of all shapes in the list
        StringBuilder sb = new StringBuilder();
        sb.append("Below are all the obtained titles:"+"\r\n");
        for (int i = 0; i < shapelist.size(); i++)
        {
            IAutoShape shape1 = (IAutoShape)shapelist.get(i);
            sb.append(shape1.getTextFrame().getText()+"\r\n");
        }

        //Save to a .txt file
        FileWriter writer = new FileWriter(output);
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        ppt.dispose();
    }
}
