import com.spire.doc.*;
import com.spire.doc.fields.FormField;

import java.io.*;

public class getFormFieldByName {
    public static void main(String[] args) throws IOException {
		
		// Create a StringBuilder object to store the information
		StringBuilder sb = new StringBuilder();

		// Create a new document object using the specified input file path
		Document document = new Document("data/FillFormField.doc");

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Get the form field by its name from the body of the section
		FormField formField = section.getBody().getFormFields().get("email");

		// Append the name and type of the form field to the StringBuilder object with additional formatting
		sb.append("The name of the form field is " + formField.getName() + "\r\n");
		sb.append("The type of the form field is " + formField.getFormFieldType());

		// Specify the output file path for the text file
		String output = "output/getFormFieldByName.txt";

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
