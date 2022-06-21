import java.io.*;

import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class extractTextFromATextbox {
    public static void main(String[] args) throws IOException {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_5.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first textbox
        XlsTextBoxShape shape = (XlsTextBoxShape) sheet.getTextBoxes().get(0);

        //Extract text from the text box
        StringBuilder content = new StringBuilder();
        content.append("The text extracted from the TextBox is: \r\n");
        content.append(shape.getText());

        //Save to file
        String result = "output/extractTextFromATextbox_result.txt";
        FileWriter fw = new FileWriter(result, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(content);
        bw.close();
        fw.close();
    }
}
