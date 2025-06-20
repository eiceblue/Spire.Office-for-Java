import com.spire.doc.*;
import java.io.*;

public class identifyMergeFieldName {
    public static void main(String[] args) throws Exception {
        // Create a new Document object
        Document document = new Document();

        // Load the input Word document
        document.loadFromFile("data/IdentifyMergeFieldNames.docx");

        // Get the merge group names
        String[] GroupNames = document.getMailMerge().getMergeGroupNames();

        // Get the merge field names within a specific group ("Products")
        String[] MergeFieldNamesWithinRegion = document.getMailMerge().getMergeFieldNames("Products");

        // Get all of the merge field names in the document
        String[] MergeFieldNames = document.getMailMerge().getMergeFieldNames();

        // Create a StringBuilder to store the content
        StringBuilder content = new StringBuilder();
        content.append("----------------Group Names-----------------------------------------"+"\r\n");

        // Append the group names to the content
        for (int i = 0; i < GroupNames.length; i++) {
            content.append(GroupNames[i]+"\r\n");
        }

        content.append("----------------Merge field names within a specific group-----------"+"\r\n");

        // Append the merge field names within the "Products" group to the content
        for (int j = 0; j < MergeFieldNamesWithinRegion.length; j++) {
            content.append(MergeFieldNamesWithinRegion[j]+"\r\n");
        }

        content.append("----------------All of the merge field names------------------------"+"\r\n");

        // Append all of the merge field names to the content
        for (int k = 0; k < MergeFieldNames.length; k++) {
            content.append(MergeFieldNames[k]+"\r\n");
        }

        // Specify the path for the result text file
        String result = "output/Result-IdentifyMergeFieldNames.txt";

        System.out.println(content.toString());

        // Write the content to the text file
        writeStringToTxt(content.toString(), result);

        // Dispose of the document
        document.dispose();
    }

    // Method to write a string to a text file
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
