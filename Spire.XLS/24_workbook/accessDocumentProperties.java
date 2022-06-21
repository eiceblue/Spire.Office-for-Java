import java.io.*;

import com.spire.xls.*;
import com.spire.xls.core.*;

public class accessDocumentProperties {
    public static void main(String[] args) throws IOException {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/accessDocumentProperties.xlsx");

        //Create string builder
        StringBuilder builder = new StringBuilder();

        //Get all document properties
        ICustomDocumentProperties properties = workbook.getCustomDocumentProperties();

        //Access document property by property name
        DocumentProperty property1 = (DocumentProperty) properties.get("Editor");
        builder.append(property1.getName() + " " + property1.getValue() + "\r\n");

        //Access document property by property index
        DocumentProperty property2 = (DocumentProperty) properties.get(0);
        builder.append(property2.getName() + " " + property2.getValue() + "\r\n");

        //Save to txt file
        String output = "output/accessDocumentProperties_result.xlsx";
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(builder);
        bw.close();
        fw.close();
    }
}
