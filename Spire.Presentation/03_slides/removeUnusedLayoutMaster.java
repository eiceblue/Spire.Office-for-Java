import com.spire.presentation.*;
import com.spire.presentation.collections.IMasterLayouts;
import java.util.ArrayList;

public class removeUnusedLayoutMaster {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/JAVAPPTSample_1.pptx";

        //Load document from disk
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Create an array list
        ArrayList list = new ArrayList();
        for (int i = 0; i < ppt.getSlides().getCount(); i++) {
            //Get the layout used by slide
            ActiveSlide layout = (ActiveSlide)ppt.getSlides().get(i).getLayout();
            list.add(layout);
        }

        //Loop through masters and layouts
        for (int i = 0;i<ppt.getMasters().getCount(); i++) {
            IMasterLayouts masterlayouts = ppt.getMasters().get(i).getLayouts();
            for (int j=masterlayouts.getCount()-1;j>=0;j--)
            {
                if (!list.contains(masterlayouts.get(j)))
                {
                    //Remove unused layout
                    masterlayouts.removeMasterLayout(j);
                }
            }
        }

        //Save the document
        ppt.saveToFile("output/RemoveUnusedLayoutMaster_out.pptx", FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
