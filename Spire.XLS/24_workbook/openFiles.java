import java.io.*;

import com.spire.xls.*;

public class openFiles {
    public static void main(String[] args) throws IOException {
        //Pathes of files
        String filepath = "data/excelSample_N1.xlsx";
        String filepath97 = "data/excelSample97_N.xls";
        String filepathXml = "data/officeOpenXML_N.xml";
        String filepathCsv = "data/CSVSample_N.csv";

        //1. Load file by file path
        //Create a workbook
        Workbook workbook1 = new Workbook();
        //Load the document from disk
        workbook1.loadFromFile(filepath);
        System.out.println("Workbook opened using file path successfully!");

        //2. Load file by file stream
        FileInputStream stream = new FileInputStream(filepath);
        //Create a workbook
        Workbook workbook2 = new Workbook();
        //Load the document from disk
        workbook2.loadFromStream(stream);
        System.out.println("Workbook opened using file stream successfully!");
        stream.close();

        //3. Open Microsoft Excel 97 - 2003 file
        Workbook wbExcel97 = new Workbook();
        wbExcel97.loadFromFile(filepath97, ExcelVersion.Version97to2003);
        System.out.println("Microsoft Excel 97 - 2003 workbook opened successfully!");

        //4. Open xml file
        Workbook wbXML = new Workbook();
        wbXML.loadFromXml(filepathXml);
        System.out.println("XML file opened successfully!");

        //5. Open csv file
        Workbook wbCSV = new Workbook();
        wbCSV.loadFromFile(filepathCsv, ",", 1, 1);
        System.out.println("CSV file opened successfully!");
    }
}
