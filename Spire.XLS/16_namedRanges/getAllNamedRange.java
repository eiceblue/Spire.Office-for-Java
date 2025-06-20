import com.spire.xls.*;
import com.spire.xls.core.*;
import java.io.*;

public class getAllNamedRange {
    public static void main(String[] args) throws IOException {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/getAllNamedRange_result.txt";

        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Create a StringBuilder object to store the results
        StringBuilder stringBuilder = new StringBuilder();

        // Get the collection of named ranges from the workbook
        INameRanges ranges = workbook.getNameRanges();

        // Iterate over each named range in the collection
        for (INamedRange nameRange : (Iterable<INamedRange>) ranges)
        {
            // Append the name of the current named range to the StringBuilder, followed by a new line character
            stringBuilder.append(nameRange.getName() + "\r\n");
        }

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
