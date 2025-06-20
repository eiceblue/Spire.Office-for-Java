import com.spire.presentation.Presentation;

import java.io.FileWriter;

public class getSlideLayoutName {
    public static void main(String[] args) throws Exception {
        String inputFile="data/getSlideLayoutName.pptx";
        String outputFile = "output/getSlideLayoutName_result.txt";

        //Create a PPT document
        Presentation presentation=new Presentation();

        //Load the document from disk
        presentation.loadFromFile(inputFile);

        StringBuilder builder = new StringBuilder();

        //Loop through the slides of PPT document
        for (int i = 0; i < presentation.getSlides().getCount(); i++)
        {
            //Get the name of slide layout
            String name = presentation.getSlides().get(i).getLayout().getName();
            builder.append(String.format("The name of slide %d layout is: %s", i,name)+"\r\n");
        }

        //Save to a .txt file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }
}
