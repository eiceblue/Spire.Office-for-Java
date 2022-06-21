import com.spire.xls.*;
import com.spire.xls.core.IOleObject;

import java.io.*;

public class extractOLEObjects {
    public static void main(String[] args) {
        String inputFile = "data/extractOle2.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Extract ole objects
        if (sheet.hasOleObjects())
        {
            for (int i = 0; i < sheet.getOleObjects().size(); i++)
            {
                IOleObject Object = sheet.getOleObjects().get(i);
                OleObjectType type = sheet.getOleObjects().get(i).getObjectType();
                switch (type)
                {
                    //Word document
                    case WordDocument:
                        byteArrayToFile(Object.getOleData(), "output/extractOLE.docx");
                        break;
                    //PowerPoint document
                    case PowerPointSlide:
                        byteArrayToFile(Object.getOleData(), "output/extractOLE.pptx");
                        break;
                    //PDF document
                    case AdobeAcrobatDocument:
                        byteArrayToFile(Object.getOleData(), "output/extractOLE.pdf");
                        break;
                }
            }
        }
    }
    public static void byteArrayToFile(byte[] datas, String destPath) {
        File dest = new File(destPath);
        try (InputStream is = new ByteArrayInputStream(datas);
             OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));) {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
