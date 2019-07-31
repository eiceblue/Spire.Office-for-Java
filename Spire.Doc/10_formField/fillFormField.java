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
        String output="output/fillFormField.doc";
        //open a Word document including form fields.
        com.spire.doc.Document document = new com.spire.doc.Document(input);

        //load data
        InputStream is = new FileInputStream(new File(inputxml));

        xmlDocument = documentBuilder.parse(is);
        NodeList user = xmlDocument.getElementsByTagName("user");
        NodeList nodeList = user.item(0).getChildNodes();
        //fill data
        for (int i = 0; i < document.getSections().get(0).getBody().getFormFields().getCount(); i++) {
            FormField field = document.getSections().get(0).getBody().getFormFields().get(i);
            String name = field.getName();
            for (int j = 0; j < nodeList.getLength(); j++) {
                Node node = nodeList.item(j);
                if (name.toLowerCase().trim().equals(node.getNodeName().toLowerCase().trim())) {
                    String value = node.getTextContent();
                    switch (field.getType()) {
                        case Field_Form_Text_Input:
                            field.setText(value);
                            break;

                        case Field_Form_Drop_Down:
                            DropDownFormField combox = (DropDownFormField) field;

                            for (int m = 0; m < combox.getDropDownItems().getCount(); m++) {
                                if (combox.getDropDownItems().get(m).getText().equals(value)) {
                                    combox.setDropDownSelectedIndex(m);
                                    break;
                                }
                                if ("country".equals(field.getName()) && "Others".equals(combox.getDropDownItems().get(m).getText())) {
                                    combox.setDropDownSelectedIndex(m);
                                }
                            }
                            break;

                        case Field_Form_Check_Box:
                            if (Boolean.parseBoolean(value)) {
                                CheckBoxFormField checkBox = (CheckBoxFormField) field;
                                checkBox.setChecked(true);
                            }
                            break;
                    }
                    break;
                }
            }
        }

        //save doc file.
        document.saveToFile(output, FileFormat.Doc);
    }
}
