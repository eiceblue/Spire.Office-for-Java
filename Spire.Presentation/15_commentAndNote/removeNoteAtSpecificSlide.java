import com.spire.presentation.*;

public class removeNoteAtSpecificSlide {
    public static void main(String[] args) throws Exception{
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/RemoveNoteFromSlides.pptx");

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Get note slide
        NotesSlide note = slide.getNotesSlide();
        //Clear note text
        note.getNotesTextFrame().setText("");

        String result = "output/removeNoteAtSpecificSlide.pptx";

        //Save the PPT to PDF file format
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
