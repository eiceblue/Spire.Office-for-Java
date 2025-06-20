import com.spire.doc.*;
import com.spire.doc.documents.*;

public class comboBoxItem {
    public static void main(String[] args) {
        // Create a document
        Document doc = new Document();

        // Load from disk
        doc.loadFromFile("data/comboBox.docx");

        // Iterate through sections in the document
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            Section section = doc.getSections().get(i);

            // Iterate through child objects in the body of each section
            for (int j = 0; j < section.getBody().getChildObjects().getCount(); j++) {
                DocumentObject bodyObj = section.getBody().getChildObjects().get(j);

                // Check if the object is a structure document tag
                if (bodyObj.getDocumentObjectType() == DocumentObjectType.Structure_Document_Tag) {
                    StructureDocumentTag sdt = (StructureDocumentTag) bodyObj;

                    // Check if the structure document tag is a combo box
                    if (sdt.getSDTProperties().getSDTType() == SdtType.Combo_Box) {
                        SdtComboBox combo = (SdtComboBox) sdt.getSDTProperties().getControlProperties();

                        // Remove an item from the combo box list
                        combo.getListItems().removeAt(1);

                        // Add a new item to the combo box list
                        SdtListItem item = new SdtListItem("D", "D");

                        // Add the newly created item
                        combo.getListItems().add(item);

                        // Select the item with value "D"
                        for (int k = 0; k < combo.getListItems().getCount(); k++) {
                            SdtListItem sdtItem = combo.getListItems().get(k);
                            if ("D".equals(sdtItem.getValue())) {
                                // Select the item
                                combo.getListItems().setSelectedValue(sdtItem);
                            }
                        }
                    }
                }
            }
        }

        // Save the modified document
        String output = "output/comboBoxItem.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document object
        doc.dispose();
    }
}
