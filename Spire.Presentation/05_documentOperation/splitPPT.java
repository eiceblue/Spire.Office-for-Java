import com.spire.presentation.*;

public class splitPPT {
    public static void main(String[] args) throws Exception {
        String input = "data/inputTemplate.pptx";
        String outputPath = "output/";

        //create an instance of presentation document
        Presentation ppt = new Presentation();

        //load file
        ppt.loadFromFile(input);

        for (int i = 0; i < ppt.getSlides().getCount(); i++)
        {
            //initialize another instance of Presentation, and remove the blank slide
            Presentation newppt = new Presentation();
            newppt.getSlides().removeAt(0);

            //append the specified slide from old presentation to the new one
            newppt.getSlides().append(ppt.getSlides().get(i));

            //save the document
            String result =outputPath + String.format("SplitPPT-%d.pptx", i);
            newppt.saveToFile(result, FileFormat.PPTX_2013);
        }
    }
}
