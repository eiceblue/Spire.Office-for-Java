import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class extractOLE {
    public static void main(String[] args) {
        // Create a new instance of the Document class
        Document doc = new Document();

        // Load the input file from disk into the document
        doc.loadFromFile("data/extractOLE.docx");

        // Traverse through all sections of the document
        for (int s = 0; s < doc.getSections().getCount(); s++) {
            Section section = doc.getSections().get(s);

            // Traverse through all child objects in the body of each section
            for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++) {
                DocumentObject obj = section.getBody().getChildObjects().get(i);

                // Check whether the object is a paragraph
                if (obj instanceof Paragraph) {
                    Paragraph par = (Paragraph) obj;

                    // Traverse through all child objects in the paragraph
                    for (int j = 0; j < par.getChildObjects().getCount(); j++) {
                        DocumentObject o = par.getChildObjects().get(j);

                        // Check whether the object is an OLE object
                        if (o.getDocumentObjectType() == DocumentObjectType.Ole_Object) {
                            DocOleObject ole = (DocOleObject) o;

                            // Get the type of the OLE object
                            String type = ole.getObjectType();

                            // Check whether the object type is "Acrobat.Document.11"
                            if ("AcroExch.Document.DC".equals(type)) {
                                // Write the data of the OLE object to a PDF file
                                byteArrayToFile(ole.getNativeData(), "output/extractOLE.pdf");
                            }

                            // Check whether the object type is "Excel.Sheet.8"
                            else if ("Excel.Sheet.8".equals(type)) {
                                // Write the data of the OLE object to an Excel file
                                byteArrayToFile(ole.getNativeData(), "output/extractOLE.xls");
                            }

                            // Check whether the object type is "PowerPoint.Show.12"
                            else if ("PowerPoint.Show.12".equals(type)) {
                                // Write the data of the OLE object to a PowerPoint file
                                byteArrayToFile(ole.getNativeData(), "output/extractOLE.pptx");
                            }
                        }
                    }
                }
            }
        }

        // Dispose of the document to release any resources it is using
        doc.dispose();
    }

    public static void byteArrayToFile(byte[] datas, String destPath) {
        // Create a File object with the destination path
        File dest = new File(destPath);

        try (
                // Create an InputStream from the byte array
                InputStream is = new ByteArrayInputStream(datas);

                // Create an OutputStream to write data to the file
                OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));
        ) {
            // Create a buffer to read data in chunks
            byte[] flush = new byte[1024];
            int len = -1;

            // Read data from the InputStream and write it to the OutputStream
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }

            // Flush any remaining data in the OutputStream
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
