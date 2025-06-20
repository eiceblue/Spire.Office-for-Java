import com.spire.presentation.*;
import java.io.*;

public class getBuiltinProperties {
    public static void main(String[] args) throws Exception {
        String input = "data/getProperties.pptx";
        String output = "output/getBuiltinProperties_Output.txt";

        //create PPT document
        Presentation presentation = new Presentation();

        //load the PPT document from disk
        presentation.loadFromFile(input);

        //get the builtin properties
        String application = presentation.getDocumentProperty().getApplication();
        String author = presentation.getDocumentProperty().getAuthor();
        String company = presentation.getDocumentProperty().getCompany();
        String keywords = presentation.getDocumentProperty().getKeywords();
        String comments = presentation.getDocumentProperty().getComments();
        String category = presentation.getDocumentProperty().getCategory();
        String title = presentation.getDocumentProperty().getTitle();
        String subject = presentation.getDocumentProperty().getSubject();

        //Create StringBuilder to save
        StringBuilder content = new StringBuilder();
        content.append("DocumentProperty.Application: " + application);
        content.append("\r\nDocumentProperty.Author: " + author);
        content.append("\r\nDocumentProperty.Company " + company);
        content.append("\r\nDocumentProperty.Keywords: " + keywords);
        content.append("\r\nDocumentProperty.Comments: " + comments);
        content.append("\r\nDocumentProperty.Category: " + category);
        content.append("\r\nDocumentProperty.Title: " + title);
        content.append("\r\nDocumentProperty.Subject: " + subject);

        //save them to a txt file
        writeStringToTxt(content.toString(),output);
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
