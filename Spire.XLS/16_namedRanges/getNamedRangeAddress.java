import com.spire.xls.Workbook;
import com.spire.xls.core.INamedRange;
import java.io.*;

public class getNamedRangeAddress {
    public static void main(String[] args) throws IOException {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/getNamedRangeAddress_result.txt";

        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Create a StringBuilder object to store the results
        StringBuilder stringBuilder = new StringBuilder();

        // Get the first named range from the workbook
        INamedRange namedRange = workbook.getNameRanges().get(0);

        // Get the address of the range referred to by the named range
        String address = namedRange.getRefersToRange().getRangeAddress();

        // Append the information about the named range and its address to the StringBuilder
        stringBuilder.append("The address of the named range " + namedRange.getName() + " is " + address);

        // Write the contents of the StringBuilder to a text file using the writeStringToTxt function
        writeStringToTxt(stringBuilder.toString(), outputFile);

        // Dispose of the workbook object and release any associated resources
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
        File file=new File(txtFileName);
        if (file.exists())
        {
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
