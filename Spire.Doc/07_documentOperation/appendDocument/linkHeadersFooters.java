import com.spire.doc.*;

public class linkHeadersFooters {
    public static void main(String[] args) {
        //Load the source file
        Document srcDoc = new Document();
        srcDoc.loadFromFile("data/Template_N1.docx");

        //Load the destination file
        Document dstDoc = new Document();
        dstDoc.loadFromFile("data/Template_N2.docx");

        //Link the headers and footers in the source file
        srcDoc.getSections().get(0).getHeadersFooters().getHeader().setLinkToPrevious(true);
        srcDoc.getSections().get(0).getHeadersFooters().getFooter().setLinkToPrevious(true);

        //Clone the sections of source to destination
        for (Object sectionObj : srcDoc.getSections()) {
            Section section=(Section)sectionObj;
            dstDoc.getSections().add(section.deepClone());
        }

        //Save the document
        String output="output/linkHeadersFooters.docx";
        dstDoc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose te documents
        srcDoc.dispose();
        dstDoc.dispose();
    }
}
