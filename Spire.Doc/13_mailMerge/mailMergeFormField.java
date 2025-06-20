import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.*;
import com.spire.doc.reporting.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mailMergeFormField {
    public static void main(String[] args) throws Exception {
        // Path to the input Word document
        String input = "data/MailMergeFormField.doc";
        // Path to the output Word document
        String output = "output/MailMergeFormField_out.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the input Word document
        doc.loadFromFile(input);

        // Get the current date and format it as a string
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        // Define field names and values for mail merge
        String[] fieldNames = new String[]{"Contact Name", "Fax", "Date", "Urgent", "Share", "Submit", "Body"};
        String[] fieldValues = new String[]{"John Smith", "+1 (69) 123456", dateString, "Yes", "No", "Yes",
                "<b>It's very urgent. Please deal with it ASAP. </b>"};

        // Set up the MergeField event handler for custom processing
        doc.getMailMerge().MergeField = new MergeFieldEventHandler() {
            public void invoke(Object sender, MergeFieldEventArgs args) {
                mailMerge_MergeField(sender, args);
            }
        };

        // Execute the mail merge with the specified field names and values
        doc.getMailMerge().execute(fieldNames, fieldValues);

        // Save the resulting document to the output path
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document
        doc.dispose();
    }
    // Custom mail merge event handler
    private static void mailMerge_MergeField(Object sender, MergeFieldEventArgs args) {
        // Check if the field value is "Yes"
        if (args.getFieldValue().equals("Yes")) {
            // Process the "Yes" field value
            String checkBoxName = args.getFieldName();
            Paragraph para = args.getCurrentMergeField().getOwnerParagraph();
            int index = para.getChildObjects().indexOf(args.getCurrentMergeField());
            CheckBoxFormField field = (CheckBoxFormField) para.appendField(checkBoxName, FieldType.Field_Form_Check_Box);
            para.getChildObjects().insert(index, field);
            para.getChildObjects().remove(args.getCurrentMergeField());
            field.setChecked(true);
        }
        // Check if the field value is "No"
        if (args.getFieldValue().equals("No")) {
            // Process the "No" field value
            String checkBoxName = args.getFieldName();
            Paragraph para = args.getCurrentMergeField().getOwnerParagraph();
            int index = para.getChildObjects().indexOf(args.getCurrentMergeField());
            CheckBoxFormField field = (CheckBoxFormField) para.appendField(checkBoxName, FieldType.Field_Form_Check_Box);
            para.getChildObjects().insert(index, field);
            para.getChildObjects().remove(args.getCurrentMergeField());
            field.setChecked(false);
        }
        // Check if the field name is "Body"
        if (args.getFieldName().equals("Body")) {
            // Process the "Body" field
            Paragraph para = args.getCurrentMergeField().getOwnerParagraph();
            para.appendHTML(args.getFieldValue().toString());
            para.getChildObjects().remove(args.getCurrentMergeField());
        }
        // Check if the field name is "Date"
        if (args.getFieldName().equals("Date")) {
            // Process the "Date" field
            String textInputName = args.getFieldName();
            Paragraph para = args.getCurrentMergeField().getOwnerParagraph();
            TextFormField field = (TextFormField) para.appendField(textInputName, FieldType.Field_Form_Text_Input);
            para.getChildObjects().remove(args.getCurrentMergeField());
            field.setText(args.getFieldValue().toString());
        }
    }
}
