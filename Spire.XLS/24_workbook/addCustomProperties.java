import java.util.*;

import com.spire.xls.*;

public class addCustomProperties {
    public static void main(String[] args) {
        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/addCustomProperties.xlsx");

        //Add a custom property to make the document as final
        workbook.getCustomDocumentProperties().add("_MarkAsFinal", true);

        //Add other custom properties to the workbook
        workbook.getCustomDocumentProperties().add("The Editor", "E-iceblue");
        workbook.getCustomDocumentProperties().add("Phone number", 81705109);
        workbook.getCustomDocumentProperties().add("Revision number", 7.12);
        workbook.getCustomDocumentProperties().add("Revision date", new Date());

        //Save the document and launch it
        String output = "output/addCustomProperties_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
