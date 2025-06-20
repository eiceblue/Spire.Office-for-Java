import com.spire.presentation.*;

public class mergeSelectedSlides {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Remove the first slide
        ppt.getSlides().removeAt(0);

        //Load two PPT files
        Presentation ppt1 = new Presentation("data/InputTemplate.pptx", FileFormat.PPTX_2013);
        Presentation ppt2 = new Presentation("data/TextTemplate.pptx", FileFormat.PPTX_2013);

        //Append all slides in ppt1 to ppt
        for (int i = 0; i < ppt1.getSlides().getCount(); i++)
        {
            ppt.getSlides().append(ppt1.getSlides().get(i));
        }

        //Append the second slide in ppt2 to ppt
        ppt.getSlides().append(ppt2.getSlides().get(1));

        //Save the document
        String result = "output/mergeSelectedSlides_result.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
