import com.spire.presentation.*;
import java.io.*;

public class extractComments {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_5.pptx");

        String result = "output/extractComments.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        //Get all comments from the first slide.
        Comment[] comments = presentation.getSlides().get(0).getComments();

        //Save the comments in txt file.
        for (int i = 0; i < comments.length; i++)
        {
            bw.write(comments[i].getText() + "\r\n");
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
