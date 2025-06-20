import com.spire.doc.*;

public class countVariables {
    public static void main(String[] args) throws Exception {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_6.docx");

        //Get the number of variables in the document.
        int number = document.getVariables().getCount();

        //Create a StringBuilder
        StringBuilder content = new StringBuilder();
        content.append("The number of variables is: " + number);

        System.out.println(content);

        //Dispose the document
        document.dispose();
    }
}
