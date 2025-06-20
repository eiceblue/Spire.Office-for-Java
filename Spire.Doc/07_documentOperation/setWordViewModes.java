import com.spire.doc.*;
public class setWordViewModes {
    public static void main(String[] args){
        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified file path
        document.loadFromFile("data/Template_Docx_1.docx");

        // Set the document view type to "Web_Layout"
        document.getViewSetup().setDocumentViewType(DocumentViewType.Web_Layout);

        // Set the zoom percentage to 150%
        document.getViewSetup().setZoomPercent(150);

        // Set the zoom type to "None"
        document.getViewSetup().setZoomType(ZoomType.None);

        // Specify the output file path
        String result = "output/setWordViewModes_out.docx";

        // Save the modified document to the output file path in Docx format (compatible with Word 2013)
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose the document object to release resources
        document.dispose();
    }
}
