import com.spire.presentation.*;
import com.spire.presentation.collections.VideoCollection;

import java.io.*;

public class updateVideo {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Load the PPT document from disk.
        ppt.loadFromFile("data/insertVideo.pptx");

        //Load the MP4 from disk.
        File file = new File("data/Presentation1.mp4");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileInputStream.read(data);

        //Get video collection
        VideoCollection videos = ppt.getVideos();
        VideoData videoData = videos.append(data);

        //Get the specified shape
        ISlide iSlide = ppt.getSlides().get(0);

        //Traverse all the shapes of slides
        for (Object shape : iSlide.getShapes()) {
            //If shape is IVideo
            if (shape instanceof IVideo) {
                
                IVideo video = (IVideo) shape;
                //Update video
                video.setEmbeddedVideoData(videoData);
            }
        }
        //Save the document
        ppt.saveToFile("output/updateVideo.pptx", com.spire.presentation.FileFormat.PPTX_2013);
    }
}
