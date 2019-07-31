import com.spire.doc.*;

public class toHtmlExportOption {
    public static void main(String[] args) {

        String inputFile="data/toHtmlTemplate.docx";
        String cssPath="toHtmlTemplate.css";
        String imagePath="output/images";
        String outputFile="output/toHtmlExportOption.html";

        Document document = new Document();
        document.loadFromFile(inputFile);
        //set whether the css styles are embedded or not.
        document.getHtmlExportOptions().setCssStyleSheetFileName(cssPath);
        document.getHtmlExportOptions().setCssStyleSheetType(CssStyleSheetType.External);

        //set whether the images are embedded or not.
        document.getHtmlExportOptions().setImageEmbedded(false);
        document.getHtmlExportOptions().setImagesPath(imagePath);

        //set whether exporting form fields as plain text or not.
        document.getHtmlExportOptions().isTextInputFormFieldAsText(true);

        //save the document to a html file.
        document.saveToFile(outputFile, FileFormat.Html);
    }
}
