import com.spire.presentation.*;

import java.io.*;

public class updateAudio {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt=new Presentation();
        //Load the PPT document from disk.
        ppt.loadFromFile("data/insertAudio.pptx");
        //Load the audio from disk.
        File file = new File("data/Music.wav");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        fileInputStream.read(data);

        //Get Audio collection
        WavAudioCollection audios = ppt.getWavAudios();
        //update Audio
        IAudioData audioData = audios.append(data);

        //Get the specified shape
        IShape shape = ppt.getSlides().get(0).getShapes().get(3);
        //If shape is IAudio
        if(shape instanceof IAudio){
            //update Audio
            ((IAudio)shape).setData(audioData);
        }
        ppt.saveToFile("output/updateAudio.pptx", FileFormat.PPTX_2013);
    }
}
