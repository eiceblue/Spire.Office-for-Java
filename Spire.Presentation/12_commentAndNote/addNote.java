import com.spire.presentation.*;

public class addNote {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/addNote.pptx";
        String outputFile="output/addNote_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        ISlide slide = ppt.getSlides().get(0);
        //Add note slide
        NotesSlide notesSlide = slide.addNotesSlide();
        //Add paragraph in the notesSlide
        ParagraphEx paragraph = new ParagraphEx();
        paragraph.setText("Tips for making effective presentations:");
        notesSlide.getNotesTextFrame().getParagraphs().append(paragraph);

        paragraph = new ParagraphEx();
        paragraph.setText("Use the slide master feature to create a consistent and simple design template.");
        notesSlide.getNotesTextFrame().getParagraphs().append(paragraph);
        //Set the bullet type for the paragraph in notesSlide
        notesSlide.getNotesTextFrame().getParagraphs().get(1).setBulletType(TextBulletType.NUMBERED);
        notesSlide.getNotesTextFrame().getParagraphs().get(1).setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);

        paragraph = new ParagraphEx();
        paragraph.setText("Simplify and limit the number of words on each screen.");
        notesSlide.getNotesTextFrame().getParagraphs().append(paragraph);
        notesSlide.getNotesTextFrame().getParagraphs().get(2).setBulletType(TextBulletType.NUMBERED);
        notesSlide.getNotesTextFrame().getParagraphs().get(2).setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);

        paragraph = new ParagraphEx();
        paragraph.setText("Use contrasting colors for text and background.");
        notesSlide.getNotesTextFrame().getParagraphs().append(paragraph);
        notesSlide.getNotesTextFrame().getParagraphs().get(3).setBulletType(TextBulletType.NUMBERED);
        notesSlide.getNotesTextFrame().getParagraphs().get(3).setBulletStyle(NumberedBulletStyle.BULLET_ARABIC_PERIOD);

        //Save the file
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
