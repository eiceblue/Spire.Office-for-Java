import com.spire.doc.Document;
import com.spire.doc.collections.FieldCollection;
import com.spire.doc.fields.Field;
import java.io.*;

public class getFieldText {
    public static void main(String[] args) throws IOException {
		
		// Create a StringBuilder object to store the field texts
		StringBuilder sb = new StringBuilder();

		// Create a new document object using the specified input file path
		Document document = new Document("data/GetFieldText.docx");

		// Get the collection of fields in the document
		FieldCollection fields = document.getFields();

		// Iterate through each field in the collection
		for (Field field : (Iterable<Field>) fields) {
			// Get the text of the field
			String fieldText = field.getFieldText();
			
			// Append the field text to the StringBuilder object with additional formatting
			sb.append("The field text is \"" + fieldText + "\".\r\n");
		}

		// Specify the output file path for the text file
		String output = "output/getFieldText.txt";

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
