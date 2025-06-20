import com.spire.presentation.*;
import java.io.*;

public class addAndGetSpeakerNotes {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        //Get the first slide and in the PowerPoint document.
        ISlide slide = presentation.getSlides().get(0);

        //Get the NotesSlide in the first slide,if there is no notes, we need to add it firstly.
        NotesSlide ns = slide.getNotesSlide();
        if (ns == null)
        {
            ns = slide.addNotesSlide();
        }

        //Add the text string as the notes.
        ns.getNotesTextFrame().setText("Speak notes added by Spire.Presentation");

        String result = "output/addAndGetSpeakerNotes.pptx";
        String result1 = "output/addAndGetSpeakerNotes.txt";
        File file=new File(result1);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        //Get the speaker notes and save to txt file.
        bw.write("The speaker notes added by Spire.Presentation is: " + ns.getNotesTextFrame().getText());

        //Save to PowerPoint file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);

        bw.flush();
        bw.close();
        fw.close();
    }
}
