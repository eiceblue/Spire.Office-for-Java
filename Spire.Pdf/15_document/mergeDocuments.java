import com.spire.pdf.*;

public class mergeDocuments {
    public static void main(String[] args) {
        // Define an array of file paths representing the PDF documents to be merged
        String[] files = new String[] {
                "data/mergePdfsTemplate_1.pdf",
                "data/mergePdfsTemplate_2.pdf",
                "data/mergePdfsTemplate_3.pdf"
        };

        // Create an array of PdfDocument objects to store the loaded documents
        PdfDocument[] docs = new PdfDocument[files.length];

        // Load each PDF document and add it to the array
        for (int i = 0; i < files.length; i++) {
            docs[i] = new PdfDocument(files[i]);
        }

        // Initialize a new PdfDocument object to hold the merged document
        PdfDocument doc = new PdfDocument();

        // Append the first page from the first document to the merged document
        doc.appendPage(docs[0]);

        // Insert a range of pages from the second document into specific positions in the merged document
        doc.insertPageRange(docs[1], 1, 3);

        // Insert the first page from the third document at the beginning of the merged document
        doc.insertPage(docs[2], 0);

        // Save the merged document to a new PDF file "output/MergeDocuments.pdf"
        doc.saveToFile("output/MergeDocuments.pdf");

        // Close and dispose of system resources associated with the merged document
        doc.close();
        doc.dispose();

        // Close and dispose of system resources associated with each individual document used for merging
        for (int j = 0; j < docs.length; j++) {
            docs[j].close();
            docs[j].dispose();
        }
    }
}
