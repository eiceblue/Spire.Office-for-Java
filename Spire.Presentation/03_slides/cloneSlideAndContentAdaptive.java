import com.spire.presentation.*;

public class cloneSlideAndContentAdaptive {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation1 =new Presentation();
        //Load the document from disk
        presentation1.loadFromFile("data/ContentAdaptive-1.pptx");
        //Load another document
        Presentation presentation2 =new Presentation();
        presentation2.loadFromFile("data/ContentAdaptive-2.pptx");
        //Set the adaptive size when cloning slide, currently only supports 4:3->16:9
        presentation1.isSlideSizeAutoFit(true);
        ILayout layout = presentation1.getSlides().get(0).getLayout();
        presentation1.getSlides().append(presentation2.getSlides().get(0),layout);
        //Save the document
        String output = "output/cloneSlideAndContentAdaptive_out.pptx";
        presentation1.saveToFile(output, FileFormat.PPTX_2013);
        presentation1.dispose();
    }
}
