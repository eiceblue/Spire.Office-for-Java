import com.spire.doc.Document;
import java.io.*;

public class getMergeFieldName {
    public static void main(String[] args) throws IOException {
		
		// Create a StringBuilder object to store the information
		StringBuilder sb = new StringBuilder();

		// Create a new document object using the specified input file path
		Document document = new Document("data/MailMerge.doc");

		// Get the array of merge field names from the mail merge of the document
		String[] fieldNames = document.getMailMerge().getMergeFieldNames();

		// Append the count of merge fields in the document to the StringBuilder object with additional formatting
		sb.append("The document has " + fieldNames.length + " merge fields.");
		sb.append(" The below is the name of the merge field:" + "\r\n");

		// Iterate through each merge field name and append it to the StringBuilder object with additional formatting
		for (String name : fieldNames) {
			sb.append(name + "\r\n");
		}

		// Specify the output file path for the text file
		String output = "output/getMergeFieldName.txt";

		// Write the contents of the StringBuilder object to a text file
		writeStringToTxt(sb.toString(), output);

		// Dispose the document resources
		document.dispose();
    }
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file=new File(txtFileName);
        if (file.exists())
        {
            file.delete();
        }
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
