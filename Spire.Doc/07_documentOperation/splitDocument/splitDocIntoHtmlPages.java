import com.spire.doc.*;
import com.spire.doc.documents.*;

public class splitDocIntoHtmlPages {
    public static void main(String[] args) throws Exception {
        String input = "data/splitDocIntoHtmlPages.doc";
        String outDir = "output";
        //Split a document into multiple html pages.
        SplitDocIntoMultipleHtml(input, outDir);
    }
    private static void SplitDocIntoMultipleHtml(String input, String outDirectory)
    {

        //Create a document
        Document document = new Document();

        //Load from specified path
        document.loadFromFile(input);

        Document subDoc = null;
        Boolean first = true;
        int index = 0;

        //
        for(int s =0 ;s<document.getSections().getCount();s++) {
            Section sec = document.getSections().get(s);
            for(int c =0 ;c< sec.getBody().getChildObjects().getCount();c++)
            {
                DocumentObject element =sec.getBody().getChildObjects().get(c);
                if (IsInNextDocument(element))
                {
                    if (!first)
                    {
                        //Embed css tyle and image data into html page
                        subDoc.getHtmlExportOptions().setCssStyleSheetType(CssStyleSheetType.Internal);
                        subDoc.getHtmlExportOptions().setImageEmbedded(true);
                        //Save to html file
                        subDoc.saveToFile(outDirectory+"/out-"+ index +".html",FileFormat.Html);
                        subDoc = null;
                    }
                    first = false;
                }
                if (subDoc == null)
                {
                    subDoc = new Document();
                    subDoc.addSection();
                }
                subDoc.getSections().get(0).getBody().getChildObjects().add(element.deepClone());
            }
        }
        if (subDoc != null)
        {
            //Embed css tyle and image data into html page
            subDoc.getHtmlExportOptions().setCssStyleSheetType(CssStyleSheetType.Internal);
            subDoc.getHtmlExportOptions().setImageEmbedded(true);
            index++;
            //Save to html file
            subDoc.saveToFile(outDirectory+"/out-"+ index +".html", FileFormat.Html);
            //Dispose the document
            subDoc.dispose();
        }
        //Dispose the document
        document.dispose();
    }
    private static Boolean IsInNextDocument(DocumentObject element)
    {
        if (element instanceof Paragraph)
        {
            Paragraph p = (Paragraph)element;
            if (p.getStyleName().equals("Heading1"))
            {
                return true;
            }
        }
        return false;
    }
}
