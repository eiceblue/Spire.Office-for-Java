import java.io.*;
import com.spire.xls.*;

public class readStream {
    public static void main(String[] args) throws Exception {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Open the input file stream for reading the Excel file
        FileInputStream fileStream = new FileInputStream("data/readStream.xlsx");

        // Load the workbook from the input stream
        workbook.loadFromStream(fileStream);

        // Specify the output file path for saving the result
        String output = "output/readStream_result.xlsx";

        // Save the workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
