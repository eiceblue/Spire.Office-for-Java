import com.spire.doc.*;
import com.spire.doc.fields.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class fillFormField {
    private static DocumentBuilder documentBuilder = null;
    private static DocumentBuilderFactory documentBuilderFactory = null;
    private static org.w3c.dom.Document xmlDocument = null;

    static {
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

        String input="data/fillFormField.doc";
        String inputxml="data/user.xml";

		// Create a new document object from the com.spire.doc package, using the specified input file path
		com.spire.doc.Document document = new com.spire.doc.Document(input);

		// Create an InputStream to read the input XML file
		InputStream is = new FileInputStream(new File(inputxml));

		// Parse the XML document using the documentBuilder and input stream
		xmlDocument = documentBuilder.parse(is);

		// Retrieve the "user" elements from the XML document
		NodeList user = xmlDocument.getElementsByTagName("user");

		// Get the child nodes of the first "user" element
		NodeList nodeList = user.item(0).getChildNodes();

		// Iterate through each form field in the first section's body
		for (int i = 0; i < document.getSections().get(0).getBody().getFormFields().getCount(); i++) {
			// Get the current form field
			FormField field = document.getSections().get(0).getBody().getFormFields().get(i);
			
			// Get the name of the form field
			String name = field.getName();
			
			// Iterate through each node in the XML child nodes
			for (int j = 0; j < nodeList.getLength(); j++) {
				// Get the current node
				Node node = nodeList.item(j);
				
				// Compare the form field name with the XML node name (case-insensitive)
				if (name.toLowerCase().trim().equals(node.getNodeName().toLowerCase().trim())) {
					// Get the value from the XML node
					String value = node.getTextContent();
					
					// Handle different types of form fields based on their type
					switch (field.getType()) {
						case Field_Form_Text_Input:
							// Set the text value for a text input form field
							field.setText(value);
							break;
						
						case Field_Form_Drop_Down:
							// Cast the form field to a DropDownFormField
							DropDownFormField combox = (DropDownFormField) field;
							
							// Iterate through each drop-down item and find the matching value
							for (int m = 0; m < combox.getDropDownItems().getCount(); m++) {
								if (combox.getDropDownItems().get(m).getText().equals(value)) {
									// Set the selected index of the drop-down field to the matching item
									combox.setDropDownSelectedIndex(m);
									break;
								}
								
								// Special case for "country" field with "Others" option
								if ("country".equals(field.getName()) && "Others".equals(combox.getDropDownItems().get(m).getText())) {
									combox.setDropDownSelectedIndex(m);
								}
							}
							break;
						
						case Field_Form_Check_Box:
							// Convert the value to boolean and set the checked state for a checkbox form field
							if (Boolean.parseBoolean(value)) {
								CheckBoxFormField checkBox = (CheckBoxFormField) field;
								checkBox.setChecked(true);
							}
							break;
					}
					
					// Break out of the loop since the matching form field has been found
					break;
				}
			}
		}

		// Specify the output file path
		String output = "output/ModifiedDocument.docx";

		// Save the modified document to the specified output file in DOCX format
		document.saveToFile(output, FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}
