import com.spire.doc.*;
public class retrieveVariables {
    public static void main(String[] args) throws Exception {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_6.docx");

        //Retrieve name of the variable by index.
        String s1 = document.getVariables().getNameByIndex(0);

        //Retrieve value of the variable by index.
        String s2 = document.getVariables().getValueByIndex(0);

        //Retrieve the value of the variable by name.
        String s3 = document.getVariables().get("A1");

        System.out.println("The name of the variable retrieved by index 0 is: " + s1);
        System.out.println("The vaule of the variable retrieved by index 0 is: " + s2);
        System.out.println("The vaule of the variable retrieved by name \"A1\" is: " + s3);

        //Dispose the document
        document.dispose();
    }
}
