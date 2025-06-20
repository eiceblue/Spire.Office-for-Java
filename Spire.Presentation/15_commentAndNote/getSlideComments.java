import com.spire.presentation.*;
import java.io.*;
import java.util.Date;

public class getSlideComments {
    public static void main(String[] args) throws Exception{
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile("data/Comments.pptx");

        //Create a new TXT File
        String result = "output/getSlideComments.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        //Loop through comments
        for (Object commentAuthorObj : presentation.getCommentAuthors())
        {
            ICommentAuthor commentAuthor=(ICommentAuthor)commentAuthorObj;
            for (Object commentObj : commentAuthor.getCommentsList())
            {
                Comment comment=(Comment)commentObj;
                //Get comment information
                String commentText = comment.getText();
                String authorName = comment.getAuthorName();
                Date time = comment.getDateTime();
                bw.write("Comment text : "+ commentText+ "\r\n");
                bw.write("Comment author : " + authorName+ "\r\n");
                bw.write("Posted on time : " + time + "\r\n");;
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
