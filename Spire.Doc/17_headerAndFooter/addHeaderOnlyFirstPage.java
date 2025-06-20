import com.spire.doc.*;

public class addHeaderOnlyFirstPage {
    public static void main(String[] args) {
        String input1 = "data/headerSample.docx";
        String input2 = "data/multiPages.docx";
        String output = "output/addHeaderOnlyFirstPage.docx";

        // Create a new Document object and load the document from input1 file
        Document doc1 = new Document();
        doc1.loadFromFile(input1);

        // Get the header of the first section in doc1
        HeaderFooter header = doc1.getSections().get(0).getHeadersFooters().getHeader();

        // Create a new Document object and load the document from input2 file
        Document doc2 = new Document();
        doc2.loadFromFile(input2);

        // Get the first page header of the first section in doc2
        HeaderFooter firstPageHeader = doc2.getSections().get(0).getHeadersFooters().getFirstPageHeader();

        // Iterate through each section in doc2
        for (int i = 0; i < doc2.getSections().getCount(); i++) {
            // Set different first page header/footer for each section in doc2
            doc2.getSections().get(i).getPageSetup().setDifferentFirstPageHeaderFooter(true);
        }

        // Clear the paragraphs in the firstPageHeader
        firstPageHeader.getParagraphs().clear();

        // Copy the child objects from header to firstPageHeader
        for (int j = 0; j < header.getChildObjects().getCount(); j++) {
            // Get the current child object in header
            DocumentObject obj = header.getChildObjects().get(j);

            // Deep clone the child object and add it to firstPageHeader
            firstPageHeader.getChildObjects().add(obj.deepClone());
        }

        // Save the modified doc2 to the output file in Docx format
        doc2.saveToFile(output, FileFormat.Docx);

        // Dispose of the doc1 and doc2 objects to release resources
        doc1.dispose();
        doc2.dispose();
    }
}
