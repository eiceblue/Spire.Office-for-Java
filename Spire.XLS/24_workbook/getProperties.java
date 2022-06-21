import com.spire.xls.*;
import com.spire.xls.collections.*;
import com.spire.xls.core.*;

import java.io.*;

public class getProperties {
    public static void main(String[] args) throws IOException {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the document from disk
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Get the general excel properties
        BuiltInDocumentProperties properties1 = workbook.getDocumentProperties();
        StringBuilder sb = new StringBuilder();
        sb.append("Excel Properties:\r\n");
        for (int i = 0; i < properties1.getCount(); i++) {
            String name = properties1.get(i).getName();
            String value = properties1.get(i).getValue().toString();
            sb.append(name + ": " + value + "\r\n");
        }
        sb.append("\r\n");

        // Get the custom properties
        ICustomDocumentProperties properties2 = workbook.getCustomDocumentProperties();
        sb.append("Custom Properties:\r\n");
        for (int i = 0; i < properties2.getCount(); i++) {
            String name = properties2.get(i).getName();
            String value = properties2.get(i).getValue().toString();
            sb.append(name + ": " + value + "\r\n");
        }
        // Save the document
        String output = "output/getProperties_result.txt";
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(sb);
        bw.close();
        fw.close();
    }
}
