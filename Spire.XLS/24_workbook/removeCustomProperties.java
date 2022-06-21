import com.spire.xls.*;
import com.spire.xls.core.*;

public class removeCustomProperties {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a excel document
        workbook.loadFromFile("data/templateAz.xlsx");

        //Retrieve a list of all custom document properties of the Excel file
        ICustomDocumentProperties customDocumentProperties = workbook.getCustomDocumentProperties();

        //Remove "Editor" custom document property
        customDocumentProperties.remove("Editor");

        String result = "output/removeCustomProperties_result.xlsx";
        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
