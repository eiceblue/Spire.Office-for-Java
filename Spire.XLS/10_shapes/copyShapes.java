import com.spire.xls.*;
import com.spire.xls.core.*;

public class copyShapes {
    public static void main(String[] args) throws Exception {
        String output = "output/copyShapes.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //create line shape
        ILineShape line = sheet.getTypedLines().addLine();
        line.setTop(50);
        line.setLeft(30);
        line.setWidth( 30);
        line.setHeight(50);
        line.setBeginArrowHeadStyle( ShapeArrowStyleType.LineArrowDiamond);
        line.setEndArrowHeadStyle( ShapeArrowStyleType.LineArrow);

        //get the second worksheet
        Worksheet CopyShapes = workbook.getWorksheets().get(1);

        //copy the line into the second worksheet
        CopyShapes.getTypedLines().addCopy(line);

        //create a button and then copy into other sheet
        IRadioButton button = sheet.getTypedRadioButtons().add(5, 5, 20, 20);
        CopyShapes.getTypedRadioButtons().addCopy(button);

        //create a textbox and then copy into other sheet
        ITextBoxLinkShape textbox = sheet.getTypedTextBoxes().addTextBox(5, 7, 50, 100);
        CopyShapes.getTypedTextBoxes().addCopy(textbox);

        //create a checkbox and then copy into other sheet
        ICheckBox checkbox = sheet.getTypedCheckBoxes().addCheckBox(10, 1, 20, 20);
        CopyShapes.getTypedCheckBoxes().addCopy(checkbox);

        //create a comboboxes and then copy into other sheet
        sheet.getCellRange("A14").setValue( "1");
        sheet.getCellRange("A15").setValue ("2");
        IComboBoxShape ComboBoxes = sheet.getTypedComboBoxes().addComboBox(10, 5, 30, 30);
        ComboBoxes.setListFillRange( sheet.getCellRange("A14:A15"));
        CopyShapes.getTypedComboBoxes().addCopy(ComboBoxes);

        //save the file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
