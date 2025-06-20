import com.spire.presentation.*;
import com.spire.presentation.drawing.timeline.TimeNodeAudioEx;
import java.io.*;

public class obtainSoundEffect {
    public static void main(String[] args) throws Exception{
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/Animation.pptx");

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Get the audio in a time node TimeNodeAudio
        TimeNodeAudioEx audio = slide.getTimeline().getMainSequence().get(0).getTimeNodeAudios()[0];

        //Create a new TXT File to save extracted text
        String result = "output/obtainSoundEffect.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        //Get the properties of the audio, such as sound name, volume or detect if it's mute
        bw.write("SoundName: " + audio.getSoundName()+"\r\n");
        bw.write("Volume: " + audio.getVolume()+ "\r\n");
        bw.write("IsMute: " + audio.isMute());

        bw.flush();
        bw.close();
        fw.close();
    }
}
