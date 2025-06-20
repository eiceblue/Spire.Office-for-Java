import com.spire.presentation.*;

public class getAudioAndVideoPartName {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Load the PPT document from disk.
        ppt.loadFromFile("data/audioAndVideo.pptx");
        //Loop through all slides
        for (int i = 0; i < ppt.getSlides().getCount(); i++) {
            //Loop through all shapes
            for (int j = 0; j < ppt.getSlides().get(i).getShapes().getCount(); j++) {
                //Get specified shape
                IShape shape = ppt.getSlides().get(i).getShapes().get(j);
                //If shape is IAudio
                if (shape instanceof IAudio) {
                    //Get IAudio name
                    String name = ((IAudio) shape).getData().getPartName();
                    System.out.println("IAudio name is " + name);
                    //If shape is IVideo
                } else if (shape instanceof IVideo) {
                    //Get Ivideo name
                    String name = ((IVideo) shape).getEmbeddedVideoData().getPartName();
                    System.out.println("IVideo name is " + name);
                }
            }
        }
    }
}
