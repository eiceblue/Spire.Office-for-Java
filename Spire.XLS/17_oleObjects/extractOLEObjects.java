import com.spire.xls.*;
import com.spire.xls.core.IOleObject;
import java.io.*;

public class extractOLEObjects {
    public static void main(String[] args) {
        String inputFile = "data/extractOle2.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from an input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Check if the worksheet has any OLE objects
        if (sheet.hasOleObjects()) {
            // Iterate through each OLE object in the worksheet
            for (int i = 0; i < sheet.getOleObjects().size(); i++) {
                // Get the current OLE object
                IOleObject Object = sheet.getOleObjects().get(i);

                // Get the type of the OLE object
                OleObjectType type = sheet.getOleObjects().get(i).getObjectType();

                // Perform different actions based on the type of the OLE object
                switch (type) {
                    case WordDocument:
                        // Extract the OLE data and save it as a Word document file
                        byteArrayToFile(Object.getOleData(), "output/extractOLE.docx");
                        break;
                    case PowerPointSlide:
                        // Extract the OLE data and save it as a PowerPoint slide file
                        byteArrayToFile(Object.getOleData(), "output/extractOLE.pptx");
                        break;
                    case AdobeAcrobatDocument:
                        // Extract the OLE data and save it as a PDF document file
                        byteArrayToFile(Object.getOleData(), "output/extractOLE.pdf");
                        break;
                }
            }
        }
        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
    // Method to write a byte array to a file
    public static void byteArrayToFile(byte[] data, String destPath) {
        // Create a File object with the specified destination path
        File dest = new File(destPath);

        try (
                // Create an InputStream from the byte array using ByteArrayInputStream
                InputStream is = new ByteArrayInputStream(data);

                // Create an OutputStream for writing to the file, with buffering, using FileOutputStream
                OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));
        ) {
            // Create a byte array for flushing data
            byte[] flush = new byte[1024];

            int len = -1;
            // Read data from the input stream and write it to the output stream in chunks
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }

            // Flush the output stream to ensure all data is written
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
