import com.spire.xls.*;
import com.spire.xls.core.*;

public class insertControls {
    public static void main(String[] args) throws Exception{
        Workbook wb = new Workbook();
        wb.loadFromFile("data/InsertControls.xlsx");

        Worksheet ws = wb.getWorksheets().get(0);
        //Add a text box
        ITextBoxShape textbox = ws.getTextBoxes().addTextBox(9, 2, 25, 100);
        textbox.setText("Hello World");
        //Add a checkbox
        ICheckBox cb = ws.getCheckBoxes().addCheckBox(11, 2, 15, 100);
        cb.setCheckState(CheckState.Checked);
        cb.setText("Check Box 1");
        //Add a Radio Button
        IRadioButton rb = ws.getRadioButtons().add(13, 2, 15, 100);
        rb.setText("Option 1");

        //Add a combox
        IComboBoxShape cbx = (IComboBoxShape)ws.getComboBoxes().addComboBox(15, 2, 15, 100);
        cbx.setListFillRange(ws.getRange().get("A41:A47"));

        wb.saveToFile("output/insertControls_result.xlsx", ExcelVersion.Version2010);

    }
}
