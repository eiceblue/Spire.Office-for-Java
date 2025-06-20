import com.spire.doc.*;
import com.spire.doc.collections.FormFieldCollection;
import java.io.*;

public class getFormFieldsCollection {
    public static void main(String[] args) throws IOException {
		
		// Create a StringBuilder object to store the information
		StringBuilder sb = new StringBuilder();

		// Create a new document object using the specified input file path
		Document document = new Document("data/FillFormField.doc");

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Get the collection of form fields from the body of the section
		FormFieldCollection formFields = section.getBody().getFormFields();

		// Append the count of form fields in the collection to the StringBuilder object with additional formatting
		sb.append("The first section has " + formFields.getCount() + " form fields.");

		// Specify the output file path for the text file
		String output = "output/getFormFieldsCollection.txt";

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
