import com.spire.presentation.*;

public class deleteComment {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/deleteComment.pptx";
        String outputFile="output/deleteComment_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Replace the text in the comment
        ppt.getSlides().get(0).getComments()[1].setText("Replace comment");

        //Delete the third comment
        ppt.getSlides().get(0).deleteComment(ppt.getSlides().get(0).getComments()[1]);

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
        ppt.dispose();
    }
}

