import com.spire.pdf.graphics.*;
import com.spire.pdf.htmlconverter.LoadHtmlType;
import com.spire.pdf.htmlconverter.qt.*;
import java.io.*;

public class htmlToPDF {
    public static void main(String[] args) throws IOException {
        convertUrlToPdf();
        convertHtmlStringToPdf();
    }

    private static void convertUrlToPdf(){
        // URL of the HTML page to be converted
        String url = "https://www.baidu.com";

        // File path for the output PDF file
        String fileName = "output/output.pdf";

        // Path to the plugins folder (optional, only required if using custom plugins)
        String pluginPath = "data/plugins";

        // Set the plugin path for HtmlConverter
        HtmlConverter.setPluginPath(pluginPath);

        // Convert the HTML page to PDF and save it to the specified file
        HtmlConverter.convert(url, fileName, true, 1000000, new Size(1200f, 1000f), new PdfMargins(0));
    }

    private static void convertHtmlStringToPdf() throws IOException {
        // Read the HTML contents from the specified HTML file
        String htmlString = HtmlToString("Sample.html");

        // Specify the output file path for the converted PDF
        String outputFile = "output/HtmlToPdf.pdf";

        // Specify the path to the plugin directory (if required)
        String pluginPath = "plugins";

        // Set the plugin path for HTML conversion
        HtmlConverter.setPluginPath(pluginPath);

        // Convert the HTML string to a PDF document
        HtmlConverter.convert(htmlString, outputFile, true, 100000, new Size(700, 900), new PdfMargins(0), LoadHtmlType.Source_Code);
    }

    public static String HtmlToString(String filePath) throws IOException {
        // Store the file path
        String path = filePath;

        // Create a File object using the specified file path
        File file = new File(path);

        // Create a FileReader to read the file
        FileReader fileReader = new FileReader(file);

        // Create a BufferedReader to read the file line by line
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Initialize a StringBuilder to hold the contents of the file
        StringBuilder stringBuilder = new StringBuilder();

        // Temporary variable to store each line of the file
        String temp = "";

        // Read each line of the file and append it to the StringBuilder
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuilder.append(temp + "\n");
        }

        // Close the BufferedReader and FileReader
        bufferedReader.close();
        fileReader.close();

        // Convert the StringBuilder to a string
        String str = stringBuilder.toString();

        // Return the contents of the HTML file as a string
        return str;
    }
}
