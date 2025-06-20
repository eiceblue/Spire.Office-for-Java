import com.spire.pdf.*;

public class toHTMLFileseSplittedByPages {
    public static void main(String[] args) {
        //Create a pdf document.
        PdfDocument pdfDocument = new PdfDocument();
        
        //Load file from disk.
        pdfDocument.loadFromFile("data/Sample_2.pdf");
        
        //Set the conversion option to embed svg and image in html
        //pdfDocument.getConvertOptions().setPdfToHtmlOptions(true,true);
        
        //Split to HTML file according to pages, here one page will convert to a HTML file.
        pdfDocument.getConvertOptions().setPdfToHtmlOptions(true,true,1);
        
        //Save to html file.
        pdfDocument.saveToFile("output/result.html", FileFormat.HTML);

        // Close the PDF document to release resources.
        pdfDocument.close();

        // Dispose of the PDF document to free up system resources.
        pdfDocument.dispose();
    }
}
