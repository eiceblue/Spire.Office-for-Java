import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.XlsName;

import java.io.FileWriter;
import java.io.IOException;

public class getsCommentInNameManager {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file "GetNotesInformation.xlsx" from the "data" directory
        workbook.loadFromFile("data/GetNotesInformation.xlsx");

        // Access the NameRanges property of the workbook
        INameRanges nameManager = workbook.getNameRanges();

        // Create a StringBuilder to store the result
        StringBuilder sb = new StringBuilder();

        // Iterate through each name in the NameRanges collection
        for (int i = 0; i < nameManager.getCount(); i++)
        {
            // Get the XlsName object at index i
            XlsName name = (XlsName)nameManager.get(i);

            // Append the name and comment value to the StringBuilder
            sb.append("Name: " + name.getName() + ", Comment: " + name.getCommentValue() + "\r\n");
        }

        // Create a FileWriter object to write the result to a text file
        FileWriter fw = new FileWriter("output\\GetsCommentInNameManager.txt");
        fw.write(sb.toString());
        fw.flush();
        fw.close();

        // Dispose of the workbook object
        workbook.dispose();
    }
}
