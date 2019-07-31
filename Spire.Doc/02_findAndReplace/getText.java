import com.spire.doc.*;
import java.io.*;

public class getText {
    public static void main(String[] args) throws IOException {
        String input = "data/getText.docx";
        String output = "output/getText.txt";
        //load Word document
        Document document = new Document();
        document.loadFromFile(input);

        //get text from document
        String text=document.getText();

        //create a new TXT file to save the extracted text
        writeStringToTxt(text,output);
    }
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter= new FileWriter(txtFileName,true);
        try {
            fWriter.write(content);
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
