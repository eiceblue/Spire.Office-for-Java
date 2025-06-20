import com.spire.xls.*;
import com.spire.xls.core.IOleObject;
import java.io.*;

public class extractEmfOLEObjects {
    public static void main(String[] args) {
        // Create a Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from a file
        workbook.loadFromFile("data/EmfOle.xlsx");

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Check if the worksheet has OLE objects
        if (sheet.hasOleObjects()) {

            // Iterate over all OLE objects
            for (int i = 0; i < sheet.getOleObjects().size(); i++) {

                // Get the current OLE object
                IOleObject oleObject = sheet.getOleObjects().get(i);

                // Get the type of the current OLE object
                OleObjectType oleObjectType = sheet.getOleObjects().get(i).getObjectType();

                // Process the OLE object based on its type
                switch (oleObjectType) {
                    case Emf:
                        // If the OLE object is of type EMF, save its data to a file
                        byteArrayToFile(oleObject.getOleData(), "output/"+i+".emf");
                        break;
                }
            }
        }
    }

    public static void byteArrayToFile(byte[] datas, String destPath) {
        // Create a destination file object
        File dest = new File(destPath);
        try (InputStream is = new ByteArrayInputStream(datas);
             OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));) {

            // Create a buffer
            byte[] flush = new byte[1024];
            int len = -1;

            // Write data from the input stream to the output stream
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }

            // Flush the output stream
            os.flush();
        } catch (IOException e) {

            // Print the exception information
            e.printStackTrace();
        }
    }
}
