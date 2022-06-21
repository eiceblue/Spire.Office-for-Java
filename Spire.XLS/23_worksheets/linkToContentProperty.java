import com.spire.xls.*;
import com.spire.xls.core.*;

public class linkToContentProperty {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/accessDocumentProperties.xlsx");

        //Add a custom document property
        workbook.getCustomDocumentProperties().add("Test", "MyNamedRange");

        //Get the added document property
        ICustomDocumentProperties properties = workbook.getCustomDocumentProperties();
        DocumentProperty property = (DocumentProperty) properties.get("Test");

        //Link to content 
        property.setLinkToContent(true);

        //Save the document
        String result = "output/linkToContentProperty_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
