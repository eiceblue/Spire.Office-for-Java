import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.xmp.XmpMetadata;

import java.util.Date;

public class setXMPMetadata {
    public static void main(String[] args) {
        String inputFile = "data/setXMPMetadata.pdf";
        String outputFile = "output/setXMPMetadata_result.pdf";

        //Open a pdf document
        PdfDocument document = new PdfDocument();
        document.loadFromFile(inputFile);

        //Set xmpMetadata
        XmpMetadata meta = document.getXmpMetaData();
        meta.setAuthor("E-iceblue");
        meta.setTitle("Set XMP Metadata in PDF");
        meta.setSubject("XMP Metadata");
        meta.setProducer("E-icenlue Co,.Ltd");
        meta.setCreateDate(new Date());
        meta.setCreator("Spire.PDF");
        meta.setKeywords("XMP");
        meta.setModifyDate(new Date());
        meta.setCustomProperty("Field1", "NewValue");

        document.saveToFile(outputFile, FileFormat.PDF);
        document.close();
    }
}
