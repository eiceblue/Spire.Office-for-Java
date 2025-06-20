import com.spire.presentation.*;

public class removeSpeakerNotes {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_5.pptx");

        //Get the first slide from the sample document.
        ISlide slide = presentation.getSlides().get(0);

        //Remove the first speak note.
        slide.getNotesSlide().getNotesTextFrame().getParagraphs().removeAt(1);

        String result = "output/removeSpeakerNotes.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
