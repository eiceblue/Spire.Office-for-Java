import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class extractOLE {
    public static void main(String[] args) throws IOException {
        String input = "data/extractOLE.docx";

        //create document and load file from disk
        Document doc = new Document();
        doc.loadFromFile(input);

        //traverse through all sections of the word document
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            Section sec = doc.getSections().get(i);
            //traverse through all Child Objects in the body of each section
            for (int j = 0; j < sec.getBody().getChildObjects().getCount(); j++) {
                DocumentObject obj = sec.getBody().getChildObjects().get(j);
                //find the paragraph
                if (obj instanceof Paragraph) {
                    Paragraph par = (Paragraph) obj;
                    for (int k = 0; k < par.getChildObjects().getCount(); k++) {
                        DocumentObject o = par.getChildObjects().get(k);
                        //check whether the object is OLE
                        if (o.getDocumentObjectType() == DocumentObjectType.Ole_Object) {
                            DocOleObject Ole = (DocOleObject) o;
                            String s = Ole.getObjectType();

                            //check whether the object type is "AcroExch.Document.DC"
                            if ("AcroExch.Document.DC".equals(s)) {
                                //write the data of OLE into file
                                writeBytesToFile( Ole.getNativeData(),"output/pdfResult.pdf");
                            }

                            //check whether the object type is "Excel.Sheet.8"
                            else if ("Excel.Sheet.8".equals(s)) {
                                writeBytesToFile( Ole.getNativeData(),"output/excelResult.xls");
                            }

                            //check whether the object type is "PowerPoint.Show.12"
                            else if ("PowerPoint.Show.12".equals(s)) {
                                writeBytesToFile( Ole.getNativeData(),"output/pptResult.pptx");
                            }
                        }
                    }
                }
            }
        }
    }

    private static void writeBytesToFile(byte[] data,String fileName) throws IOException {
        OutputStream out= new FileOutputStream(fileName);
        InputStream is= new ByteArrayInputStream(data);
        byte[] buff= new byte[1024];
        int len=0;
        while((len=is.read(buff))!=-1) {
            out.write(buff,0,len);
        }
        is.close();
        out.close();
    }
}
