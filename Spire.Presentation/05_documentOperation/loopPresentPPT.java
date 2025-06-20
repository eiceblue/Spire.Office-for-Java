import com.spire.presentation.*;

public class loopPresentPPT {
    public static void main(String[] args) throws Exception {
        String input = "data/inputTemplate.pptx";
        String output = "output/loopPresentPPT.pptx";

        //create an instance of presentation document
        Presentation ppt = new Presentation();

        //load file
        ppt.loadFromFile(input);

        //set the Boolean value of ShowLoop as true
        ppt.setShowLoop(true);

        //set the PowerPoint document to show animation and narration
        ppt.setShowAnimation(true);
        ppt.setShowNarration(true);

        //use slide transition timings to advance slide
        ppt.setUseTimings(true);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
