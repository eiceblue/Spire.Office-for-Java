import java.io.*;
import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class extractTextFromATextbox {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/template_Xls_5.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the first TextBox shape from the worksheet
        XlsTextBoxShape shape = (XlsTextBoxShape) sheet.getTextBoxes().get(0);

        // Create a StringBuilder to store the extracted text
        StringBuilder content = new StringBuilder();

        // Append a header message to the content StringBuilder
        content.append("The text extracted from the TextBox is: \r\n");

        // Append the text from the TextBox to the content StringBuilder
        content.append(shape.getText());

        // Specify the path for the output file
        String result = "output/extractTextFromATextbox_result.txt";

        // Create a FileWriter object to write to the output file
        FileWriter fw = new FileWriter(result, true);

        // Create a BufferedWriter object to efficiently write characters to the FileWriter
        BufferedWriter bw = new BufferedWriter(fw);

        // Append the content StringBuilder to the output file
        bw.append(content);

        // Close the BufferedWriter
        bw.close();

        // Close the FileWriter
        fw.close();

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
