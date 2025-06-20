import com.spire.doc.*;
import java.io.*;

public class getText {
    public static void main(String[] args) throws Exception{

        //Create a document
        Document document = new Document();

        //Load the document from disk.
        document.loadFromFile("data/ExtractText.docx");

        String result = "output/extractText.txt";

        //Create a new TXT File to save extracted text
        File file=new File(result);

        //Determine if the file exists
        if(!file.exists()){
            file.delete();
        }

        //Create a new file
        file.createNewFile();

        //Create a new FileWriter
        FileWriter fw=new FileWriter(file,true);

        //Create a BufferedWriter
        BufferedWriter bw=new BufferedWriter(fw);

        //Get text from the document
        String text = document.getText();

        //Save extracted text
        bw.write(text);

        //Flush the buffer
        bw.flush();

        //Close the document
        bw.close();

        //Close the document
        fw.close();

        //Dispose the document
        document.dispose();
    }
}
