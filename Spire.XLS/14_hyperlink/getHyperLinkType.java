import com.spire.xls.*;
import java.io.*;

public class getHyperLinkType {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/hyperlinksSample2.xlsx";
        String outputFile = "output/getHyperLinkType_result.txt";

        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a StringBuilder to store the hyperlink information
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate over each hyperlink in the worksheet
        for (HyperLink item : (Iterable<HyperLink>) sheet.getHyperLinks()) {

            // Get the address of the hyperlink
            String address = item.getAddress();

            // Get the type of the hyperlink
            HyperLinkType type = item.getType();

            // Append the hyperlink address and type to the StringBuilder
            stringBuilder.append("Link address: " + address + "\r\n");
            stringBuilder.append("Link type: " + type.toString() + "\r\n");
        }

        // Write the contents of the StringBuilder to a text file
        writeStringToTxt(stringBuilder.toString(), outputFile);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
    /**
     * Writes a string content to a text file.
     *
     * @param content     The content to be written
     * @param txtFileName The name of the text file
     * @throws IOException If an I/O error occurs
     */
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file = new File(txtFileName);
        if (file.exists()) {
            file.delete();
        }
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
