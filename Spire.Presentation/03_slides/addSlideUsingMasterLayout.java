import com.spire.presentation.*;

public class addSlideUsingMasterLayout {
    public static void main(String[] args) throws Exception {
        //Load the ppt file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/PPTSample_N.pptx");

        //get Master layouts
        ILayout iLayout = presentation.getMasters().get(0).getLayouts().get(0);

        //append new slide
        presentation.getSlides().append(iLayout);

        //insert new slide
        presentation.getSlides().insert(1, iLayout);

        //Save the result ppt file
        presentation.saveToFile("output/addSlideWithMaster_result.pptx", FileFormat.PPTX_2016);
        presentation.dispose();
    }
}
