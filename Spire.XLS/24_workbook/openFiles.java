import java.io.*;
import com.spire.xls.*;

public class openFiles {
    public static void main(String[] args) throws IOException {
        String filepath = "data/excelSample_N1.xlsx";
        String filepath97 = "data/excelSample97_N.xls";
        String filepathXml = "data/officeOpenXML_N.xml";
        String filepathCsv = "data/CSVSample_N.csv";

        // Create a new workbook object
        Workbook workbook1 = new Workbook();
        // Load the workbook from a file path
        workbook1.loadFromFile(filepath);
        // Print a success message
        System.out.println("Workbook opened using file path successfully!");
        // Dispose of the workbook object
        workbook1.dispose();

        // Create a file input stream for the file
        FileInputStream stream = new FileInputStream(filepath);
        // Create a new workbook object
        Workbook workbook2 = new Workbook();
        // Load the workbook from the stream
        workbook2.loadFromStream(stream);
        // Print a success message
        System.out.println("Workbook opened using file stream successfully!");
        // Close the file input stream
        stream.close();
        // Dispose of the workbook object
        workbook2.dispose();

        // Create a new workbook object for Excel 97-2003 format
        Workbook wbExcel97 = new Workbook();
        // Load the workbook from a file path with specified version
        wbExcel97.loadFromFile(filepath97, ExcelVersion.Version97to2003);
        // Print a success message
        System.out.println("Microsoft Excel 97 - 2003 workbook opened successfully!");
        // Dispose of the workbook object
        wbExcel97.dispose();

        // Create a new workbook object for XML format
        Workbook wbXML = new Workbook();
        // Load the workbook from an XML file
        wbXML.loadFromXml(filepathXml);
        // Print a success message
        System.out.println("XML file opened successfully!");
        // Dispose of the workbook object
        wbXML.dispose();

        // Create a new workbook object for CSV format
        Workbook wbCSV = new Workbook();
        // Load the workbook from a CSV file with specified delimiter and starting row/column
        wbCSV.loadFromFile(filepathCsv, ",", 1, 1);
        // Print a success message
        System.out.println("CSV file opened successfully!");
        // Dispose of the workbook object
        wbCSV.dispose();
    }
}
